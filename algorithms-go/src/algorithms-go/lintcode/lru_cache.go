package lintcode

import (
	"container/list"
	"errors"
	"sync"
)

// CacheInterface 定义cache的接口类型，由具体的实现方式来时实现
type CacheInterface interface {

	// Get 从缓存中获取key对应的数据
	Get(key interface{}) (interface{}, error)

	// Set 设置key,val到缓存中
	Set(key interface{}, val interface{}) error

	// Del 删除相应的key
	Del(key interface{}) error

	// ListKeys 列举所有的key
	ListKeys() ([]interface{}, error)

	// GetAllData 获取缓存的所有数据
	GetAllData() ([]Node, error)

}

type Node struct {
	Key interface{}
	Value interface{}
}

type LruCache struct {

	maxCap int

	// 存储key，并根据key的使用情况更新key的位置
	// list是基于双向循环链表来实现的
	keyList *list.List

	// 存放数据的key和Element对象，其中element中的value是Node对象
	data map[interface{}]*list.Element
	mutex *sync.Mutex
}

// NewLruCache LruCache 列举所有缓存key
func NewLruCache(len int) *LruCache{

	return &LruCache{
		maxCap: len,
		keyList: list.New(),
		data: make(map[interface{}]*list.Element),
		mutex: new(sync.Mutex),
	}
}

// Get LruCache 获取缓存中指定的key
func (lru *LruCache)Get(key interface{}) (interface{}, error) {

	if lru.data == nil {
		return nil, errors.New("the LruCache not init")
	}

	lru.mutex.Lock()
	defer lru.mutex.Unlock()

	// 判断key是否存在于map中，存在，ok为true，val为值，不存在ok为false
	if ele, ok := lru.data[key]; ok {
		// 需要更新该key对应的位置
		lru.keyList.MoveToFront(ele)
		return ele.Value.(*Node).Value, nil
	} else {
		return nil, errors.New("the key not exist")
	}
}

// Set LruCache 将key和val设置到缓存中
func (lru *LruCache)Set(key interface{}, val interface{}) error{

	if lru.data == nil {
		return errors.New("the LruCache not init")
	}

	lru.mutex.Lock()
	defer lru.mutex.Unlock()

	// 判断key是否存在于map中，存在，ok为true，val为值，不存在ok为false
	if ele, ok := lru.data[key]; ok {
		ele.Value = val
		// 更新缓存中的值
		lru.data[key] = ele
		// 需要更新该key对应的位置
		lru.keyList.MoveToFront(ele)
		return nil
	}

	// 实际上push进去的是element对象
	ele := lru.keyList.PushFront(&Node{
		Key: key,
		Value: val,
	})
	// data中存放的实际上是keyList中的element节点，因此这个节点记录了其在keyList中的位置（prev,next）
	lru.data[key] = ele

	// 表示缓存的数据量已经达到预设的上限，需要删除最近最久未使用的元素
	if lru.maxCap > 0 && len(lru.data) > lru.maxCap {
		// keyList中存储的key就是从头到尾按照最近使用时间排序的，在font的就是最近使用的，back的就是最久未使用的
		if k := lru.keyList.Back(); k != nil {
			lru.keyList.Remove(k)

			// 强制转换为*Node类型
			node := k.Value.(*Node)
			delete(lru.data, node.Key)
		}
	}

	return nil
}

// Del LruCache 删除缓存中的key和对应的val
func (lru *LruCache)Del(key interface{}) error{

	if lru.data == nil {
		return errors.New("the LruCache not init")
	}

	lru.mutex.Lock()
	defer lru.mutex.Unlock()

	if ele, ok := lru.data[key]; ok {
		// 如果key存在，则删除data中的key和val
		delete(lru.data, key)

		// 也要删除keyList中的值
		lru.keyList.Remove(ele)
	}

	return nil
}

// ListKeys LruCache 列举所有缓存key
func (lru *LruCache)ListKeys() ([]interface{}, error){

	if lru.data == nil {
		return nil, errors.New("the LruCache not init")
	}

	var keys []interface{}

	for font := lru.keyList.Front(); font != nil; font = font.Next() {
		keys = append(keys, font.Value.(*Node).Key)
	}

	return keys, nil
}

func (lru *LruCache)GetAllData() ([]Node, error)  {
	if lru.data == nil {
		return nil, errors.New("the LruCache not init")
	}

	var nodes []Node

	for font := lru.keyList.Front(); font != nil; font = font.Next() {
		nodes = append(nodes, *font.Value.(*Node))
	}

	return nodes, nil
}


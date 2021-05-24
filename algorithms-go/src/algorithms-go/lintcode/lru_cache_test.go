package lintcode

import (
	"fmt"
	"math/rand"
	"testing"
)

var lru *LruCache


func TestLruCache_New(t *testing.T) {

	lru = NewLruCache(10)

}

func TestLruCache_Set(t *testing.T) {

	TestLruCache_New(t)

	key := fmt.Sprintf("keys%d", rand.Int())
	val := fmt.Sprintf("%f", rand.Float64())

	lru.Set(key, val)

}

func TestLruCache_Get(t *testing.T) {

	TestLruCache_New(t)

	keys, err := lru.ListKeys()
	if err != nil {
		println("Test Failed: list keys= error: " + err.Error())
		return
	}

	lru.Get(keys[rand.Intn(len(keys))])

}

func TestLruCache_Del(t *testing.T) {

	TestLruCache_New(t)

	keys, err := lru.ListKeys()
	if err != nil {
		println("Test Failed: list keys= error: " + err.Error())
		return
	}

	lru.Del(keys[rand.Intn(len(keys))])

}

func TestLruCache_ListKeys(t *testing.T) {

	TestLruCache_New(t)

	keys, err := lru.ListKeys()
	if err != nil {
		println("Test Failed: list keys= error: " + err.Error())
		return
	}

	for _, val := range keys {
		fmt.Printf("%v\n", val)
	}

}

func TestLruCache_GetAllData(t *testing.T) {

	TestLruCache_New(t)

	nodes, err := lru.GetAllData()
	if err != nil {
		println("Test Failed: list keys= error: " + err.Error())
		return
	}

	for _, node := range nodes {
		fmt.Printf("%v\n", node)
	}

}

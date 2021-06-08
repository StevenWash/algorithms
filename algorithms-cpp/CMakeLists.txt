cmake_minimum_required(VERSION 3.15)

set(CMAKE_CXX_STANDARD 11)
set(PROJECT_NAME algorithm_cpp)

project(${PROJECT_NAME})

aux_source_directory(. DIR_SRCS)
message("DIR_SRCS: " ${DIR_SRCS})

add_subdirectory(./leetcode)

add_executable(${PROJECT_NAME} ${DIR_SRCS})

set(PROJECT_LINK_LIBS
        leetcode
        )

target_link_libraries(${PROJECT_NAME} ${PROJECT_LINK_LIBS})
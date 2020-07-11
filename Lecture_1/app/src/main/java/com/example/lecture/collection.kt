package com.example.kotlin

fun main() {

    /**
     * 컬렉션은 크게 세가지로 List, Map, Set이 있습니다.
     */

    /**
     * 리스트는 List, mutableList가 있습니다.
     * List는 array처럼 공간의 제약이 있으면서 array와는 달리 값의 수정이 되지 않는 read-only이므로 사용할 일이 별로 없으므로
     * mutableList을 사용한다고 알아두면 됩니다
     *
     * mutableList는 공간의 제약도 없고 값의 수정 및 삭제도 자유롭기때문에 유용하게 쓰입니다.
     */

//    빈 리스트를 선언할때는 값이 없으므로 타입 추론을 못하므로 명시적으로 알려줘야합니다
    var intMutableList = mutableListOf<Int>(0,1,2,3)

//    타입추론이 자동으로 일어나므로 타입을 생략해도 됩니다
    var intMutableList2 = mutableListOf(0,1,2,3)
    println("Array size : ${intMutableList2.size}")
    println("Last index : ${intMutableList2.lastIndex}")
    println(intMutableList2)

//    자동으로 마지막에 값이 추가되며 공간이 확장됩니다.
    intMutableList2.add(4)
    println("Array size : ${intMutableList2.size}")
    println("Last index : ${intMutableList2.lastIndex}")
    println(intMutableList2)

//    인덱스를 이용하여 값의 삭제가 가능. 삭제를 하면 인덱스가 하나씩 감소하면서 빈자의 인덱스로 이동합니다
    intMutableList2.removeAt(0)
    println("Array size : ${intMutableList2.size}")
    println("Last index : ${intMutableList2.lastIndex}")
    println(intMutableList2)

//    값을 이용하여 삭제가 가능. 삭제를 하면 인덱스가 하나씩 감소하면서 빈자의 인덱스로 이동합니다
    intMutableList2.remove(1)
    println("Array size : ${intMutableList2.size}")
    println("Last index : ${intMutableList2.lastIndex}")
    println(intMutableList2)

//    여러 타입을 함께 사용이 가능합니다
    var mixMutableList = mutableListOf(0,'a',"b",3)
    println(mixMutableList)


    /**
     * Set은 중복을 허용하지 않으며 순서가 없는 list라고 생각하면됩니다.
     * 하지만 순서가 없기때문에 인덱스로 조회할 수 없습니다.
     */

//    var set = mutableSetOf<String>()
    var set = mutableSetOf("A", "B", "C", "A", "D")
    println(set)
    set.add("B")
    println(set)
    set.remove("A")
    println(set)

    /**
     * Map은 키와 값이 쌍을 이루어서 입력되는 컬렉션입니다.
     * key는 list의 index의 역할을 합니다
     */

//    var map = mutableMapOf<String, String>()
    var map = mutableMapOf(Pair("key1", "value1"))
    map.put("key2", "value2")

//    키는 인덱스와 비슷한 역할을 하므로 인덱스와 마찬가지로 겹치면 값이 덮어쓰기가 됩니다
    map.put("key2", "value3")
    println(map)
    map.remove("key2")
    println(map["key1"])




}
package com.example.loop

fun main() {

    /**
     * 반복문
     *
     * 반복문은 코드를 반복적으로 실행하고자 할때 사용합니다.
     * 예를들어 1-10까지 프린트를 찍는다고할때
     * println()을 열번하는것이 아닌 반복문 안에서 한번만 사용하면 쉽게 할수 있습니다
     *
     * 반복문에는 for과 while 2가지가 있습니다.
     * 이 둘의 큰차이는 컨셉. 즉 개념에 차이가 있습니다
     *
     * for 문은 특정횟수만큼 반복하는것
     * while은 특정 조건이 만족할때까지 반복하는것
     *
     */

    /**
     * for
     *
     * for (범위) {
     *  // 실행코드
     * } 로 이루어져 있습니다.
     *
     * if 부분에서 보안던 in 과 range를 사용해서 반복할 범위를 정의하며
     * if 부분에서 보았던것보다 더 다양한 기능이 있습니다.
     */

//    ..은 시작부터 끝까지
    for (i in 1..10) {
        println(".. $i")
    }

//    until은 시작부터 끝전까지
    for (i in 1 until 10) {
        println("until $i")
    }

//    downTo는 ..와는 반대로 시작부터 끝까지 감소
    for (i in 10 downTo 1) {
        println("downTo $i")
    }

//    step을 이용하면 건너뛰기 [1,3,5,7,9]
    for (i in 1..10 step 2) {
        println("step $i")
    }

//  step은 앞서 나온 모든곳에 적용이 가능
    for (i in 10 downTo 1 step 2) {
        println("downTo step $i")
    }

//    range가 아닌 배열이나 컬렉션을 적용하여 사용가능
    var list = mutableListOf("a", "b", "c", "d", "e")

    for (i in list) {
        println("list in $i")
    }

//  indices을 이용하면 값이 아닌 인덱스를 받음
    for (index in list.indices) {
        println("index $index is ${list[index]}")
    }

//  withIndex를 이용하면 인덱스와 값을 받
    for ((index, value) in list.withIndex()) {
        println("index $index is $value")
    }


    /**
     * while
     *
     * while(조건식) {
     *  // 실행코드
     * }로 이루어져있다
     *
     * while은 특정 조건이 만족할때까지 반복하는것이므로
     * for 문과는 달리 조건을 관리할 변수를 만들어야한다
     *
     *
     */

    var index = 1

    while (index < 10) {
        println("while $index")
//        조건에 대한 관리를 잘못하면 무한반복에 빠져 메모리 이슈가 생깁니다.
        index += 1 // index = index + 1
    }

    /**
     * do ~ while
     *
     * while문의 변형 형태로
     *
     * do {
     *  // 실행코드
     * } while(조건식) 으로 이루어져있습니다
     *
     * while 문과의 차이점은 먼저 실행을하고 조건을 비교하여 다음에 다시 반복할지 여부를 정하기 때문에
     * 무조건 한번은 실행을 한다는 것입니다.
     *
     */

    var index2 = 1

    do {
        println("do ~ while $index2")
        index2 += 1
    } while (index2 < 1)

    /**
     * 반복문 제어
     *
     * break, continue를 사용하여 반복문을 제어할수 있습니다.
     * break는 지정한 반복 횟수 혹은 조건이 끝나기전에 반복문에서 탈출을 가능하게 만들어줍니다.
     * continue는 반복은 유지하면 특정 차례만 뛰어넘을때 사용합니다.
     */

    for (i in 1..5) {
        if (i == 3) {
            break
        }
        println("break $i")
    }

    for (i in 1..5) {
        if (i == 3) {
            continue
        }
        println("continue $i")
    }


}
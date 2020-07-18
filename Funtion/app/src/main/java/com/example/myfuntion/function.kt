package com.example.myfuntion

import java.lang.reflect.Array

fun main() {

    /**
     * 함수
     *
     * 입력이 들어오면 결과를 반환해주는 기능을 수행목적으로 분리해놓은 것 입니다.
     * https://img1.daumcdn.net/thumb/R750x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F241E843456948EE20E
     *
     * fun (파라미터1: 타입, 파라미터2: 타입 , ...): 반환타입 {
     *      return 반환값
     * } 의 형태로 이뤄집니다.
     *
     */

//    1. 반환값과 입력값이 있는 함수

    fun square(x: Int): Int {
        return x * x
    }

    println("Result from square function :  ${square(4)}")

//    2. 반환값이 없는 함수

    fun printSquare(x: Int) {
        println("Result from printSquare function :  ${x * x}")
    }

    printSquare(4)

//    3. 입력값 없이 반환값만 있는 함수

    fun getDefaultInfo(): Map<String, String> {
        return mapOf(Pair("language", "kotlin"), Pair("for", "android"))
    }

    println("Result from getDefaultInfo function :  ${getDefaultInfo()}")

//    4. 파라미터의 기본값이 있는 함수

    fun myInfo(name: String, univ: String = "hanyang"): Map<String,String> {
        return mapOf(Pair("name", name), Pair("univ", univ))
    }

    println("Result from myInfo function :  ${myInfo("ian")}")

//    5. 파라미터 이름으로 값을 입력하기

    fun myInfo2(name: String, univ: String = "hanyang", grade: Int = 1): Map<String,Any> {
        return mapOf(Pair("name", name), Pair("univ", univ), Pair("grade", grade))
    }

    println("Result from myInfo2 function :  ${myInfo2("ian", grade = 4)}")



    /**
     * 함수는 작업의 단위이기때문에 복잡한 코드여도
     * 작업의 단위를 잘 쪼개어 분리하면 가독성과 유지보수가 원할해지므로 중요한 개념입니다.
     *
     * 정렬로 예를들어보겠습니다
     * n개의 리스트가 있고 각 리스트를 정렬을 해보겠습니다
     */

    var arr1 = mutableListOf(10,9,4,1,6,5,8,3,2,7)
    var arr2 = mutableListOf(2,9,4,1,3,5,8,7,10,6)
    var arr3 = mutableListOf(4,9,10,2,6,7,8,3,1,5)

    var arrInarr = arrayOf(arr1, arr2, arr3)

    for (arr in arrInarr) {
        for (i in arr.indices) {
            var leastValue = arr[i]
            var leastIndex = i
            for (j in i+1 until arr.size) {
                if (leastValue > arr[j]) {
                    leastValue = arr[j]
                    leastIndex = j
                }
            }
            var tmp = arr[i]
            arr[i] = leastValue
            arr[leastIndex] = tmp
        }
        println(arr)
    }

    /**
     * 코틀린 상에서 이미 구현되어있는 sort 함수를 사용
     */
    for (arr in arrInarr) {

        arr.sort()
        println(arr)
    }






}
package com.example.kotlin

fun main() {

    /*
    조건문
    말 그대로 특정 조건에 따라 실행을 다르게 하고 싶을때 사용합니다. 흐름제어문이라고도 표현을 합니다
    조건문에는 if, when 이 있으며
    조건문의 조건을 판단하기 위해서 비교연산자와 논리연산자를 사용합니다
     */

    /*
    if는 if, else if , else 를 조합하여 하나의 if 절이 완성됩니다
     */

    var chromosome = "XX"

    if (chromosome == "XX") {
        println("여성")
    } else if (chromosome == "XY") {
        println("남성")
    } else {
        println("?????")
    }

    /*
    이제 조건을 만드는 법을 알아보겠습니다.
    방금 쓰인 == 이 비교연산자 중 하나입니다.
    비교 연산자에는 > , < , >= , <=, ==, != 가 존재합니다
    논리 연산자에는 &&, ||, ! 가 존재합니다
     */

    var a = true
    var b = false

    if (a && b) {
        println("&& a 와 b가 둘다 참일때")
    } else if (a || b) {
        println("|| a 와 b 둘중 하나라도 참일때")
    } else {
        print("어느것도 아니다")
    }

    if (!b) {
        println("true를 false로 false를 true로")
    }


    /*
    논리연산자와 비교연산자를 배웠으니 두개 다 써서 예를 만들어보겠습니다
     */

    var month = 7

    if (month >= 3 && month < 6) {
        println("봄")
    } else if (month >= 6 && month < 9) {
        println("여름")
    } else if (month >= 9 && month < 11) {
        println("가을")
    } else {
        println("겨울")
    }

    /**
     * range를 사용하면 좀더 편리하며 가독성 높게 사용할수 있습니다. range는 if절 뿐만아니라 다양한곳에서 활용됩니다
     * 1..10 은 1부터 10까지의 값을 담는다
     */
    var range = 1..10
    println("Range is :: ${range.javaClass}")
    if (month in 3..5) {
        println("봄")
    } else if (month in 6..8) {
        println("여름")
    } else if (month in 9..10) {
        println("가을")
    } else {
        println("겨울")
    }


    /*
    if절의 결과를 변수에 바로 대입해줄수도 있습니다
    각 블럭의 마지막 값이 변수 값에 대입이됩니다
     */

    var season = if (month in 3..5) {
        "봄"
    } else if (month in 6..8) {
        "여름"
    } else if (month in 9..10) {
        "가을"
    } else {
        "겨울"
    }
    println("지금은 $season")



    /*
    이제 if 절을 배웠으니 when절 에 대해 알아보겠습니다
    앞서 말했듯이 when도 조건문 중의 하나입니다
    화살표 연산자와 else를 조합하여 when절을 완성합니다
     */

    when (chromosome) {
        "XX" -> {
            println("여성")
        }
        "XY" -> {
            println("남성")
        }
        else -> {
            println("?????")
        }
    }

    /*
    특정 값을 비교하는데 결과처리가 동일하다면 ,로 구분해서 한번에 비교할 수 있습니다
    범위값을 가진다면 range를 이용해서도 가능합니다
    */

    season = when (month) {
        3,4,5 -> "봄"
        in 6..8 -> "여름"
        9,10 -> "가을"
        else -> "겨울"
    }
    println("지금은 $season")

    /**
     * when절에서 입력 값. 즉, 파라미터를 쓰지 않는다면 if 문처럼 사용할수 있습니다
     */

    season = when {
        month >= 3 && month < 6 -> {
            "봄"
        }
        month in 6..8 -> {
            "여름"
        }
        month in 9..10 -> {
            "가을"
        }
        else -> {
            "겨울"
        }
    }
    println("지금은 $season")

    /**
     * if 와 when을 통해 조건문을 통해 흐름을 제어하는법을 배웠습니다
     * 저도 예전에 했던 생각이고 입문자들이 자주 하시는 질문 중 하나가
     * 조건문이 2개인데 어떨때 if를 쓰고 어떨때 when을 쓰냐는 의문입니다.
     * 저는 구현하는 사람의 코딩 습관이라고 생각합니다.
     * 프로그래밍하면서 같은 기능을 구현하는데 수도없는 방법이 있습니다.
     * 다만 상황에따라 가독성의 차이는 있을 수 있습니다.
     */

    when (month) {
        in 3..5 -> "봄"
        in 6..8 -> "여름"
        in 9..10 -> "가을"
        else -> "겨울"
    }

    if (month in 3..5) {
        "봄"
    } else if (month in 6..8) {
        "여름"
    } else if (month in 9..10) {
        "가을"
    } else {
        "겨울"
    }

}
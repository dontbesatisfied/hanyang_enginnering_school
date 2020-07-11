package com.example.kotlin

fun main() {

    /*
    변수와 상수 앞으로는 그냥 특정하여 상수를 말하지 않는 이상 변수라고 통일해서 이야기하겠습니다
    변수는 컴퓨터의 메모리에 저장이되는데 이 변수에게 할당할 메모리 크기를 알아야하므로 자료형을 이용하여 정의합니다

    논리형
        Boolean - 참과 거짓의 값을 나타냄 true / false
    문자
        Char - 16bit | 한글자의 문자
        String - Char 여러글자의 문자
    https://kotlinlang.org/docs/reference/basic-types.html
    정수형
        Byte - 8bit | -128 ~ 127 (-2^7 ~ 2^7 -1)
        Short - 16bit | -32768 ~ 32767 (-2^15 ~ 2^15 -1)
        Int - 32bit | -2,147,483,648 ~ 2,147,483,647 (-2^31 ~ 2^31 -1)
        Long - 64bit | -9,223,372,036,854,775,808 ~ -9,223,372,036,854,775,807 (-2^63 ~ 2^63 -1)
    실수형
        Float - 32bit |
        Double - 64bit |
     */


//    근데 왜 아까는 이런것들을 선언안했을까?
    var age = 28
//    자동으로 타입추론이 일어나는것을 확인 할 수가 있습니다. 말그대로 추론이므로 예기치않은 작동이 일어날수 있으므로 명시적으로 선언해서 쓰는것이 좋을때가 있습니다 Long, short, byte
    println(age.javaClass)

    var isBoolen = true
    var isChar = 'c'
    var isString = "string"
    var isByte: Byte = 123
    var isShort: Short = 123
    var isInt = 123
    var isLong: Long = 123
    var isLong2 = 123L
    var isFloat: Float = 0.123f
    var isDouble = 0.123

}
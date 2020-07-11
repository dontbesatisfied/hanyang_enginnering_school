package com.example.kotlin


fun main() {
    /**
     * 반복문을 배우기 앞서 먼저 배열과 컬렉션을 알아야합니다
     * 앞서 배운 타입은 모두 하나의 변수에 하나의 값만 저장하도록 되어있지만
     * 개발을 하다보면 하나의 변수에 여러개의 값을 저장해야 할 상황이 있습니다.
     */

    /**
     * 배열의 경우 여러 값을 담을 수 있지만 먼저 공간의 크기를 결정해두고 써야합니다.
     * 크기가 정해지면 중간에 추가 및 삭제를 할수 없습니다.
     * 기본 타입 뒤에 Array를 붙여서 생성합니다.
     */
    var intArray = IntArray(10)
    var longArray = LongArray(10)
    var byteArray = ByteArray(10)
    var shortArray = ShortArray(10)
    var floatArray = FloatArray(10)
    var doubleArray = DoubleArray(10)
    var charArray = CharArray(10)

    /**
     * 우리는 보통 처음이라고하면 1이라고 생각하지만
     * 컴퓨터언어에서 index(순서)는 0부터 시작을 합니다.
     * 그래서 intArray로 예를들면 0부터 시작해서 9에서 끝나는것을 알 수 있습니다.
     */
    println("Array size : ${intArray.size}")
    println("Last index : ${intArray.lastIndex}")

    /**
     * 공간을 정의해서 array를 선언하면 기본값으로 자동으로 채워져있습니다
     * [index]를 이용하여 값을 읽거나 수정할수 있지만
     * 정의한 공간을 넘어갈 경우 에러가 발생합니다
     */
    println(intArray.joinToString())
    intArray[0] = 1
    println(intArray[0])
    println(intArray.joinToString())
//    intArray[10] = 1 // Error : Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10

    /**
     * String은 기본 타입이 아니므로 StringArray는 없지만 arrayOf함수를 이용하여 가능합니다
     * arrayOf 함수를 사용하면 값과 공간이 동시에 정의할 수 있습니다.
     */

    var stringArry = arrayOf("aa", "bb", "cc")
    println(stringArry.joinToString())
    var intArray2 = arrayOf(0,1,2,3,4,5,6)
    println(intArray2.joinToString())
    var mixArray = arrayOf(0,'a',"ab", 3.0)
    println(mixArray.joinToString())

    /**
     * 정리하면 array는 한 변수 안에 여러값을 저장하는 공간의 제약이 있고 값의 수정이 자유롭운 타입입니다
     */



}
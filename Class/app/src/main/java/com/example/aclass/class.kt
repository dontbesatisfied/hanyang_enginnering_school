package com.example.aclass

fun main() {

    /**
     * 클래스를 알아보기전에 용어 및 개념 정리를 먼저 하고 가겠습니다.
     *
     * 추상화란
     *  사전적인 의미로 여러가지 사물이나 개념에서 공통되는 특성이나 속성 따위를 추출하여 파악하는 작용
     *  예를들면 자동차 공장에서 소나타를 생산한다고 했을때 차량마다 옵션(네비게이션, 가죽시트 유무 등)은 다르겠지만
     *  프레임, 바퀴4개, 문짝 4개, 엑셀을 누르면 자동차가 나간다, 브레이크를 밟으면 멈춘다 등등
     *  공통(기본)이 되는 요소와 행동을 정의하는 것입니다
     *
     *  쉽게말하면 설계를 하는것입니다.
     *
     * 클래스란
     *  추상화를 거친내용을 코드로 구현한 것. 쉽게말해 설계도 입니다
     *
     * 객체란
     *  우리 주변의 거의 모든것들을 객체라고 볼 수 있습니다.
     *  객체는 실체화된 것. 우리는 실체화시키기위해 추상화과정을 거치고 그 특징들을 클래스라는것을 이용하여 객체를 정의하는것 입니다.
     *
     * 생성자
     *  객체를 생성할 때 항상 실행되는 것으로, 객체를 초기화해주기 위해 맨 처음 실행되는 메소드입니다.
     *
     *
     *
     */

    /**
     * 클래스
     *
     * 프로그래밍을 하다보면 객체지향과 클래스라는 용어를 자주 접하셨을 겁니다.
     * 객체지향 프로그래밍에서 클래스를 빼놓을수는 없습니다
     * 하지만 현재로서는 객체지향은 잊어버리시고
     * 클래스는 단지 함수와 변수의 덩어리라는 느낌만 가져가셔도 성공이라고 생각합니다
     *
     * class 클래스명 {
     *  var 변수
     *  fun 함수명() {
     *      // 실행코드
     *  }
     * } 의 형태로 이루어져 있습니다
     *
     */

    /**
     * 앞서 설명에서 클래스란 설계도이고 설계도를 통해서 객체가 구현이 된다고 설명했습니다.
     * 그리고 생성자라는것이 객체가 생성될때 항상 실행된다고 말했습니다.
     *
     * 그러므로 먼저 생성자를 알아보겠습니다
     *
     * 코틀린은 객체를 사용하기 위해서 생성자를 두가지 형태로 정의하고 있습니다.
     * 1. Primary 생성자
     * 2. Secondary 생성자
     */


    /**
     * 1. Primary 생성자
     */

    class PrimaryInit constructor(value: String) {
        init {
            println("생성자로부터 전달받은 값 : $value")
        }
    }

    var primaryInit = PrimaryInit("테스트")

//    constructor 키워드를 생략가능하다. 위형태보단 이 형태를 자주쓴다

    class PrimaryInit2 (value: String) {
        init {
            println("생성자로부터 전달받은 값 : $value")
        }
    }

    var primaryInit2 = PrimaryInit("테스트2")

    /**
     * 2. Secondary 생성자
     * constructor 키워드를 함수처럼 사용하는것
     */

    class SecondaryInit {
        constructor(value: String) {
            println("생성자로부터 전달받은 값 : $value")
        }
    }

    var secondaryInit = SecondaryInit("테스트3")

    /**
     * 3. 클래스에 정의된 변수 함수 사용하기
     * 처음에 클래스는 단지 함수와 변수의 덩어리라는 느낌만 가져가셔도 성공이라고 말씀드렸을 것입니다
     */

    class SelfIntroduction {
        var myName = "홍길동"
        var myAge: Byte = 0

        constructor(name: String, age: Byte) {
            myName = name
            myAge = age
        }

        fun sayHello(type: Int = 0) {
            if (type === 0) {
                println("안녕하십니까 ${myAge}살 $myName 입니다.")
            } else {
                println("안녕하세요 $myName 입니다. 잘 부탁드립니다")
            }

        }
    }

    var introduction = SelfIntroduction("ian", age = 28)

    introduction.sayHello(1)
    println(introduction.myAge)

//    클래스안에 정의된 변수는 프로퍼티라고 하며 함수를 메소드라고 합니다
//    클래스는 설계도라고 했습니다. 제대로된 설계도만 있다면 아무리 복잡한 자동차라도 빠르게 만들어낼수 있습니다
//    여기서 클래스를 왜 사용하는지 느낌을 가져가실 수 있습니다.
//    이미 클래스(설계도)를 만들었으므로 자기소개하는 호랑이, 기린 등을 정의하는것은 너무 쉬워집니.

    var introduction2 = SelfIntroduction("호랑이", age = 99)

    introduction2.sayHello(0)


    /**
     * 4. 객체를 생성하지 않고 클래스 사용하기
     * companion object라는 키워드를 사용한 블럭안의 프로퍼티와 메소드는 객체를 만들필요없이 바로 가져다 쓸수가 있습니다
     */

    MyCompanionObject.value = "static"
    MyCompanionObject.prinValue()

    /**
     * 5. 데이터 클래스
     *
     * 간단한 값의 저장 용도로 데이터 클래스를 제공한다.
     * 위의 생성자와 다르게 var또는 val를 명시해줘야하며 생략이 불가능하다
     *
     */

    data class DataClass(val param1: String, var param2: Int)

    var myData = DataClass("covid", 19)
    println(myData.toString())
//    앞서 클래스와는 달리 복사가 가능합니다
    var newData = myData.copy()
    println(newData.toString())

}

class MyCompanionObject {
    companion object {
        var value: String = ""
        fun prinValue() {
            println("value is $value")
        }
    }
}
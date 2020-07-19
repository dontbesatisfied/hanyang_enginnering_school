package com.example.aclass


fun main() {

    /**
     *
     * 객체지향 프로그래밍은 "구현"과 "설계"로 나눌수가 있습니다
     * 쉽게말해 구현은 실제로 로직을 갖는 코딩
     * 설계는 껍데기만 있는 코딩 으로 이해하실 수 있습니다.
     *
     * 앞서까지는 구현에 대한 이야기였습니다.
     * 클래스는 설계도이며 설계도를 만들기위해서 추상화 과정을 먼저 한다고하였습니다.
     *
     * 지금까지는 이 추상화를 머리속으로하여 클래스를 만들었지만
     * 지금 말하는 설계부분에서 코드로 추상화를 표현하는방법을 설명드리겠습니다.
     *
     */

    /**
     *
     * abstract
     *
     * 클래스의 이름과 클래스안의 "있음직한" 기능을 유추해서 정의하는것
     *
     * 정의하는(설계) 클래스이므로 인스턴스를 생성할수 없다
     *
     */

//    모든 동물이 먹고 움직이고 하지만 각자 먹는 방법과 움직이는 방법이 다르므로 구현을 할수가 없습니다
//    예를들면 치타는 4발로 움직이지만 고래는 수영을하는 차이이죠
    abstract class Animal {

        abstract var _age: Int

        abstract fun eat()
        abstract fun move()
    }

    class Cat(age: Int): Animal() {
        override var _age: Int = age

        override fun eat() {
            println("이빨로 씹어먹는다")
        }

        override fun move() {
            println("4발을 사용해서 움직인다")
        }
    }

    /**
     *
     * interface
     *
     * interface 예약어를 사용해서 있음직한 변수와 함수를 정의할 수 있습니다.
     * 추상화 클래스랑 비슷하지만 아래에 차이를 설명하겠습니다.
     *
     */

    class Dog(age: Int): Animal(), Breedable {
        override var _age: Int = age

        override fun eat() {
            println("이빨로 씹어먹는다")
        }

        override fun move() {
            println("4발을 사용해서 움직인다")
        }

        override fun order(type: String) {
            println(type)
        }
    }


    /**
     *
     * abstract와 interface를 이용하여 설계를하고 구현이 가능한것을 보여드렸습니다.
     * 둘다 미리 정의는 하지만 상세내용을 정의할 수 없을때 사용하며 이것을 받아 구현하는 클래스의 경우
     * 해당 속성들을 반드시 사용해야하는 제약이 있습니다.
     *
     * 차이점에 대해 말씀드리면
     * 첫번째. 클래스 상속은 1개만 가능하지만 interface는 여러개 받을 수 있다.
     * 두번째. 개념적차이
     *  추상화클래스는 상속을 강제하여 기능을 확장하기 위함
     *  인터페이스는 동일한 동작을 위한 강제화
     *  인터페이스와 추상화클래스는 be able to 와 is a kind of 이 관계가 성립할 때 사용하는 것이 적절합니다.
     *
    */

}

interface Breedable {

    fun order(type: String)
}
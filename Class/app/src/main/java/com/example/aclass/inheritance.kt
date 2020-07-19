package com.example.aclass

fun main() {


    /**
     * 상속
     *
     * 클래스를 강력하게 만들어주는 요소인 상속에 대해서 말씀드리겠습니다.
     * 상속을 개념적으로 접근하면 어려울 수 있습니다. 먼저 사용측면으로 접근하면 이해하기 쉽습니다.
     *
     * 안드로이드의 화면 구성을 위해 가장 기본이되는 요소인 Activity를 뜯어보겠습니다.
     * MainActivity : AppCompatActivity() 는 AppCompatActivity의 상속을 받고있습니다.
     * 또 이 AppCompatActivity는 FragmentActivity의 상속을 받고 있고 쭉~~~ 올라가면 context가 있습니다.
     *
     * 만약 우리가 안드로이드 프로그래밍을 하기 위해서 이렇게 복잡한 Activity를 매번 구현을 해야한다면 할 수 없을것입니다.
     * 때문에 미리 클래스로 정의되고 상속을 받으면서 최종적으로 우리는 AppCompatActivity만 상속을 받으면 앱을 만들 수가 있습니다.
     *
     * 마찬가지로 버튼, 텍스트뷰 등등의 위젯 그리고 다양한 레이아웃들도 View 클래스에서 상속을 받으면서 구현된것입니다.
     *
     *
     */

    /**
     * 상속을 받기위해서는 상속할 클래스가 open이라는 키워드로 만들어져 있어야만 합니다.
     * 상속을 할 클래스는 : 을 이용하여 클래스를 상속받을 수 있습니다.
     *
     * 또한 부모클래스의 생성자 파라미터가 있다면 자식 클래스의 생성자를 통해 전달이 가능하다.
     */

    open class Animal {
        constructor(name: String) {
            println("Animal :: $name")
        }
    }

    class Dog(name: String): Animal(name) {

    }

    class Bird: Animal {
        constructor(name: String) : super(name)
    }

    var bird = Bird("부엉이")
    var dog = Dog("리트리버")

    /**
     * 부모클래스의 프로퍼티와 메서드 사용
     */

    open class Person {

        var name = "unknown"

        fun introduce() {
            println("안녕하세요 $name 입니다.")
        }

    }

    class Ian(myName: String): Person() {

        init {
            name = myName
        }
    }

    var ian = Ian("ian")
    ian.introduce()



    /**
     * Override
     *
     * 상속받은 클래스의 프로퍼티와 메서드를 자식 클래스에서 다른용도로 사용하는 경우에 재정의하는것입니다.
     * 동일한 이름의 메서드나 프로퍼티를 사용할 필요가 있을 경우에 사용합니다
     *
     * override를 하기위해서 부모 클래스의 프로퍼티와 메서드가 open 키워드가 있어야합니다.
     *
     */

    open class BaseClass() {
        open var variable = "var"

        open fun hello(): String {
            return "hello"
        }
    }
    class BaseClass2: BaseClass() {
        override var variable = "val"

        override fun hello(): String {
            return super.hello() + " nice to meet you"
        }
    }

    var base = BaseClass2()
    println(base.hello())

    /**
     * Extension
     *
     * 이미 만들어져있는 클래스에 메서드를 추가하는것 입니다.
     *
     * 상속은 미리 만들어져있는 클래스를 가져다 쓰는 개념
     * 익스텐션은 미리 만들어져있는 클래스에 메서드를 붙여넣는 개념
     *
     * 하지만 붙여넣는다고해서 실제 클래스의 코드에 변경되는것은 아니고 단지 실행시 호출해서 사용할 수 있도록 해주는것 입니다.
     */

    fun String.twoRandom(): String {
        return "${this.random()}${this.random()}"
    }

    println("123456".twoRandom())


}

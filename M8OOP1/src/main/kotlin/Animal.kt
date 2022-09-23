import kotlin.random.Random

open class Animal(val name: String, var energy: Int, var weight: Int, val maxAge: Int) {
    private var age = 0
    open val isTooOld
        get() = age >= maxAge

    fun sleep() {
        if (isDo()) {
            energy += 5
            age += 1
            println("• $name спит")
        }
    }

    fun eat() {
        if (isDo()) {
            energy += 3
            weight += 1
            tryIncrementAge()
            println("• $name ест")
        }
    }

    open val taskMove = "передвигается"
    open fun move() {
        if (isDo()) {
            energy -= 3
            weight -= 1
            tryIncrementAge()

            println("• $name - $taskMove")
        }
    }

    open val typeName = "животное"
    open val symbol = "ое"

    open fun birthChild(): List<Int> {
        val list = listOf(
            (1..10).random(),
            (1..5).random()
        )
        println("Рожден$symbol $typeName - $name: \n\tэнергия: ${list[0]}, вес: ${list[1]}, макс. возраст: $maxAge")
        return list
    }

    open fun createChild(): Animal {
        val list = birthChild()
        return Animal(name, list[0], list[1], maxAge)
    }

    private fun tryIncrementAge() {
        if (Random.nextBoolean()) age += 1
    }

    fun getAge(): Int = age

    private fun isDo(): Boolean = !isTooOld && weight != 0 && energy != 0
}
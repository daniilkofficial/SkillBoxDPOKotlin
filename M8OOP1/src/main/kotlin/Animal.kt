import kotlin.random.Random

open class Animal(val name: String, var energy: Int, var weight: Int, val maxAge: Int) {
    private var age = 0
    protected open val isTooOld
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
    protected var newEnergy = (1..10).random()
    protected var newWeight = (1..5).random()

    open fun birthChild() {
        newEnergy = (1..10).random()
        newWeight = (1..5).random()
        println("Рожден (а, о) $typeName - $name: \n\tэнергия: $newEnergy, вес: $newWeight, макс. возраст: $maxAge")
    }

    open fun createChild(): Animal {
        birthChild()
        return Animal(name, newEnergy, newWeight, maxAge)
    }

    private fun tryIncrementAge() {
        if (Random.nextBoolean()) age += 1
    }

    fun getAge(): Int = age

    protected fun isDo(): Boolean = !isTooOld && weight != 0 && energy != 0
}
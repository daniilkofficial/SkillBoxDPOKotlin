class Dog(name: String, energy: Int, weight: Int, maxAge: Int) :
    Animal(name, energy, weight, maxAge) { // собака
    override val typeName = "собака"
    override val symbol = "а"
    override val taskMove = "бежит"

    override fun createChild(): Dog {
        val list = birthChild()
        return Dog(name, list[0], list[1], maxAge)
    }
}
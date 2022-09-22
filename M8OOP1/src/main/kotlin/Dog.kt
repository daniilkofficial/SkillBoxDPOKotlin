class Dog(name: String, energy: Int, weight: Int, maxAge: Int) :
    Animal(name, energy, weight, maxAge) { // собака
    override val typeName = "собака"
    override val taskMove = "бежит"

    override fun createChild(): Dog {
        birthChild()
        return Dog(name, newEnergy, newWeight, maxAge)
    }
}
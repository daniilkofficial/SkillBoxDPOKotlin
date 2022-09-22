class Fish(name: String, energy: Int, weight: Int, maxAge: Int) :
    Animal(name, energy, weight, maxAge) { // рыба
    override val typeName = "рыба"
    override val taskMove = "плывет"

    override fun createChild(): Fish {
        birthChild()
        return Fish(name, newEnergy, newWeight, maxAge)
    }
}
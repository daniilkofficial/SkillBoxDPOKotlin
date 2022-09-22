class Bird(name: String, energy: Int, weight: Int, maxAge: Int) :
    Animal(name, energy, weight, maxAge) {
    override val typeName = "птица"
    override val taskMove = "летит"

    override fun createChild(): Bird {
        birthChild()
        return Bird(name, newEnergy, newWeight, maxAge)
    }

}
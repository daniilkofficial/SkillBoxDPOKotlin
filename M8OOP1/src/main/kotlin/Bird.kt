class Bird(name: String, energy: Int, weight: Int, maxAge: Int) :
    Animal(name, energy, weight, maxAge) {
    override val typeName = "птица"
    override val symbol = "а"
    override val taskMove = "летит"


    override fun createChild(): Bird {
        val list = birthChild()
        return Bird(name, list[0], list[1], maxAge)
    }
}
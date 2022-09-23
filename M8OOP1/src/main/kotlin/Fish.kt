class Fish(name: String, energy: Int, weight: Int, maxAge: Int) :
    Animal(name, energy, weight, maxAge) { // рыба
    override val typeName = "рыба"
    override val symbol = "а"
    override val taskMove = "плывет"

    override fun createChild(): Fish {
        val list = birthChild()
        return Fish(name, list[0], list[1], maxAge)
    }
}
fun main(args: Array<String>) {
    println("Кол-во воинов в командах: ")
    var numWarrior: Int? = readLine()?.toIntOrNull()
    while (numWarrior == null) {
        println("Данные не корректные")
        println("Кол-во воинов в командах: ")
        numWarrior = readLine()?.toIntOrNull()
    }

}

// число текущее больше генерируемого (чем выше шанс, тем выше вероятность до 100%)
fun Int.isChance(): Boolean = this >= (1..100).random()
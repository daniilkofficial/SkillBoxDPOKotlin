class NatureReserve() {
    // список животных
    private val animals: MutableList<Animal> = init()

    // быстрое оживание
    constructor(hours: Int = 1) : this() {
        liveOfAnimals(hours)
    }

    // данные
    private fun init(): MutableList<Animal> {
        return mutableListOf(
            /*
             Энергия от 1 до 10.
             Вес от 1 до 5.
             Всего: 14
             Правило: 5 птиц, 3 рыбы, 2 собаки и несколько обычных животных.
             */
            // птицы
            Bird("Сорока", 3, 2, 12),
            Bird("Сизый голубь", 2, 1, 10),
            Bird("Сапсан", 4, 2, 16),
            Bird("Дрофа", 5, 3, 14),
            Bird("Зяблик", 3, 2, 13),

            // рыбы
            Fish("Тунец", 8, 4, 19),
            Fish("Речной угорь", 8, 5, 20),
            Fish("Макрели", 9, 3, 18),

            // собаки
            Dog("Бигль", 7, 5, 12),
            Dog("Сиба-ину", 10, 5, 14),

            // животные без категорий
            Animal("Биологическая масса 1", 10, 5, 5),
            Animal("Биологическая масса 2", 8, 5, 2),
            Animal("Биологическая масса 3", 1, 3, 1),
            Animal("Биологическая масса 4", 8, 2, 2),
        )
    }

    // жизнь животных
    fun liveOfAnimals(hours: Int) {
        /* Каждое животное делает одно случайное действие, которое позволяют сделать его свойства: ест, спит, двигается, рожает.
        Когда у животного рождается детёныш, он добавляется к общему количеству животных заповедника. */
        var i: Int // выбор
        for (n in 1..hours) { // цикл выбора действий
            println("\n_____Hour: ${n}_____")
            if (animals.size == 0) { // при отсутствии животных
                println("Заповедник будет закрыт!")
                return // выход
            }
            i = 0 // заново пробегаемся, по каждому животному
            while (i < animals.size) { // цикл жизни, 1 выбор = 1 животное
                val animal = animals[i] // получаем животное
//                animal.setAge(animal.maxAge+1) // смертный тест
                when ((0..3).random()) { // случайный выбор из 4-х
                    0 -> {
                        animal.sleep()
                    } // спит
                    1 -> animal.eat() // ест
                    2 -> animal.move() // передвигается
                    3 -> { // рождение детей
                        print("  • ")
                        animals.add(animal.createChild())
                    }

                    else -> animal.sleep() // спит
                }

                deadAnimal(animal)
                i++ // подсчет для цикла выбора
            } // цикл выбора действий
        }// цикл жизни
        println("Количество животных: ${animals.size}")
    }

    // смерть животного
    private fun deadAnimal(animal: Animal) {
        if (animal.isTooOld) { // возраст больше максимального, смерть
            println("Умер: ${animal.name}")
            animals.remove(animal)
        }
    }
}
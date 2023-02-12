import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

fun main() {
    /* Лото
    1) Получаем бочонок с числом
    2) Совпадение бочонка с игровой картой её номерами
    3) Закрываем (удаляем) из игровой карты номера
     */

    println("Внимание! Игра начинается")
    var isWin = false

    runBlocking {
        launch {
            val listBank1: ArrayList<Int> = getGameCard()
            println("Игрок 1 начал игру")
            Generator.flow1.collect {
                println("Игрок 1. Бочонок $it. Осталось найти: ${listBank1.size}")
                listBank1.remove(it)

                if (isWin) {
                    cancel()
                } else if (listBank1.size == 0) {
                    println("Победил игрок 1!")
                    isWin = true
                    cancel()
                }

            }
        }
        launch {
            val listBank2: ArrayList<Int> = getGameCard()
            println("Игрок 2 начал игру")
            Generator.flow2.collect {
                println("Игрок 2. Бочонок $it. Осталось найти: ${listBank2.size}")
                listBank2.remove(it)

                if (isWin) {
                    cancel()
                } else if (listBank2.size == 0) {
                    println("Победил игрок 2!")
                    isWin = true
                    cancel()
                }
            }
        }
        launch {
            val listBank3: ArrayList<Int> = getGameCard()
            println("Игрок 3 начал игру")
            Generator.flow3.collect {
                println("Игрок 3. Бочонок $it. Осталось найти: ${listBank3.size}")
                listBank3.remove(it)

                if (isWin) {
                    cancel()
                } else if (listBank3.size == 0) {
                    println("Победил игрок 3!")
                    isWin = true
                    cancel()
                }
            }
        }
    }
}

fun getGameCard(): ArrayList<Int> {
    return arrayListOf(6, 8, 14, 20, 28, 39, 41, 46, 55, 62, 65, 70, 79, 82, 90)  // 15
}

object Generator {
    val flow1 = flow {
        while (currentCoroutineContext().isActive) {
            emit(Random.nextInt(1, 91))
            delay(400)
        }
    }

    val flow2 = flow {
        while (currentCoroutineContext().isActive) {
            emit(Random.nextInt(1, 91))
            delay(300)
        }
    }
    val flow3 = flow {
        while (currentCoroutineContext().isActive) {
            emit(Random.nextInt(1, 91))
            delay(100)
        }
    }
}
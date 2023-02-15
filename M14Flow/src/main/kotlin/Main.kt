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
    val players = arrayOf(1, 2, 3)

    runBlocking {
        players.forEach { num ->
            val listBank: ArrayList<Int> = getGameCard()
            println("Игрок $num начал игру")

            launch {
                Generator.flow.collect {
                    println("Игрок $num. Бочонок $it. Осталось найти: ${listBank.size}")
                    listBank.remove(it)

                    if (isWin) {
                        cancel()
                    } else if (listBank.size == 0) {
                        println("Победил игрок $num!")
                        isWin = true
                        cancel()
                    }

                }
            }

        }

    }

}

fun getGameCard(): ArrayList<Int> {
    return arrayListOf(6, 8, 14, 20, 28, 39, 41, 46, 55, 62, 65, 70, 79, 82, 90)  // 15 шт
}

object Generator {
    val flow = flow {
        while (currentCoroutineContext().isActive) {
            emit(Random.nextInt(1, 91))
            yield()
        }
    }
}
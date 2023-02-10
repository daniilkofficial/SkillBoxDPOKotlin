import kotlinx.coroutines.*

fun main() {
    // до 7го задания
    val fibonacci = Fibonacci()
    runBlocking {
        val job1 = launch {
            fibonacci.take(5)
        }
        withTimeout(3000) {
            job1.cancel()
        }
        launch { fibonacci.take(10) }
        launch { fibonacci.take(15) }
    }

//    var n = readlnOrNull()?.toIntOrNull() ?: -1
//    while (n <= -1) {
//        println("Ошибка: Введите целое число больше 0\n")
//        n = readlnOrNull()?.toIntOrNull() ?: -1
//        println(n)
//    }
}



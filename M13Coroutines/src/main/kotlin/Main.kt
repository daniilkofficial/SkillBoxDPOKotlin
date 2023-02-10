import kotlinx.coroutines.*


fun main() {
    val fibonacci = Fibonacci()
    runBlocking {
        launch { fibonacci.take(5) }
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



import kotlinx.coroutines.*

fun main() {
    // до 7го задания
    val fibonacci = Fibonacci()
    runBlocking {
        withTimeout(1000) {
            launch {
                fibonacci.take(5)
                currentCoroutineContext().isActive
            }
        }

        launch { fibonacci.take(10) }
        launch { fibonacci.take(15) }
    }
}



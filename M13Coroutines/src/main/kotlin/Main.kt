import kotlinx.coroutines.*

fun main() {
    // до 7го задания
    val fibonacci = Fibonacci()
    runBlocking {
        val job1 = launch {
            fibonacci.take(5)
            currentCoroutineContext().isActive
            // yield()
        }
        withTimeout(3000) {
            job1.cancel()
        }
        launch { fibonacci.take(10) }
        launch { fibonacci.take(15) }
    }
}



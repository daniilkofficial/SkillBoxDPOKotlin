import kotlinx.coroutines.*

fun main() {
    val fibonacci = Fibonacci()
    runBlocking {
        withTimeout(1000) {
            launch {
                println("Launch 1")
                fibonacci.take(5)
//                currentCoroutineContext().isActive
            }
        }

        val job2 = launch {
            println("Launch 2")
            fibonacci.take(10)
        }
        yield()
        job2.cancel()
        yield()

        launch {
            println("Launch 3")
            fibonacci.take(15)
        }
    }
}



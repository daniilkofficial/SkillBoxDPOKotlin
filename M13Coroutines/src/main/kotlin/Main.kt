import kotlinx.coroutines.*

val scope = CoroutineScope(Job())

fun main() {
    val fibonacci = Fibonacci()
    runBlocking {
        try {
            scope.launch {
                withTimeout(1000) {
                    println("Launch 1")
                    fibonacci.take(120)
                }
            }
        } catch (e: TimeoutCancellationException) {
            println("Превышено время вычисления")
        }

        val job2 = scope.launch {
            println("Launch 2")
            fibonacci.take(10)
        }
        job2.join()
        yield()
        job2.cancel()
        yield()

        scope.launch {
            println("Launch 3")
            fibonacci.take(35)
        }

        scope.launch {
            while (true)
                print(".")
        }

    }
}



import kotlinx.coroutines.*

val scope = CoroutineScope(Job())

fun main() {
    val fibonacci = Fibonacci()
    runBlocking {
        try {
            val job1 = scope.launch {
                withTimeout(1000) {
                    println("Launch 1: ${fibonacci.take(120)}")
                }
            }
            job1.join()
        } catch (e: TimeoutCancellationException) {
            println("Превышено время вычисления")
        }


        val job2 = scope.launch {
            println("Launch 2: ${fibonacci.take(10)}")
        }
        yield()
        job2.cancel()
        job2.join()
        yield()

        val job3 = scope.launch {
            println("Launch 3: ${fibonacci.take(35)}")
        }
        job3.join()


        scope.launch {
            while (true)
                print(".")
        }


    }
}



import kotlinx.coroutines.*

val scope = CoroutineScope(Job())

suspend fun main() {
    val fibonacci = Fibonacci()
    runBlocking {
        val job1 = scope.launch {
            try {
                withTimeout(1000) {
                    println("Launch 1: ${fibonacci.take(120)}")
                }
            } catch (e: TimeoutCancellationException) {
                println("Превышено время вычисления")
            }
        }
        job1.join()
    }


    val job2 = scope.launch {
        val n = 40
        if (n >= 10)
            cancel()
        println("Launch 2: ${fibonacci.take(n)}")
    }

    val job3 = scope.launch {
        println("Launch 3: ${fibonacci.take(35)}")
    }
    job3.join()

    scope.launch {
        while (scope.coroutineContext.isActive)
            print(".")
    }

}


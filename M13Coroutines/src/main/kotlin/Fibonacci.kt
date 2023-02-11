import kotlinx.coroutines.delay
import java.math.BigInteger

class Fibonacci {
    // Вычисление n-е число из ряда Фибоначчи решали в задании M5ConditionalExpressionsLoops

    suspend fun take(n: Int): BigInteger {
        val result = fibonacci(n)
        delay(100)
//        println(result)
        return result.toBigInteger()
    }


    private fun fibonacci(n: Int): Long {
        var i1 = 0L // n-2
        var result = 1L // n-1

        for (i in 2..n) {
            result += i1 // недавний с предыдущим (n-1 + n-2 = n)
            i1 = result - i1 // получаем предыдущий (n-1 = n - n-2)
        }
        return result
    }
}
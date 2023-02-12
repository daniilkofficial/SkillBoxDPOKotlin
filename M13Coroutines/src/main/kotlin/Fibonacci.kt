import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import java.math.BigInteger

class Fibonacci {
    // Вычисление n-е число из ряда Фибоначчи решали в задании M5ConditionalExpressionsLoops

    suspend fun take(n: Int): BigInteger {
        var i1 = 0.toBigInteger() // n-2
        var result = 1.toBigInteger() // n-1

        for (i in 2..n) {
            result += i1 // недавний с предыдущим (n-1 + n-2 = n)
            i1 = result - i1 // получаем предыдущий (n-1 = n - n-2)
        }
        yield()
        return result
    }
}
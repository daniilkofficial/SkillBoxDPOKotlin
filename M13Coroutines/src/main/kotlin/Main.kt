import kotlinx.coroutines.*
import java.math.BigInteger
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.random.Random
import kotlin.random.asJavaRandom
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
            println("Start runBlocking...")
            suspendMagicNumber()
            println("Finish runBlocking")
        }
    }
}
suspend fun suspendMagicNumber() {
    suspendCoroutine<BigInteger> { continuation -> // продолжение
        magicNumber(object : Callback {
            override fun onSuccess(value: BigInteger) {
                println("number $value")
                continuation.resume(value)
            }

            override fun onFailure(error: Throwable) {
                println("number $error")
                continuation.resumeWithException(error)
            }

        })
    }
}

fun magicNumber(callback: Callback) {
    thread {
        println("Calculation start: ${Thread.currentThread().name}")
        val number: BigInteger
        val time = measureTimeMillis {
            number = BigInteger.probablePrime(4000, Random.asJavaRandom())
        }
        if (time > 2000)
            callback.onFailure(Throwable(""))
        else
            callback.onSuccess(number)
    }
}

interface Callback {
    fun onSuccess(value: BigInteger)
    fun onFailure(error: Throwable)
}

    /*
    1. Создайте объект-синглтон Fibonacci.
    2. В этом объекте создайте suspend функцию take. Функция принимает на вход число — номер в последовательности
    Фибоначчи — и возвращает рассчитанное число типа BigInteger. Для создания числа BigInteger используйте
    функцию-расширение toBigInteger.
    3. Запустите две или более корутин в функции main. Используйте для этого функцию runBlocking
    и билдер launch. Внутри каждой корутины вызовите функцию take и выведите результат в консоль.
    4. Рассчитайте несколько чисел Фибоначчи в порядке возрастания, затем в порядке убывания.
    Запустите программу несколько раз и проанализируйте порядок работы корутин.

    https://kotlinlang.org/api/kotlinx.coroutines/
    CoroutineScope - объект, который отслеживает выполняемые внутри него корутины
    Все корутины выполняются внутри какого-нибудь CoroutineScope
    Каждый CoroutinesScope существует до тех пор, пока запущенные в нём корутины не завершатся
    Отмена CoroutinesScope приводит к отмене всех корутин внутри него
    Каждый CoroutineBuilder является функцией-расширением CoroutineScope

    suspend - приостоновка и продолжение с того же места где было остановлено
    CoroutineBuilder
    runBlocking - запускает корутину в текущем потоке и дожидается её выполнения
    Связывает обычный код с прерываемым.
    launch - создает и запускает корутину на выполнение, не дожидается окончания
    выполнения корутины и её результата
    async - создает и запускает корутину на выполнение и дожидается результата

    CoroutineContext - объект, который содержит в себе набор элементов, которые определяют поведение корутины
    Job - однозначно определяет корутину и управляет её жизненным циклом
    CoroutineDispatcher - диспечер, который предоставляет потоки для выполнения корутины
    CoroutineName - название корутины
    CoroutineExceptionHandler - обработчик исключений

    CoroutineScope можно создат одним из следующих способов
    CoroutineDispatcher
    Default - предоставляет фоновый поток. Используется для ресурсоёмких задач. Чаще всего количество потоков равно количеству
    ядер процессора
    IO - предоставляет фоновый поток. Используется для задач ввода-вывода: загрузка данных из сети, запись информации на диск или в базу данных и т.д.
    Количество потоков может достигать 64
    Main - предоставляет UI-поток. Используется для работы с пользовательским интерфейсом
    Unconfined - диспетчер, который выполняет задачи на том потоке, на котором был запущен

    Job - объект, который индентифицирует и управляет выполнением корутины
    New - Active - Completing - Cancelling - Completed - Cancelled

    Structured concurrency
    - Каждая корутина может быть запещена только внутри какого-то CoroutineScope
    - Ни одна из запущенных корутин не будет потеряна и не вызовет утечку памяти
    - CoroutineScope не может быть завершен до тех пор выполняется корутины внутри него
    - CoroutineScope может быть отменён, при этом будут отменены все выполняемые в нём корутины
    - Отмена корутины необязательно приводит к отмене всего CoroutineScope

    Continuation (интерфейс)
     */


//    launch {
//        printWorld()
//    }

//    launch {
//        printDots()
//    }

//    val scope1 = CoroutineScope(Job() + Dispatchers.Default)
//    val scope2 = CoroutineScope(Job())
//    val scope3 = CoroutineScope(Dispatchers.Default)

//    val scope = CoroutineScope(Dispatchers.Default)
//    scope.launch {
//        println("Start runBlocking...")
//        doSomeWork()
//        println("Finish runBlocking...")
//    }





//suspend fun doSomeWork() {
//    println("Start work...")
//    delay(3000)
//    println("Finish work...")
//}
//
//fun data(a: Int): String {
//    return "$a ok"
//}
//
//suspend fun printWorld() {
//    delay(2000)
//    println(" world! ")
//}
//
//suspend fun printDots() {
//    for (i in 1..500)
//        if (i % 130 == 0)
//            println(".$i")
//        else
//            print(".$i")
//}
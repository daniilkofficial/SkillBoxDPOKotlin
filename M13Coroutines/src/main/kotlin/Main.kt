import kotlinx.coroutines.*
import java.math.BigInteger
import javax.security.auth.callback.Callback
import kotlin.coroutines.suspendCoroutine

fun main() = runBlocking {
    /*
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
//
//    launch {
//        printDots()
//    }
//
//    val scope1 = CoroutineScope(Job() + Dispatchers.Default)
//    val scope2 = CoroutineScope(Job())
//    val scope3 = CoroutineScope(Dispatchers.Default)
//
//    val scope = CoroutineScope(Dispatchers.Default)
//    scope.launch {
//        println("Start runBlocking...")
//        doSomeWork()
//        println("Finish runBlocking...")
//    }


}

suspend fun suspendMagicNumber() {
    suspendCoroutine<BigInteger> { continuation -> // продолжение
        magicNumber(object : Callback {
            fun onSuccess(value: BigInteger) {
                println("number $value")
            }
        })
    }
}

fun magicNumber(callback: Callback) {
    TODO("Not yet implemented")
}

suspend fun doSomeWork() {
    println("Start work...")
    delay(3000)
    println("Finish work...")
}

fun data(a: Int): String {
    return "$a ok"
}

suspend fun printWorld() {
    delay(2000)
    println(" world! ")
}

suspend fun printDots() {
    for (i in 1..500)
        if (i % 130 == 0)
            println(".$i")
        else
            print(".$i")
}
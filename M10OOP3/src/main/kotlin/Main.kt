fun main() {
    /*
    1) Тип валюты
    2) Кол-во валюты
    3) Перевод в рубли
    4) Результат
    Подсказка:
    ZWL = 0.18 (26.09.2022)
     */
    runInput()
}

// запуск ввода и передача конвертации, цикл с закрытием (напоминание 3 раза за ввод)
fun runInput() {
    var i = 0
    while (true) {
        if (i % 3 == 0) {
            exitPost()
            println("_________")
        }
        val data = inputString("Тип валюты (USD, EU или другую):")
        if (isExitDialog(data))
            break
        convert(data)
        i++
    }
}

// получение конвертера по типу и результат, поэтапный ввод
fun convert(type: String = "EU") {
    Converters.get(type).apply {
        // суммы денег
        println("По курсу $rate от $date \n1000 RUB = ${convertRubToCurrency(1000.0)}")
        val moneyRub = inputDouble("Сумма RUB для перевода в $currencyCode: ") // сумма рублей
        val moneyCurrency = convertRubToCurrency(moneyRub) // сумма валюты
        val moneyRubCorrected = convertCurrencyToRub(moneyCurrency) // корректность
        println("$moneyRubCorrected RUB = $moneyCurrency $currencyCode") // вывод
        println("__________")
    }
}

// для закрытия цикла
private val valuesToExit = arrayListOf(
    "закончить",
    "закрыть",
    "выйти",
    "close",
    "exit",
)

fun exitPost(field: String = "в поле ввода") {
    print("Для закрытия введите: ")
    for (i in valuesToExit) {
        if (i == valuesToExit.last()) {
            print("$i ")
            break
        }
        print("$i/")
    }
    println("- $field")
}

fun isExitDialog(input: String): Boolean {
    return input in valuesToExit
}





fun main() {
    task1() // часть 1
    task2() // часть 2
}

fun task1() {
    // Задание 1
    println("Введите кол-во чисел?")
    var n = readLine()?.toIntOrNull() ?: -1
    while (n <= -1) {
        println("Ошибка: Введите целое число больше 0\n")
        n = readLine()?.toIntOrNull() ?: -1
        println(n)
    }

    // Задание 2
    val list = List(n) { (-5..5).random() }
    println(list)

    // Задание 3
    val listMutable = list.toMutableList()
    listMutable.forEachIndexed { i, el ->
        listMutable[i] = el * 10
    }
    println(listMutable)

    // Задание 4
    val sum = listMutable.sumOf { it }
    println("Сумма: $sum")

    // Задание 5
    val listPositive = listMutable.filter { it >= 0 }
    if (listPositive.isNotEmpty())
        println("Положительные числа: $listPositive")
    else
        println("Отсутствуют положительные числа")

    println()
}

fun task2() {
    var accounts: HashMap<String, String> = regAccounts()
    while (accounts.isEmpty()) {
        println("\nВведите данные для авторизации!\n")
        accounts = regAccounts()
    }
    println("Подготовка данных закончена!")
    println("ДАННЫЕ:\n")
    accounts.forEach { (key, v) ->
        println("$key - $v")
    }

    println("Будете авторизовываться? (да - продолжить)")
    var str = readLine()
    if (str != "да") {
        println("Уверены!? Может будете авторизовываться? (да - продолжить)")
        str = readLine()
    }
    while (str == "да") {
        authAccounts(accounts)
        println("Будете авторизовываться? (да - продолжить)")
        str = readLine()
    }
}

private val valuesToExit = arrayListOf(
    "закончить",
    "закрыть",
    "выйти",
    "close",
    "exit",
)

fun exitPost() {
    print("Для закрытия введите: ")
    for (i in valuesToExit) {
        if (i == valuesToExit.last()) {
            print("$i ")
            break
        }
        print("$i/")

    }
    println("- в логине или пароле")
}

fun isExitDialog(input: String): Boolean {
    return input in valuesToExit
}

fun regAccounts(): HashMap<String, String> {
    println("РЕГИСТРАЦИЯ: ")
    val accounts = HashMap<String, String>()
    while (true) {
        if (accounts.size % 3 == 0)
            exitPost()

        println("Введите логин: ")
        val loginK = readLine().toString()
        if (isExitDialog(loginK))
            break

        println("Введите пароль: ")
        val passwordV = readLine().toString()
        if (isExitDialog(passwordV))
            break

        accounts[loginK] = passwordV
    }
    return accounts
}

fun authAccounts(accounts: HashMap<String, String>) {
    var i = 0
    println("\nАВТОРИЗАЦИЯ: ")
    while (true) {
        if (i % 3 == 0)
            exitPost()
        println("Введите логин: ")
        val loginK = readLine().toString()
        if (isExitDialog(loginK))
            break

        println("Введите пароль: ")
        val passwordV = readLine().toString()
        if (isExitDialog(passwordV))
            break

        i++
        if (!accounts.keys.contains(loginK) || accounts[loginK] != passwordV) {
            println("Указан неверный логин или пароль")
            continue
        } else {
            println("\n Добро пожаловать $loginK!\n")
            break
        }
    }
}
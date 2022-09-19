fun main() {
    // зашифрованная строка
    val line = "F2p)v\"y233{0->c}ttelciFc"
    // получение первой и второй половины сообщения (m=message) ok
    var m1 = line.subSequence(0, line.length / 2).toString()
    var m2 = line.subSequence(line.length / 2, line.length).toString()
    // расшифровка
    m1 = decoding1(m1)
    m2 = decoding2(m2)
    // результат
    println(m1 + m2)

    // сдвиг (лямбда с shift)
    var m1n2 = line.subSequence(0, line.length / 2).toString()
    var m2n2 = line.subSequence(line.length / 2, line.length).toString()
    // передача лямбды для сдвига  вправо на 2
    m1n2 = decoding1(m1n2) { it.map { char -> char + 2 }.joinToString("") }
    m2n2 = decoding2(m2n2)
    // результат
    println(m1n2 + m2n2)
}

fun decoding1(
    message: String,
    shift: ((text: String) -> String)? = null
): String {
    //  замена все символы строки на соседний символ, сдвиг всех символов вправо на 1
    var result = message.map { char -> char + 1 }.joinToString("")

    result = result.replace("5", "s") // замена 5 на s
    result = result.replace("4", "u") // замена 4 на u

    // сдвиг всех символов левее на 3
    result = result.map { char -> char - 3 }.joinToString("")
    result = result.replace("0", "o") // замена 0 на o

    // проход по лямбде или без
    return if (shift == null)
        result
    else
        shift(result)
}

fun decoding2(
    message: String,
    shift: ((text: String) -> String)? = null
): String {
    // перевернуть (развернуть) строку
    var result = message.reversed()

    // сдвиг всех символов левее на 4
    result = result.map { char -> char - 4 }.joinToString("")

    // замена _ на пробел
    result = result.replace("_", " ")

    // проход по лямбде или без
    return if (shift == null)
        result
    else
        shift(result)
}
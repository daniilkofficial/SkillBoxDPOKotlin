import java.math.RoundingMode

fun Double.toRound(): Double {
    return this.toBigDecimal().setScale(2, RoundingMode.DOWN).toDouble()
}

fun inputDouble(text: String): Double {
    var num: Double? = null
    while (num == null) {
        println(text)
        num = readLine()?.toDoubleOrNull()
    }
    return num
}

fun inputString(text: String): String {
    var num: String? = null
    while (num == null) {
        println(text)
        num = readLine()
    }
    return num
}
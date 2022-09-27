import java.math.RoundingMode

fun main() {
    val wheel1 = Wheel(1.6)
    wheel1.apply {
        pressureCheck()
        var i = -1.0
        while (i <= 14.1) {
            if(2.2 == i.round()){
                pressureTryTo(1.6)
                pressureTryTo(1.8)
                pressureTryTo(2.6)
            }
            pressureTryTo(i.round())
            i += 1.09
        }

    }
}

fun Double.round() = toBigDecimal().setScale(1, RoundingMode.DOWN).toDouble()
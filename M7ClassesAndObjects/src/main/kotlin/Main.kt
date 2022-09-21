fun main() {
    val tv1 = TV()
    println("${tv1.mark} ${tv1.model} ${tv1.diagonal}")

    val tv2 = TV("XIAOMI Mi", "4S 50", 50.01)
    println(tv1.isPower)
    tv1.clickNumberChannel(4)
    tv1.upVolumeTo(50)
    tv1.powerOFF()
    tv1.clickNumberChannel(tv1.sizeChannel() + 1)
    tv1.clickNumberChannel(tv1.sizeChannel())
    tv1.upNumberChannel()
    tv1.upNumberChannel()
    tv1.downNumberChannel()
    tv1.downNumberChannel()
    tv1.upVolumeTo(200)

    tv1.listChannel()
    tv1.infoCurrentChannel()
    tv1.infoCurrentChannel("Россия-1")

    println("\nТЕСТИРОВАНИЕ")
    tv2.info()
    tv2.powerON()

    // нахождение кол-во раз сложения для максимальной суммы меньше 100
    var maxV = 0
    for (v in 0..100) {
        val n = v * (v + 1) / 2
        if (n >= 100) {
            maxV = v - 1
            println("\nMaxV: $maxV\n")
            break
        }
    }

    for (v in 0..maxV) {
        tv2.upVolumeTo(v)
    }

    for (v in 0..maxV) {
        tv2.downVolumeTo(v)
    }

    println("ОТЛЮЧЕНИЕ")
    tv2.powerOFF()
    tv2.upVolumeTo(50)
    tv2.downVolumeTo(50)
    tv2.infoCurrentChannel()
    tv2.infoCurrentChannel("Россия-1")
    tv2.listChannel()

    println()
    tv2.powerON()
    tv2.listChannel()
    tv2.powerOFF()
    println()

    println("ПЕРЕКЛЮЧЕНИЕ КАНАЛА")

    println("ВЫШЕ")
    val testMax = (tv2.sizeChannel() * 2) + 1
    for (i in 1..testMax) {
        tv2.upNumberChannel()
    }

    println("\nНИЖЕ")
    for (i in 0..testMax) {
        tv2.downNumberChannel()
    }
    tv2.infoCurrentChannel()
}
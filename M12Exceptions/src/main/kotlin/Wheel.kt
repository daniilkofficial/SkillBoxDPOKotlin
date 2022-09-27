class Wheel(private var pressure: Double) {
    // Эксплуатация возможна от 1,6 до 2,5 атмосферы

    private fun pressureTo(p: Double) { // накачать колесо до определённого давления
        if (p in 1.6..2.5) {
            pressure = p
            println("При накачке $p атмосферы процедура удалась. Эксплуатация возможна.")
        } else {
            pressureCheck(p)
        }
    }

    fun pressureCheck(p: Double = pressure) { // проверить уровень давления в колесе (Исключения)
        when {
            p <= 0.0 || p >= 10.0 -> throw IncorrectPressure()
            p > 2.5 -> throw TooHighPressure()
            p > 0.0 && p < 1.6 -> throw TooLowPressure()
            else -> println("При накачке $p атмосферы процедура удалась. Эксплуатация возможна.")
        }

    }

    fun pressureTryTo(p: Double) {
        try {
            pressureTo(p)
        } catch (e: IncorrectPressure) {
            if (p < 0)
                print("При накачке $p атмосфер процедура не удалась. \n")
            else
                print("При накачке $p атмосфер процедура удалась.")

            print(" Эксплуатация невозможна — ${e.message}.\n")
        } catch (e: TooHighPressure) {
            if (p < 0)
                print("При накачке $p атмосфер процедура не удалась. \n")
            else
                print("При накачке $p атмосфер процедура удалась.")

            print(" Эксплуатация невозможна — ${e.message}.\n")
        } catch (e: TooLowPressure) {
            print("При накачке $p атмосфер процедура удалась. Эксплуатация невозможна — ${e.message}.\n")
        }
    }
}
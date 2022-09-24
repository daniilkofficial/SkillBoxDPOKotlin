package bonus

interface Bonus {
    val bonusBallCashback: Double
    val bonusCashback: Double
    val bonusCashbackLimit: Int
    val bonusDeposit: Double
    var bonus: Double

    fun depositBonus(money: Int) {
        bonus += percent(bonusDeposit, money.toDouble())
    }

    fun percent(num1: Double, num2: Double): Double {
        return (num1 * num2) / 100.0
    }

    fun infoBonus() {
        println("Бонусы: ${format(bonus)}")
        println("Бонусные баллы в размере ${format(bonusBallCashback)}% от покупок")
        println("Потенциальный кэшбэк ${format(bonusCashback)}% от покупок при условии трат больше $bonusCashbackLimit")
        println("Накопление в размере ${format(bonusDeposit)}% от суммы пополнений")
    }

    fun format(num: Double) = String.format("%.2f", num)

    fun isBonus(money: Double) = money > bonusCashbackLimit

}
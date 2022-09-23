package bonus

interface Bonus {
    val bonusBallCashback: Double
    val bonusCashback: Double
    val bonusCashbackLimit: Int
    val bonusDeposit: Double

    fun infoBonus(bonus: Double) {
        val bonusStr = String.format("%.2f", bonus)
        println("Бонусы: $bonusStr")
        println("Бонусные баллы в размере $bonusBallCashback% от покупок")
        println("Потенциальный кэшбэк $bonusCashback% от покупок при условии трат больше $bonusCashbackLimit")
        println("Накопление в размере $bonusDeposit% от суммы пополнений")
    }
}
package bonus

import base.DebitCard

class DebitCardBonus(
    override var balance: Int,

    override val bonusBallCashback: Double,
    override val bonusCashback: Double,
    override val bonusCashbackLimit: Int,
    override val bonusDeposit: Double,
) : DebitCard(balance), Bonus {
    private var bonus: Double = 0.0

    // пополнение с бонусом
    override fun depositBonus(money: Int) {
        bonus += (bonusDeposit * money.toDouble()) / 100.0
    }

    // покупка бонусом
    override fun payBonus(money: Int) {
        bonus += (bonusBallCashback * money) / 100.0
        if (money > bonusCashbackLimit) {
            val cashBack = ((bonusCashback * money) / 100.0).toInt()
            balance += cashBack
            print("БОНУС $cashBack! ")
        }
    }

    override fun infoBonus() {
        super<Bonus>.infoBonus(bonus)
    }
}
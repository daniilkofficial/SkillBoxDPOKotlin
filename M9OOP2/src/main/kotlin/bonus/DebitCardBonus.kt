package bonus

import base.DebitCard

class DebitCardBonus(
    override var balance: Int,
    override val bonusBallCashback: Double,
    override val bonusCashback: Double,
    override val bonusCashbackLimit: Int,
    override val bonusDeposit: Double,
) : DebitCard(balance), Bonus {
    override var bonus: Double = 0.0

    // пополнение с бонусом
    override fun depositBonus(money: Int) {
        super<Bonus>.depositBonus(money)
    }

    override fun infoBonus() {
        super<Bonus>.infoBonus()
    }

    // покупка бонусом
    override fun payBonus(money: Int) {
        val moneyDouble = money.toDouble()
        bonus += percent(bonusBallCashback, moneyDouble)
        if (isBonus(moneyDouble)) {
            val cashBack = percent(bonusCashback, moneyDouble).toInt()
            balance += cashBack
            print("БОНУС $cashBack! ")
        }
    }


}
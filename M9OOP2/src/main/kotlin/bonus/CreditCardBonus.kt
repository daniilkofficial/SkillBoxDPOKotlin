package bonus

import base.CreditCard

class CreditCardBonus(
    override var balance: Int,
    override var creditBalance: Int,
    override val creditLimit: Int,
    override val bonusBallCashback: Double,
    override val bonusCashback: Double,
    override val bonusCashbackLimit: Int,
    override val bonusDeposit: Double,
) : CreditCard(balance, creditBalance, creditLimit), Bonus {
    private var bonus: Double = 0.0

    /*
    Бонусные баллы в размере 1% от покупок.
    Потенциальный кэшбэк 5% от покупок при условии трат больше 5 000 тыс.
    Накопление в размере 0.005% от суммы пополнений. */
    override fun depositBonus(money: Int) {
        bonus += (bonusDeposit * money) / 100.0
    }

    override fun payBonus(money: Int) {
        bonus += (bonusBallCashback * money) / 100.0 // от покупок баллы

        if (money > bonusCashbackLimit) {
            val str: String
            val cashBack = ((bonusCashback * money) / 100.0).toInt()
            if (creditBalance + cashBack < creditLimit) {
                str = "пришло на кредитный депозит"
                creditBalance += cashBack
            } else {
                str = "пришло на собственный депозит"
                balance += cashBack
            }

            print("БОНУС $cashBack $str\n")
        }
    }

    override fun infoBonus() {
        super<Bonus>.infoBonus(bonus)
    }
}
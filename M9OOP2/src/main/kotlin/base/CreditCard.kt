package base

open class CreditCard(
    override var balance: Int,
    open var creditBalance: Int,
    open val creditLimit: Int
) : BankCard() {

    /* При пополнении кредитной карты необходимо сначала погасить кредитную часть,
     и только затем увеличивать собственные средства. */
    override fun deposit(money: Int) {
        if (creditBalance > creditLimit)
            balance += money
        else {
            if (money + creditBalance > creditLimit) {
                val moneyPlus = (creditBalance + money) - creditLimit // остаток на прибавление
                creditBalance += money - moneyPlus  // из остатка на повышение
                balance += moneyPlus
            } else
                creditBalance += money
        }
        depositBonus(money)
        println("Пополнено на $money")
    }

    // При оплате сначала списываются собственные средства, затем кредитные.
    override fun pay(money: Int): Boolean {
        return if (balance > 0 || creditBalance > 0) {
            if (balance - money >= 0) {
                balance -= money
                payBonus(money)
                true
            } else if ((balance + creditBalance) - money >= 0) {
                val otherMoney = money - balance
                balance = 0
                creditBalance -= otherMoney
                payBonus(money)
                true
            } else
                false
        } else
            false
    }

    override fun infoBalance() {
        println("Баланс: $balance")
        println()
    }

    override fun infoAccessBalance() {
        println("Кредитная карта с лимитом: $creditLimit")
        println("Собственные средства: $balance")
        println("Кредитные средства: $creditBalance")
        infoBonus()
        println()
    }
}
package base

open class DebitCard(
    override var balance: Int
) : BankCard() {

    override fun deposit(money: Int) {
        balance += money
        depositBonus(money)
        println("Пополнено на $money")
    }

    override fun pay(money: Int): Boolean {
        return if (balance >= money) {
            balance -= money
            payBonus(money)
            true
        } else
            false
    }

    override fun infoBalance() {
        println("Баланс: $balance")
        println()
    }

    override fun infoAccessBalance() {
        println("Баланс: $balance")
        infoBonus()
        println()
    }
}
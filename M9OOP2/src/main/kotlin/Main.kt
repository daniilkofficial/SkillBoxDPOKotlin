import base.CreditCard
import base.DebitCard
import bonus.CreditCardBonus
import bonus.DebitCardBonus

fun main() {
    for (i in 0..3) {
        createCard(i)
    }
}

fun createCard(n: Int) {
    when (n) {
        0 -> {
            println("________________")
            println("Дебетовая карта")
            useDebitCard()
        }

        1 -> {
            println("Кредитная карта")
            useCreditCard()
        }

        2 -> {
            println("Дебетовая карта с бонусами")
            useDebitCardBonus()
        }

        3 -> {
            println("Кредитная карта с бонусами")
            useCreditCardBonus()
        }
    }

    println("________________")
}

fun useDebitCard() {
    val card = DebitCard(100)
    card.infoBalance()
    card.pay(120)
    card.pay(40)
    card.deposit(100)
}

fun useCreditCard() {
    val card = CreditCard(100, 8000, 10_000)
    card.infoBalance()
    card.infoAccessBalance()

    card.pay(100)
    card.pay(2100)

    card.deposit(5_200)
    card.deposit(5_200)

    card.pay(20_400)
    card.pay(14_000)

    card.deposit(4_000)
    card.pay(1_000)
}

fun useDebitCardBonus() {
    val card = DebitCardBonus(8_000, 1.0, 5.0, 5000, 0.05)
    card.infoAccessBalance()

    card.pay(6_000)
    card.deposit(1_000)
}

fun useCreditCardBonus() {
    val card = CreditCardBonus(
        2_000, 9_000, 12_000,
        1.45565, 5.4566, 900, 0.05
    )
    card.infoAccessBalance()

    card.pay(1_000)
    card.pay(2_200)
    card.deposit(6_300)
    card.pay(1_000)
}


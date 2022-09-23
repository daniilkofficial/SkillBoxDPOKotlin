import base.BankCard
import base.CreditCard
import base.DebitCard
import bonus.CreditCardBonus
import bonus.DebitCardBonus

fun main() {
    run()
}

fun run() {
    println("________________")
    println("Дебетовая карта")
    useDebitCard()
    println("________________")

    println("Кредитная карта")
    useCreditCard()
    println("________________")

    println("Дебетовая карта с бонусами")
    useDebitCardBonus()
    println("________________")

    println("Кредитная карта с бонусами")
    useCreditCardBonus()
    println("________________")
}

fun useDebitCard() {
    val card = DebitCard(100)
    card.infoBalance()

    isPay(card, 120)
    card.infoBalance()

    isPay(card, 40)
    card.infoBalance()

    card.deposit(100)
    card.infoBalance()
}

fun useCreditCard() {
    val card = CreditCard(100, 8000, 10_000)

    card.infoBalance()
    card.infoAccessBalance()

    isPay(card, 100)
    card.infoAccessBalance()

    isPay(card, 2100)
    card.infoAccessBalance()

    card.deposit(5_200)
    card.infoAccessBalance()

    card.deposit(5_200)
    card.infoAccessBalance()

    isPay(card, 20_400)
    card.infoAccessBalance()

    isPay(card, 14_000)
    card.infoAccessBalance()

    card.deposit(4_000)
    card.infoAccessBalance()

    isPay(card, 1_000)
    card.infoAccessBalance()
}

fun useDebitCardBonus() {
    val card = DebitCardBonus(8_000, 1.0, 5.0, 5000, 0.05)
    card.infoBalance()

    isPay(card, 6_000)
    card.infoAccessBalance()

    card.deposit(1_000)
    card.infoAccessBalance()
}

fun useCreditCardBonus() {
    val card = CreditCardBonus(
        2_000, 9_000, 12_000,
        1.45565, 5.4566, 900, 0.05
    )
    card.infoAccessBalance()

    isPay(card, 1_000)
    card.infoAccessBalance()

    isPay(card, 2200)
    card.infoAccessBalance()

    card.deposit(6_300)
    card.infoAccessBalance()

    isPay(card, 1_000)
    card.infoAccessBalance()
}

fun isPay(bankCard: BankCard, money: Int) {
    if (bankCard.pay(money))
        println("Оплата на $money")
    else
        println("Недостаточно средств на снятие $money")
}

package base

abstract class BankCard {
    abstract var balance: Int // баланс - сумма на карте
    abstract fun deposit(money: Int)  // пополнение баланса
    abstract fun pay(money: Int): Boolean // оплата с баланса
    abstract fun infoBalance() // информация о балансе
    abstract fun infoAccessBalance() // информация о балансе, кредитном лимите и любых других средств
    open fun depositBonus(money: Int) {} // пополнение бонуса
    open fun payBonus(money: Int) {}  // оплата бонусом
    open fun infoBonus() {} // информация о бонусе
}
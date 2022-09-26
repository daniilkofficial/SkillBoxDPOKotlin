interface CurrencyConverter {
    val currencyCode: String
    var rate: Double
    val date: String

    fun convertRubToCurrency(money: Double): Double = (money / rate).toRound()
    fun convertCurrencyToRub(money: Double): Double = (money * rate).toRound()
}
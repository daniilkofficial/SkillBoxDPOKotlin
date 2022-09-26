object Converters {
    fun get(currencyCode: String): CurrencyConverter {
        return when (currencyCode) {
            ConverterEU().currencyCode -> ConverterEU()
            ConverterUSD().currencyCode -> ConverterUSD()

            else -> {
                object : CurrencyConverter {
                    override val currencyCode: String
                        get() = currencyCode
                    override var rate: Double = rate() // курс
                    override val date: String = date()

                    private fun rate(): Double = inputDouble("Курс $currencyCode в RUB: ")
                    private fun date(): String = inputString("Дата курса: ")

//                    override fun convertToCurrency(money: Double): Double {
//                        return super.convertToCurrency(money)
//                    }


                }
            }

        }
    }
}
class TV(
    val mark: String = "XIAOMI MI",
    val model: String = "P1 50",
    val diagonal: Double = 50.0,
) {
    private var channel = Channel()  // каналы
    private var channelsList = Channels.getRandomChannels() // список каналов
    private var channelNumber: Int = 0  // номер канала

    private var volume: Int = 0 // звук
    var isPower: Boolean = false // включен
        private set

    // Функции
    fun info() { // вывод информации
        println("$mark $model - $diagonal")
    }

    fun powerON() { // включение
        isPower = true
        println("Телевизор: включен")
    }

    fun powerOFF() { // выключение
        isPower = false
        println("Телевизор: выключен")
    }

    fun getVolume(): Int {
        return volume
    }


    fun upVolumeTo(volume: Int) {
        if (this.volume + volume < MAX_VOLUME && isPower) {
            this.volume += volume
            println("Громкость (+$volume): ${this.volume}")
        } else if (isPower)
            println("Громкость завышена до придела!")
        else if (!isPower)
            println("Телевизор не включен!")
    }

    fun downVolumeTo(volume: Int) {
        if (this.volume - volume >= 0 && isPower) {
            this.volume -= volume
            println("Громкость (-$volume):  ${this.volume}")
        } else if (isPower)
            println("Громкость ниже придела!")
        else if (!isPower)
            println("Телевизор не включен!")
    }

    fun clickNumberChannel(n: Int) {
        if (!isPower)
            powerON()
        if (isChannel(n)) {
            channelNumber = n
            println("Переключение: $channelNumber — ${channelsList[channelNumber]}")
        } else {
            println("Данного канала нету ($n)!")
        }
    }

    fun upNumberChannel() {
        if (!isPower)
            powerON()
        if (isChannel(channelNumber + 1)) {
            channelNumber += 1
        } else {
            channelNumber = 0
        }
        println("Канал выше: $channelNumber — ${channelsList[channelNumber]}")
    }

    fun downNumberChannel() {
        if (!isPower)
            powerON()
        if (isChannel(channelNumber - 1)) {
            channelNumber -= 1
        } else {
            channelNumber = channelsList.size - 1

        }
        println("Канал ниже: $channelNumber — ${channelsList[channelNumber]}")
    }

    fun listChannel() {
        if (isPower) {
            println("Список каналов: ")
            channelsList.forEachIndexed { num, name ->
                println("$num — $name")
            }
        } else
            println("Сигнал отсутствует, телевизор не включен!")
    }

    fun sizeChannel(): Int = channelsList.size - 1

    fun infoCurrentChannel() {
        if (isPower) {
            val name = channelsList[channelNumber]
            val info = channel.infoChannel(name)
            println("\n- Сведения о ${name.uppercase()} \nОписание: $info")
        } else
            println("Сигнал отсутствует, телевизор не включен!")
    }

    fun infoCurrentChannel(name: String) {
        if (isPower) {
            val info = channel.infoChannel(name)
            println("\n- Сведения о ${name.uppercase()} \nОписание: $info")
        } else
            println("Сигнал отсутствует, телевизор не включен!")
    }

    private fun isChannel(channelNum: Int): Boolean = channelNum < channelsList.size && channelNum >= 0

    companion object {
        const val MAX_VOLUME = 100
    }

}
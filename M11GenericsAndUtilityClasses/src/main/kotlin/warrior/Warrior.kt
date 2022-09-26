package warrior

interface Warrior { // статус воина
    val isKilled: Boolean // умер ли
    val evasionChance: Int // шанс сбежать
    fun attack(enemy: Warrior) // атака
    fun getDamage(damage: Double) // получить урон (на нас атака)
}
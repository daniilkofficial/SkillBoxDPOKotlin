package weapon

sealed class FireType(val shotsValue: Int) { // тип стрельбы
    object SingleShot : FireType(1) // одиночный выстрел
    data class Burst(val burstValue: Int) : FireType(burstValue) // очередью выстрел
}
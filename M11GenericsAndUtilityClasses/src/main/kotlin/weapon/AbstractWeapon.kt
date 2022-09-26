package weapon

abstract class AbstractWeapon { // оружие
    protected abstract val ammoType: Ammo // патрон
    protected abstract val fireType: FireType // тип стрельбы
    protected abstract val magazineSize: Int // размер магазина
    private val ammoMagazine: Stack<Ammo> = Stack() // магазин с тип патрона
    val isMagazineEmpty: Boolean
        get() = ammoMagazine.isEmpty() // пустой ли магазин

    private fun createAmmo(): Ammo = ammoType // создать патрон


    fun reload() { // перезарядка
        if (isMagazineEmpty) {
            for (i in 0 until magazineSize) // до макс размера
                ammoMagazine.push(createAmmo()) // заполнение патроном
        }
    }


    fun shooting(): List<Ammo?> { // стрельба (возвращает список патронов до типа стрельбы)
        val shootsAmmo = mutableListOf<Ammo?>()
        for (i in 0 until fireType.shotsValue)
            shootsAmmo.add(ammoMagazine.pop()) // извлечение и удаление
        return shootsAmmo
    }
}
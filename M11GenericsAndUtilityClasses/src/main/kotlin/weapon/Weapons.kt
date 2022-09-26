package weapon

object Weapons {
    /*
    1) тип патрона
    2) тип стрельбы
    3) размер магазина
     */
    object ArisakaType99 : AbstractWeapon() { // винтовка (ближний)
        override val ammoType: Ammo = Ammo.ARMOUR_PIERCING
        override val fireType: FireType = FireType.SingleShot
        override val magazineSize: Int = 5
    }
    object M4 : AbstractWeapon() { // автомат (средний)
        override val ammoType: Ammo = Ammo.NORMAL
        override val fireType: FireType = FireType.Burst(8)
        override val magazineSize: Int = 30
    }
    object M4A1 : AbstractWeapon() { // автомат (выше средний)
        override val ammoType: Ammo = Ammo.INCENDIARY
        override val fireType: FireType = FireType.Burst(10)
        override val magazineSize: Int = 50
    }
    object BarrettM82 : AbstractWeapon() { // снайперская винтовка (дальнее)
        override val ammoType: Ammo = Ammo.INCENDIARY
        override val fireType: FireType = FireType.Burst(2)
        override val magazineSize: Int = 5
    }
}
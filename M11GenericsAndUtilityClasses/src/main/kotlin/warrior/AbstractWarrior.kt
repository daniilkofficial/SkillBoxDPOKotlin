package warrior

import isChance
import weapon.AbstractWeapon

abstract class AbstractWarrior : Warrior { // абстрактный воин
    override val isKilled: Boolean // умер при хп меньше или равно 0
        get() = hp <= 0

    override val evasionChance: Int // шанс сбежать (30% из хп + 1хп)
        get() = ((hp * 30) / maxHp).toInt() + 1

    protected abstract var hp: Double // жизнь (хп)
    protected abstract val maxHp: Double  // макс. хп
    protected abstract val accuracy: Int // точность
    protected abstract val weapon: AbstractWeapon // оружие

    override fun attack(enemy: Warrior) { // атака на воина (его статус)
        if (weapon.isMagazineEmpty) // при пустом магазине перезарядка
            weapon.reload()
        else {
            val shots = weapon.shooting() // список патронов после стрельбы
            shots.forEach {// пробегаем, считаем и наносим врагу урон
                if (it != null && accuracy.isChance() && !enemy.evasionChance.isChance())
                    enemy.getDamage(it.getCurrentDamage())
            }
        }
    }

    override fun getDamage(damage: Double) { // урон при живом по здоровью
        if (!isKilled) hp -= damage
    }

    fun getCurrentHp(): Double = hp // кол-во здоровья

    override fun toString(): String { // отображение здоровья (максимального и текущего)
        return "Max HP: $maxHp\n" +
                "HP: $hp\n"
    }
}
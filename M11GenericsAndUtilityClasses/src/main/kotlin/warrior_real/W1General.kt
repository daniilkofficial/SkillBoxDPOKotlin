package warrior_real

import warrior.AbstractWarrior
import weapon.AbstractWeapon
import weapon.Weapons

class W1General() : AbstractWarrior() { // Генерал
    override var hp: Double = 100.0
    override val maxHp: Double = 120.0
    override val accuracy: Int = 80 // точность
    override val weapon: AbstractWeapon = Weapons.BarrettM82
}
package warrior_real

import warrior.AbstractWarrior
import weapon.AbstractWeapon
import weapon.Weapons

class W3Lieutenant : AbstractWarrior() { // Лейтенант
    override var hp: Double = 100.0
    override val maxHp: Double = 100.0
    override val accuracy: Int = 60
    override val weapon: AbstractWeapon = Weapons.M4A1
}
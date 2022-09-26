package warrior_real

import warrior.AbstractWarrior
import weapon.AbstractWeapon
import weapon.Weapons

class W4Soldier : AbstractWarrior() { // Солдат
    override var hp: Double = 100.0
    override val maxHp: Double = 100.0
    override val accuracy: Int = 50
    override val weapon: AbstractWeapon = Weapons.M4
}
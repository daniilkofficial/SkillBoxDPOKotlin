package warrior_real

import warrior.AbstractWarrior
import weapon.AbstractWeapon
import weapon.Weapons

class W2Captain : AbstractWarrior() { // Капитан
    override var hp: Double = 100.0
    override val maxHp: Double = 120.0
    override val accuracy: Int = 70
    override val weapon: AbstractWeapon = Weapons.ArisakaType99
}
package weapon

import isChance

enum class Ammo( // тип патрона
    private val damage: Double, // урон
    private val criticalHit: Int, // критического урон
    private val criticalRation: Int // коэффициент критического урона
) {
    /**
     * зажигательный
     */
    ARMOUR_PIERCING(10.0, 10, 4),
    /**
     * бронебойный
     */
    INCENDIARY(8.0, 25, 3), // бронебойный
    /**
     * нормальный
     */
    NORMAL(5.0, 35, 2); // нормальный

    // Текущий урон, при шансе урон * коэффициент критического урона, без шанса повреждение
    fun getCurrentDamage(): Double { // пример: 10x2
        if (criticalHit.isChance()) return damage * criticalRation
        return damage
    }
}
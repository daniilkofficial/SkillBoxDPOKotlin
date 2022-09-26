package battle

import warrior.AbstractWarrior
import warrior_real.W1General
import warrior_real.W2Captain
import warrior_real.W3Lieutenant
import warrior_real.W4Soldier
import kotlin.random.Random

class Team(size: Int) { // команда
    val members: MutableList<AbstractWarrior> = mutableListOf() // члены команды

    val currentNumberOfMembers: Int // текущее кол-во
        get() = members.size

    val isAllMembersKilled: Boolean // все умерли
        get() = members.isEmpty()

    val totalHp: Double // всего здоровье команды
        get() = members.sumOf { it.getCurrentHp() }

    fun deleteKilledMembers() { // удалить умерших
        val killedMembers = mutableListOf<AbstractWarrior>()
        members.forEach {
            if (it.isKilled) killedMembers.add(it)
        }
        members.removeAll(killedMembers)
    }

    // текущее кол-во по типам: генерал и т.д.
    fun sumGenerals(): Int {
        return members.filterIsInstance<W1General>().size
    }

    fun sumCaptains(): Int {
        return members.filterIsInstance<W2Captain>().size
    }

    fun sumLieutenants(): Int {
        return members.filterIsInstance<W3Lieutenant>().size
    }

    fun sumSoldiers(): Int {
        return members.filterIsInstance<W4Soldier>().size
    }


    fun getRandomMember(): AbstractWarrior { // генерация кол-ва человек
        return members[Random.nextInt(0, members.size)]
    }

    init {
        for (i in 0 until size) {
            when (Random.nextInt(101)) { // инициализация
                in 1..10 -> members.add(W1General()) // вероятность добавления генерала 1-10
                in 11..30 -> members.add(W2Captain())
                in 31..50 -> members.add(W3Lieutenant())
                in 51..100 -> members.add(W4Soldier()) // высокая вероятность создать солдат
            }
        }
    }

}
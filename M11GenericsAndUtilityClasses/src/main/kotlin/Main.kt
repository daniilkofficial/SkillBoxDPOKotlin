import battle.Battle
import battle.BattleState

/*
Структура:
+ Расширение Int.isChance (функция-расширение) - выше шанс лучше вероятность

- weapon:
+ Stack (generic через mutableList) - список патронов, магазин
+ Ammo (enum) - патрон (бронебойный и т.д. и расчет урона)
+ FireType (sealed-class) - тип стрельбы (одиночный/очередью)
+ AbstractWeapon (abstract class) - оружие от Ammo, FireType, Stack<Ammo>, Ammo, перезарядка и стрельба
+ Weapons (object) - реализованные оружия, возврат object (анонимных классов) AbstractWeapon

- warrior
+ Warrior (interface) - статус воина (шанс сбежать, атака и получить урон)
+ AbstractWarrior (abstract class) - абстрактный воин от Warrior для warrior_real
умер, сбежать, хп (здоровье и отображение), точность, оружие, атака и урон

- warrior_real
+ Classes от AbstractWarrior (class). Наследники: General, Captain, Lieutenant и Soldier
Генерал, Капитан, Лейтенант и Солдат (ГКЛС)

- battle:
+ Team (class) - команды
+ BattleState (sealed-class) - состояние сражения
+ Battle (class) - битва, логика сражения
 */

fun main() {
    println("Кол-во воинов в командах: ")
    var numWarrior: Int? = readLine()?.toIntOrNull()
    while (numWarrior == null) {
        println("Данные не корректные")
        println("Кол-во воинов в командах: ")
        numWarrior = readLine()?.toIntOrNull()
    }

    println("Начало боя!")
    play(Battle(numWarrior))
}

fun play(battle: Battle) {
    while (true) { // вечный цикл до конца боя
        when (val battleState = battle.getBattleState()) { // состояние боя
            is BattleState.Progress -> { // при прогрессе выводит прогресс боя и продолжаем
                println(battleState.toString())
                battle.run()
            }

            BattleState.FirsTeamWin -> {
                println("Первая команда победила")
                break
            }

            BattleState.SecondTeamWin -> {
                println("Вторая команда победила")
                break
            }

            BattleState.Nix -> {
                println("Ничья среди команд")
                break
            }
        }
    }
}

// число текущее больше генерируемого (чем выше шанс, тем выше вероятность до 100%)
fun Int.isChance(): Boolean = this >= (1..100).random()
package battle

sealed class BattleState { // реализация, состояние сражения
    // тип победы
    object FirsTeamWin : BattleState() // первая команда
    object SecondTeamWin : BattleState() // вторая команда
    object Nix : BattleState() // ничья

    // прогресс
    data class Progress(
        val totalNumberOfMembers: Int, // кол-во человек
        val generals: Int, // кол-во генералов и других
        val captains: Int,
        val lieutenants: Int,
        val soldiers: Int,
        val team1TotalHp: Double, // всего хп команда 1
        val team2TotalHp: Double // всего хп команда 2
    ) : BattleState() {

        override fun toString(): String { // отображение статуса
            return "Всего бойцов: $totalNumberOfMembers\n" +
                    "Генерал(ы): $generals\n" +
                    "Капитан(ы): $captains\n" +
                    "Лейтенант(ы): $lieutenants\n" +
                    "Солдат(ы): $soldiers\n" +
                    "Команда 1 всего ХП: $team1TotalHp\n" +
                    "Команда 2 всего ХП: $team2TotalHp\n"
        }
    } // конец прогресса
}

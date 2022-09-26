package battle

class Battle(teamSize: Int) { // битва и логика сражения
    private val team1: Team = Team(teamSize)
    private val team2: Team = Team(teamSize)
    private val isGameOver: Boolean // окончание битвы при смертях команды
        get() = team1.isAllMembersKilled || team2.isAllMembersKilled


    fun getBattleState(): BattleState { // получить статуса битвы и победителя
        // кто жив, кто мертв
        if (isGameOver)
            return if (team2.isAllMembersKilled && team1.isAllMembersKilled)
                BattleState.Nix // ничья
            else if (team1.isAllMembersKilled)
                BattleState.FirsTeamWin // первая команда победила
            else BattleState.SecondTeamWin // вторая команда победила
        return BattleState.Progress( // прогресс боя (data-class)
            team1.currentNumberOfMembers + team2.currentNumberOfMembers,
            team1.sumGenerals() + team2.sumGenerals(),
            team1.sumCaptains() + team2.sumCaptains(),
            team1.sumLieutenants() + team2.sumLieutenants(),
            team1.sumSoldiers() + team2.sumSoldiers(),
            team1.totalHp,
            team2.totalHp
        )
    }


    fun run() {  // атака команд и удаление умерших, пока не закончился бой
        if (!isGameOver) {
            team1.members.forEach { it.attack(team2.getRandomMember()) }
            team2.members.forEach { it.attack(team1.getRandomMember()) }
            team1.deleteKilledMembers()
            team2.deleteKilledMembers()
        }
    }
}
class Player(
    attack: Int,
    protection: Int,
    health: Int
) : Creature() {
    private var healCounter = 3

    init {
        super.attack = attack
        super.protection = protection
        super.health = health
        super.healthMax = health
    }

    fun healing() {
        if (healCounter > 0) {
            val upHealth = super.health + healthMax / 2
            if (upHealth > healthMax) {
                super.health = healthMax
            } else {
                super.health = upHealth
            }

            healCounter--
            if (healCounter != 0) {
                println(
                    "Игрок применил исцеление!!! " +
                            "\nОстал${if (healCounter == 1) "ась" else "ись"} " +
                            "$healCounter попытк${if (healCounter == 1) "а" else "и"} исцеления"
                )
            } else {
                println("Осталось 0 попыток исцеления")
            }
        } else {
            println("Попыток исцеления - $healCounter")
        }
    }
}
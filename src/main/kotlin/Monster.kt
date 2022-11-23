class Monster(
    attack: Int,
    protection: Int,
    health: Int,
) : Creature() {
    init {
        super.attack = attack
        super.protection = protection
        super.health = health
        super.healthMax = health
    }
}
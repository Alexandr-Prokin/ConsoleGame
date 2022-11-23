import kotlin.random.Random


abstract class Creature {
    companion object {
        const val attackMin = 1
        const val attackMax = 20
        const val protectionMin = 1
        const val protectionMax = 20
        const val healthMin = 0
    }

    protected var healthMax: Int = 0

    var attack: Int = attackMin
        set(value) {
            field = if (value <= attackMax) {
                value
            } else {
                attackMax
            }
        }

    var protection: Int = protectionMin
        set(value) {
            field = if (value <= protectionMax) {
                value
            } else {
                protectionMax
            }
        }

    var health: Int = 0
        set(value) {
            field = if (value >= healthMin) {
                value
            } else {
                healthMin
            }
        }

    fun attackEnemy(): Int {
        return Random.nextInt(1, attack).run {
            println("${this@Creature.javaClass.canonicalName} нанес $this урона ")
            this
        }
    }

    fun checkStatus() {
        println(
            "Параметры ${this.javaClass.canonicalName}:" + "\n\tЗдоровье: $health/$healthMax" + "\n\tАтака: $attackMin-$attack" + "\n\tЗащита: $protection"
        )
    }

    fun checkHealth() {
        if (health == healthMin) {
            println("${this.javaClass.canonicalName} погиб")
        }
        println("У ${this.javaClass.canonicalName} осталось ${health}/$healthMax")
    }
}


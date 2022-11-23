import kotlin.math.abs
import kotlin.random.Random

fun main(args: Array<String>) {
    var action = " "
    var health = 0
    println(
        "Добро пожаловать в игру!" +
                "\nСражайся с монстрами и побеждай!"
    )
    do {
        try {
            println("Введите колличество желаемого здоровья")
            health = readln().toInt()
        } catch (e: Exception) {
            println("Ошибочка....нужны цифры")
        }
    } while (health == 0)

    val player = Player(
        Random.nextInt(1, 20),
        Random.nextInt(1, 20),
        abs(health),
    )
    val monster = Monster(
        Random.nextInt(1, 20),
        Random.nextInt(1, 20),
        player.health * 2
    )

    while ((player.health > 0 && monster.health > 0) || action == "0") {
        println(
            "Выберите действие: \n\t1 - атаковать монстра" +
                    "\n\t2 - вылечить ХП" +
                    "\n\t3 - посмотреть параметры и здоровье" +
                    "\n\t4 - посмотреть параметры и здоровье Монстра" +
                    "\n\t0 - закончить игру"
        )
        print("Выбрано действие ->")
        action = readln()
        when (action) {
            "1" -> {
                println("|------------------------------|")
                if (castCube(player.attack, monster.protection)) {
                    monster.health -= player.attackEnemy()
                    monster.checkHealth()
                } else {
                    println("Игрок промахнулся")
                }
                println("-\t-\t-\t-\t-\t-\t-\t-\t-")
                if (castCube(monster.attack, player.protection) && monster.health != 0) {
                    player.health -= monster.attackEnemy()
                    player.checkHealth()
                } else {
                    println("Монстр промахнулся")
                }
                println("|------------------------------|")
            }

            "2" -> player.healing()
            "3" -> player.checkStatus()
            "4" -> monster.checkStatus()
            "0" -> break
            else -> println("Такого действия нету")
        }
    }
    println("********************************")
    if (monster.health == 0) {
        println("Монстр уничтожен, победил Игрок")
    }
    if (player.health == 0) {
        println("Игрок уничтожен, победил Монстр")
    }
    println("Игра окончена")
    println("********************************")

}

fun castCube(attack: Int, protection: Int): Boolean {
    val attackModifier = (attack - protection + 1).let {
        if (it >= 0) it else 1
    }

    return MutableList(attackModifier) {
        Random.nextInt(1, 6)
    }.any {
        it == 5 || it == 6
    }
}
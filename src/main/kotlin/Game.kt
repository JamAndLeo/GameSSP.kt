fun main() {
    println("Ну что боец! Назови своё имя:")
    var userName = readLine()
    if (userName == "") {
        userName = "Незнакомец"
        println("Хорошо! Это твой выбор! Буду тебя звать просто - $userName")
    } else println("Ииииииии Владыка Арены приветствует тебя - $userName")

    var wantElse = "Да"
    while (wantElse == "Да") {
        val options = arrayOf("Камень", "Бумага", "Ножницы")
        val gameChoice = getGameChoice(options)
        val userChoice = getUserChoice(options, userName)
        printResult(gameChoice, userChoice)
        println("Ты будешь испытывать судьбу ещё раз, человечишка? Да или Нет")

        var isValidChice = false

        while (!isValidChice) {
            var doneChoice = readLine()
            var x = doneChoice?.trim()?.lowercase()?.replaceFirstChar { it.uppercase() }

            if (x == "Нет" || x == "Да") {
                isValidChice = true
                wantElse = x
            } else {
                println("А ты, дорогой мой $userName,меня за дурака держишь? ;( Введи ВРАЗУМИТЕЛЬНЫЙ ответ!!!")
            }

        }
    }
    println("Спасибо за Игру! Надеюсь когда-нибудь ты снова наберешься смелости и вернешься для новых битв!")
}


fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]
fun getUserChoice(optionsParam: Array<String>, name: String?): String {
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice) {                //будет работать пока результат в скобках true (т.е. не ложь = истинна)
        print("Дорогой мой $name, введите одно из следующих значений:")
        for (n in optionsParam) print(" $n") //фигурные скобки убираются если одна операция
        println(".")                         // всего лишь добавили точку после пропечатки массива
        var userInputPreConverted = readLine()
        var userInput = userInputPreConverted?.trim()?.lowercase()?.replaceFirstChar { it.uppercase() }
        if (userInput != null && userInput in optionsParam) {  //хз, но всегда надо проверять что не null
            isValidChoice =
                true      //переделали на истинну,  в скобках цикла будет (не истинна = ложь), цикл прекратиться
            userChoice = userInput
        }
        if (!isValidChoice) println("Не юли, $name! Ты должен ввести допустимое значение!") //если в скобках получилась истинна то печатаем
    }
    return userChoice
}

fun printResult(gameChoce: String, userChoice: String) { //без ретурна

    val result: String
    if (gameChoce == userChoice) result = ("Ничья! Поздравляем всех!")
    else if ((userChoice == "Камень" && gameChoce == "Ножницы") ||
        (userChoice == "Бумага" && gameChoce == "Камень") ||
        (userChoice == "Ножницы" && gameChoce == "Бумага")
    ) result = "Ты победил! Ты игроМОНСТР!"
    else result = "Ничтожество - ты проиграл!"
    println("Человек, ты выбрал $userChoice. Компьютерный интеллект выбрал $gameChoce.\n$result")
}


//println("Пожалуйств введите одно из следующих значений:"{$for(n in optionsParam){println(n)})


/* для проверки вариативности
var x=1
while(x<10){
    println(getGameChoice(options))
    x=x+1}
     */
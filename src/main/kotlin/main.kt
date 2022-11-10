fun main() {
    val secondsAgo = 1234
    println(timeAgo(secondsAgo))
}

fun minutesAgo(secondsAgo: Int): String {
    val minutes = secondsAgo / 60
   val minutesAgoString = when {
        (minutes % 10 == 1 && minutes % 100 != 11 ) -> "$minutes минуту назад"
        (minutes % 10 in 2..3 ) -> "$minutes минуты назад"
       else -> "$minutes минут назад"
    }
    return minutesAgoString
}

fun hoursAgo(secondsAgo: Int): String {
    val hours = (secondsAgo / 60) / 60
    val hoursAgoString = when {
        (hours % 10 == 1 && hours % 100 != 11) -> "$hours час назад"
        (hours % 10 in 2..4) -> "$hours часа назад"
        else -> "$hours часов назад"
    }
    return hoursAgoString
}

fun timeAgo(secondsAgo: Int): String = when (secondsAgo) {
        in 0..60 -> "был(а) только что"
        in 61..3600 -> "был(а) в сети ${minutesAgo(secondsAgo)}"
        in 3601..86400 -> "был(а) в сети ${hoursAgo(secondsAgo)}"
        in 86401..172_800 -> "был(а) в сети вчера"
        in 172_801..259_200 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }


package com.futuristicmobilieapps.commons.extensions.kotlin

fun String?.validateText() = if (this.isValidString()) this!!.validateString() else ""

fun String.isValidName(): Boolean {

    val regex = "^[A-Za-z\\d #&'()\\-]{1,75}$"

    return regex.toRegex().matches(this.validateText())
}

fun String.isValidPhone(): Boolean {

    val regex = """\((?!0)\d{3}\) \d{3}-\d{4}"""

    return regex.toRegex().matches(this.validateText())
}

fun String.isValidPassword(): Boolean {

    val regex = Regex("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+~?*!]).{6,}")

    return regex.matches(this)
}

fun String?.isValidEIN(): Boolean {

    val regex = "^\\d\\d?-\\d{7}$"

    return this?.matches(regex.toRegex()) ?: false
}

fun String?.isRepeatedChar(): Boolean {

    val target = this?.replace(Regex("[()-//s]"), "")?.trim()

    return target.isNullOrEmpty() || target.all { it == target[0] }
}


fun String?.isCorrectEIN(): Boolean {

    return this?.let {

        val cleanedString = it.replace(Regex("[()\\s]"), "").trim()

        it.isValidEIN() && !cleanedString.isRepeatedChar() && cleanedString != "123456789" &&
                it.substring(0, 2) !in listOf("07", "08", "09", "17", "18", "19", "28", "29", "49", "69", "70", "78", "79", "89")
    } ?: false

}

fun String?.isValidEmail(): Boolean {

    return this != null && Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$").
    matches(this)
}


fun String?.isValidZipCode(): Boolean {

    val regex = "^\\d{5}(-\\d{4})?\$"

    return this?.matches(regex.toRegex()) ?: false
}





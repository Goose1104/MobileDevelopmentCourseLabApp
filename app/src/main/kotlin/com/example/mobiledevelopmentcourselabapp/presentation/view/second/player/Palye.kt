package com.example.mobiledevelopmentcourselabapp.presentation.view.second.player // Объявление пакета, в котором находится данный файл (данные об игроке для второго экрана)

import java.text.ParsePosition // Импорт класса ParsePosition, который используется для парсинга строк

// Определение класса Player, представляющего данные об игроке
class Palye(

    // Свойство name типа String, представляющее имя игрока
    val name: String,

    // Свойство PhotoURL типа String, представляющее URL фотографии игрока
    val PhotoURL: String,

    // Свойство Number типа String, представляющее номер игрока
    val Number: String,

    // Свойство Team типа String, представляющее команду игрока
    val Team: String,

    // Свойство Age типа String, представляющее возраст игрока
    val Age: String,

    // Свойство position типа PlayePosition, представляющее позицию игрока
    val position: PlayePosition,

    // Свойство isExpended типа Boolean, указывающее, развернута ли информация об игроке (по умолчанию false)
    var isExpended: Boolean = false,
) {} // Пустой блок кода, так как класс не содержит дополнительных методов

// Определение перечисления PlayePosition, представляющего возможные позиции игрока
enum class PlayePosition(val rusName: String) { // Каждый элемент перечисления имеет значение rusName типа String

    // Элемент GOALKEEPER с русским названием "Вратарь"
    GOALKEEPER("Вратарь"),

    // Элемент DEFENDER с русским названием "Защитник"
    DEFENDER("Защитник"),

    // Элемент MIDFIELD с русским названием "Полузащитник"
    MIDFIELD("Полузащитник"),

    // Элемент RORWARD с русским названием "Нападающий"
    RORWARD("Нападающий")
}
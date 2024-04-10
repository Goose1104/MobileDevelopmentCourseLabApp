package com.example.mobiledevelopmentcourselabapp.presentation.view.second.player // Объявление пакета, в котором находятся классы, связанные с игроками

import java.io.Serializable // Импорт интерфейса Serializable, позволяющего сериализовать объекты

// Объявление интерфейса iUModal, который будет реализовываться классами Player, Add и Pic
interface iUModal : Serializable // Интерфейс расширяет Serializable для возможности сериализации объектов

// Объявление класса Player, представляющего данные об игроке
class Player(
    val name: String, // Имя игрока (тип String)
    val PhotoURL: String, // URL фотографии игрока (тип String)
    val Number: Int, // Номер игрока (тип Int)
    val Team: String, // Команда игрока (тип String)
    val Age: Int, // Возраст игрока (тип Int)
    val position: PlayerPosition, // Позиция игрока (тип PlayerPosition)
    var isExpended: Boolean = false, // Флаг, указывающий, развернута ли информация об игроке (тип Boolean, по умолчанию false)
) : iUModal {} // Класс Player реализует интерфейс iUModal

// Объявление перечисления PlayerPosition, представляющего возможные позиции игрока
enum class PlayerPosition(val rusName: String) { // Каждый элемент перечисления имеет значение rusName типа String
    GOALKEEPER("Вратарь"), // Позиция вратаря
    DEFENDER("Защитник"), // Позиция защитника
    MIDFIELD("Полузащитник"), // Позиция полузащитника
    RORWARD("Нападающий") // Позиция нападающего
}

// Объявление класса Add, представляющего элемент "Добавить"
class Add(
    val text: String, // Текст элемента "Добавить" (тип String)
) : iUModal // Класс Add реализует интерфейс iUModal

// Объявление класса Pic, представляющего элемент "Объект"
class Pic(
    val PhotoURL: String, // URL фотографии объекта (тип String)
    val name: String, // Имя объекта (тип String)
    val Age: Int, // Возраст объекта (тип Int)
) : iUModal {} // Класс Pic реализует интерфейс iUModal
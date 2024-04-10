package com.example.mobiledevelopmentcourselabapp.presentation.view.second.Generator // Объявление пакета, в котором находится данный файл (генератор данных для второго экрана)

import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Add // Импорт класса Add, представляющего элемент "Добавить"
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Pic // Импорт класса Pic, представляющего элемент "Объект"
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Player // Импорт класса Player, представляющего элемент "Игрок"
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.PlayerPosition // Импорт перечисления PlayerPosition, представляющего позиции игроков
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.iUModal // Импорт интерфейса iUModal, общего для всех элементов списка
import com.github.javafaker.Faker // Импорт библиотеки JavaFaker для генерации случайных данных
import javax.inject.Inject // Импорт аннотации Inject из Dagger для внедрения зависимостей
import javax.inject.Singleton // Импорт аннотации Singleton из Dagger для создания единственного экземпляра объекта
import kotlin.random.Random // Импорт класса Random из Kotlin для генерации случайных чисел

// Определение объекта Generator, который будет использоваться для генерации данных
object Generator  {

    // Константа с количеством генерируемых игроков
    private const val PLAYERS_COUNT = 100

    // Ссылка на базовый URL для фотографий игроков
    private val PHOTO_LINK = "https://img.a.transfermarkt.technology/portrait/medium/"

    // Массив с именами файлов фотографий
    private val photos = arrayOf(
        "290532-1686212081.jpg", "709726-1672304545.jpg", "315252-1605116025.png", "748319-1694617058.jpg",
        "1036407-1706528684.jpg", "705864-1678301241.jpg", "149577-1617369576.png"
    )

    // Функция generate для генерации списка элементов iUModal
    fun generate(): List<iUModal> {

        // Создание экземпляра класса Faker для генерации случайных данных
        val faker = Faker()

        // Создание изменяемого списка элементов iUModal с помощью функции apply
        return mutableListOf<iUModal>().apply {

            // Цикл для генерации игроков и добавления их в список
            repeat(PLAYERS_COUNT) {

                // Добавление нового объекта Player в список
                add(
                    Player(
                        name = faker.name().fullName(), // Генерация случайного имени и фамилии
                        Team = faker.team().name(), // Генерация случайного названия команды
                        Number =  (1..25).random(), // Генерация случайного номера игрока от 1 до 25
                        Age = (18..35).random(), // Генерация случайного возраста игрока от 18 до 35
                        position = PlayerPosition.values().random(), // Генерация случайной позиции игрока
                        PhotoURL = PHOTO_LINK + photos.random() // Генерация случайного URL фотографии игрока
                    )
                )

                // Добавление нового объекта Pic в список
                add(
                    Pic(
                        PhotoURL = PHOTO_LINK + photos.random(), // Генерация случайного URL фотографии
                        name = faker.name().fullName(), // Генерация случайного имени и фамилии
                        Age = (0..100).random(), // Генерация случайного возраста от 0 до 100
                    )
                )

                // Добавление нового объекта Add в список с некоторой вероятностью
                if (Random.nextBoolean()){
                    add(Add(faker.funnyName().name())) // Генерация случайного смешного имени
                }
            }
        }
    }
}
package com.example.mobiledevelopmentcourselabapp.presentation.view.second // Объявление пакета, в котором находится данный презентер (CardPresentor)

import android.content.Context // Импорт класса Context, предоставляющего доступ к информации о приложении
import android.content.Intent // Импорт класса Intent, используемого для передачи данных между компонентами приложения
import androidx.core.content.ContextCompat.startActivity // Импорт функции startActivity из androidx.core.content для запуска Activity с помощью интента
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Player // Импорт класса Player, представляющего данные об игроке
import moxy.MvpPresenter // Импорт базового класса MvpPresenter из библиотеки Moxy для создания презентеров в MVP-архитектуре
import javax.inject.Inject // Импорт аннотации Inject из Dagger для внедрения зависимостей

// Объявление класса CardPresentor, наследующего от MvpPresenter и управляющего логикой фрагмента CardFragment
class CardPresentor @Inject constructor(): MvpPresenter<CardMVPView>() { // Аннотация @Inject указывает, что Dagger будет создавать экземпляры этого класса

    // Функция sharePlayerData, принимающая объект Player и отвечающая за шаринг данных об игроке
    fun sharePlayerData(player: Player) {
        val intent = Intent(); // Создание нового объекта Intent
        intent.action = Intent.ACTION_SEND // Установка действия интента на ACTION_SEND для шаринга данных
        intent.type = "text/plain" // Установка типа данных интента на "text/plain" для передачи текстового содержимого
        intent.putExtra( // Добавление данных в интент с помощью putExtra
            Intent.EXTRA_TEXT, // Ключ для данных - EXTRA_TEXT, указывающий, что это текст для шаринга
            """            
            Имя игрока: ${player?.name}            
            Возраст: ${player?.Number}            
            Номер: ${player?.Age}            
            Позиция: ${player?.position}            
            Команда: ${player?.Team}        
        """.trimIndent() // Значение данных - форматированная строка с информацией об игроке, trimIndent удаляет отступы в начале строк
        )
        val shareIntent = Intent.createChooser(intent, null) // Создание интента выбора приложения для шаринга
        viewState.share(shareIntent) // Вызов метода share из viewState для открытия интента выбора приложения
    }
}
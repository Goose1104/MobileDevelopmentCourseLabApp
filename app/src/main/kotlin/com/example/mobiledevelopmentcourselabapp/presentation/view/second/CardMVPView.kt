package com.example.mobiledevelopmentcourselabapp.presentation.view.second // Объявление пакета, в котором находится данный интерфейс (CardMVPView)

// Импортирование необходимых классов и интерфейсов
import android.content.Intent // Класс для работы с интентами (передача данных между компонентами приложения)
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Player // Класс Player, представляющий данные об игроке
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.iUModal // Интерфейс iUModal, общий для всех элементов списка
import moxy.MvpView // Интерфейс MvpView из Moxy (MVP-фреймворк)
import moxy.viewstate.strategy.alias.AddToEndSingle // Стратегия обновления состояния View в Moxy
import moxy.viewstate.strategy.alias.OneExecution // Стратегия выполнения метода View в Moxy

// Объявление интерфейса CardMVPView, наследующего от MvpView и представляющего контракт для View в MVP-архитектуре
interface CardMVPView: MvpView {

    // Метод share для открытия интента для шаринга данных
    @OneExecution // Аннотация, указывающая, что метод будет выполнен только один раз
    fun share(intent: Intent) // Принимает параметр intent типа Intent
}
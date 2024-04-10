package com.example.mobiledevelopmentcourselabapp.presentation.view.second // Объявление пакета, в котором находится данный интерфейс (SecondMVPView)

// Импортирование необходимых классов и интерфейсов
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Player // Класс Player, представляющий данные об игроке
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.iUModal // Интерфейс iUModal, общий для всех элементов списка
import moxy.MvpView // Интерфейс MvpView из Moxy (MVP-фреймворк)
import moxy.viewstate.strategy.alias.AddToEnd // Стратегия обновления состояния View в Moxy: добавляет новое состояние в конец списка
import moxy.viewstate.strategy.alias.AddToEndSingle // Стратегия обновления состояния View в Moxy: добавляет новое состояние в конец списка, заменяя предыдущее состояние того же типа
import moxy.viewstate.strategy.alias.OneExecution // Стратегия выполнения метода View в Moxy: метод будет выполнен только один раз

// Объявление интерфейса SecondMVPView, наследующего от MvpView и представляющего контракт для View в MVP-архитектуре
interface SecondMVPView: MvpView {

    // Метод navigateToPlayer для перехода к экрану с информацией об игроке
    @OneExecution // Аннотация, указывающая, что метод будет выполнен только один раз
    fun  navigateToPlayer(iUModal: iUModal) // Принимает параметр iUModal типа iUModal (данные об игроке или объекте)

    // Метод showPlayers для отображения списка игроков
    @AddToEndSingle // Аннотация, указывающая, что новое состояние будет добавлено в конец списка, заменяя предыдущее состояние типа List<iUModal>
    fun showPlayers(player: List<iUModal>) // Принимает параметр player типа List<iUModal> (список игроков и объектов)
}
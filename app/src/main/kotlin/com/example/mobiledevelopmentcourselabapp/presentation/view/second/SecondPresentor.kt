package com.example.mobiledevelopmentcourselabapp.presentation.view.second // Объявление пакета, в котором находится данный презентер (SecondPresentor)

// Импортирование необходимых классов
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.Generator.Generator // Импорт объекта Generator для генерации данных
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.iUModal // Импорт интерфейса iUModal, общего для всех элементов списка
import moxy.MvpPresenter // Импорт базового класса MvpPresenter из библиотеки Moxy для создания презентеров в MVP-архитектуре
import javax.inject.Inject // Импорт аннотации Inject из Dagger для внедрения зависимостей

// Объявление класса SecondPresentor, наследующего от MvpPresenter и управляющего логикой фрагмента SecondFragment
class SecondPresentor @Inject constructor(): MvpPresenter<SecondMVPView>() {

    // Функция onPlayerClicked, вызываемая при клике на элемент игрока
    fun onPlayerClicked(iUModal: iUModal) {
        // Вызов метода navigateToPlayer из View для перехода к экрану с информацией об игроке
        viewState.navigateToPlayer(iUModal)
    }

    // Метод onFirstViewAttach, вызываемый при первом присоединении View к презентеру
    override fun onFirstViewAttach() {
        super.onFirstViewAttach() // Вызов метода onFirstViewAttach родительского класса

        // Вызов метода showPlayers из View для отображения сгенерированного списка игроков
        viewState.showPlayers(Generator.generate())
    }
}
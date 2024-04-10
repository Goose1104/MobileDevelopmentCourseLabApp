package com.example.mobiledevelopmentcourselabapp.Di // Объявление пакета, в котором находится данный файл (Di - Dependency Injection)

import android.content.Context // Импорт класса Context из Android SDK, предоставляющий доступ к информации о приложении
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.CardFragment // Импорт класса CardFragment, представляющего фрагмент с информацией о карте
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.SecondFragment // Импорт класса SecondFragment, представляющего второй фрагмент приложения
import dagger.BindsInstance // Импорт аннотации BindsInstance из Dagger для привязки экземпляра к компоненту
import dagger.Component // Импорт аннотации Component из Dagger для определения компонента внедрения зависимостей
import javax.inject.Singleton // Импорт аннотации Singleton из javax.inject для создания единственного экземпляра компонента

// Аннотация Component из Dagger, указывающая, что данный интерфейс является компонентом внедрения зависимостей
@Component
// Аннотация Singleton, указывающая, что будет создан только один экземпляр этого компонента
@Singleton
interface AppComponent { // Объявление интерфейса AppComponent, представляющего компонент внедрения зависимостей

    // Метод inject для внедрения зависимостей во фрагмент SecondFragment
    fun inject(fragment: SecondFragment)

    // Метод inject для внедрения зависимостей во фрагмент CardFragment
    fun inject(fragment: CardFragment)

    // Вложенный интерфейс Factory для создания экземпляров AppComponent
    @Component.Factory // Аннотация, указывающая, что это фабрика для создания компонентов
    interface Factory {

        // Метод create для создания экземпляра AppComponent с контекстом приложения
        // Аннотация BindsInstance указывает, что контекст будет предоставлен при создании компонента
        fun create(@BindsInstance context: Context): AppComponent // Возвращает созданный экземпляр AppComponent
    }
}
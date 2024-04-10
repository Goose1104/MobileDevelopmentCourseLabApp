package com.example.mobiledevelopmentcourselabapp // Объявление пакета для данного файла

import android.app.Application // Импорт класса Application из Android SDK
import com.example.mobiledevelopmentcourselabapp.Di.AppComponent // Импорт интерфейса AppComponent из пакета Di
import com.example.mobiledevelopmentcourselabapp.Di.DaggerAppComponent // Импорт класса DaggerAppComponent из пакета Di

class App: Application() { // Объявление класса App, наследующего от Application

    override fun onCreate() { // Переопределение метода onCreate, вызываемого при запуске приложения
        super.onCreate() // Вызов метода onCreate родительского класса
        appComponent = DaggerAppComponent.factory().create(applicationContext) // Создание экземпляра AppComponent с помощью Dagger и сохранение его в переменной
    }

    companion object { // Объявление companion object для хранения статического члена
        var appComponent: AppComponent? = null // Статическая переменная для хранения экземпляра AppComponent
    }
}
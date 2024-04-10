package com.example.mobiledevelopmentcourselabapp // Объявление пакета, в котором находится данный файл (MainActivity)

// Импортирование необходимых классов и интерфейсов
import android.os.Bundle // Класс для работы с сохраненным состоянием Activity
import android.view.MenuItem // Класс для работы с элементами меню
import com.google.android.material.bottomnavigation.BottomNavigationView // Класс для работы с нижней панелью навигации
import androidx.appcompat.app.AppCompatActivity // Базовый класс для Activity с поддержкой ActionBar
import androidx.navigation.findNavController // Функция для получения объекта NavController
import androidx.navigation.ui.AppBarConfiguration // Класс для настройки панели приложения с помощью NavController
import androidx.navigation.ui.setupActionBarWithNavController // Функция для настройки ActionBar с помощью NavController
import androidx.navigation.ui.setupWithNavController // Функция для связывания BottomNavigationView с NavController
import com.example.mobiledevelopmentcourselabapp.databinding.ActivityMainBinding // Класс привязки для макета activity_main.xml

// Класс MainActivity, наследующий от AppCompatActivity
class MainActivity : AppCompatActivity() {

    // Переменная для хранения объекта привязки к макету activity_main.xml (nullable)
    private var binding: ActivityMainBinding? = null

    // Метод onCreate, вызываемый при создании Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Вызов метода onCreate родительского класса

        // Инициализация объекта привязки к макету activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Установка контента Activity с помощью корневого элемента макета из объекта привязки
        setContentView(binding?.root)

        // Получение объекта BottomNavigationView из макета
        val navView: BottomNavigationView? = binding?.navView

        // Получение объекта NavController, управляющего навигацией между фрагментами
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        // Создание конфигурации AppBar с указанием id фрагментов, которые будут отображаться в нижней панели навигации
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_article,
                R.id.navigation_second,
                R.id.navigation_third
            )
        )

        // Настройка ActionBar с помощью NavController и конфигурации AppBar
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Связывание BottomNavigationView с NavController для управления навигацией
        navView?.setupWithNavController(navController)
    }

    // Метод onOptionsItemSelected, вызываемый при выборе элемента меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Если выбран элемент "Назад" (стрелка в ActionBar)
        if (item.itemId == android.R.id.home) {
            // Вызов функции onBackPressed для возврата к предыдущему фрагменту
            onBackPressedDispatcher.onBackPressed()
            return true // Возврат true, чтобы указать, что событие обработано
        }
        return false // Возврат false, если событие не обработано
    }
}
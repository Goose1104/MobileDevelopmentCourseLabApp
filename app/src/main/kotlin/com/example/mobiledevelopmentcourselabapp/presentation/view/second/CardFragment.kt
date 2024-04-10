package com.example.mobiledevelopmentcourselabapp.presentation.view.second // Объявление пакета, в котором находится данный фрагмент (CardFragment)

// Импортирование необходимых классов и интерфейсов
import android.content.Intent // Класс для работы с интентами (передача данных между компонентами приложения)
import android.os.Bundle // Класс для работы с сохраненным состоянием фрагмента
import android.view.LayoutInflater // Класс для создания View из XML-макета
import android.view.Menu // Класс для работы с меню
import android.view.MenuInflater // Класс для создания меню из XML-ресурса
import android.view.MenuItem // Класс для работы с элементами меню
import android.view.View // Базовый класс для всех визуальных компонентов
import android.view.ViewGroup // Базовый класс для контейнеров View
import androidx.fragment.app.Fragment // Базовый класс для фрагментов
import com.bumptech.glide.Glide // Библиотека для загрузки и отображения изображений
import com.example.mobiledevelopmentcourselabapp.App // Класс приложения
import com.example.mobiledevelopmentcourselabapp.R // Импорт ресурсов приложения
import com.example.mobiledevelopmentcourselabapp.databinding.CardFragmentBinding // Класс привязки для макета fragment_card.xml
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.Generator.Generator // Объект Generator для генерации данных
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Player // Класс Player, представляющий данные об игроке
import moxy.MvpAppCompatFragment // Базовый класс для фрагментов Moxy (MVP-фреймворк)
import moxy.ktx.moxyPresenter // Функция для создания презентера Moxy
import javax.inject.Inject // Аннотация для внедрения зависимостей
import javax.inject.Provider // Интерфейс для предоставления экземпляров классов

// Класс CardFragment, наследующий от MvpAppCompatFragment и реализующий интерфейс CardMVPView
class CardFragment : MvpAppCompatFragment(), CardMVPView  {

    // Приватная переменная для хранения объекта привязки к макету fragment_card.xml (nullable)
    private var _binding: CardFragmentBinding? = null

    // Геттер для получения объекта привязки, бросающий исключение, если он null
    private val binding: CardFragmentBinding get() = _binding!!

    // Ленивая инициализация переменной player, получающей данные об игроке из аргументов фрагмента
    private val player by lazy { arguments?.getSerializable(CARD_PLAYER_KEY) as? Player}

    // Метод onCreateView, вызываемый для создания View фрагмента
    override fun onCreateView(
        inflater: LayoutInflater, // Объект LayoutInflater для создания View из XML
        container: ViewGroup?, // Родительский контейнер View (может быть null)
        savedInstanceState: Bundle? // Сохраненное состояние фрагмента (может быть null)
    ): View? { // Возвращает созданную View фрагмента
        _binding = CardFragmentBinding.inflate(inflater, container, false) // Инициализация объекта привязки
        return _binding?.root // Возврат корневого элемента View
    }

    // Внедрение зависимости Provider<CardPresentor> для создания презентера
    @Inject
    lateinit var presenterProvider: Provider<CardPresentor>

    // Создание презентера с помощью moxyPresenter и presenterProvider
    private val presentor by moxyPresenter { presenterProvider.get() }

    // Метод onCreate, вызываемый при создании фрагмента
    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent?.inject(this) // Внедрение зависимостей в фрагмент
        super.onCreate(savedInstanceState) // Вызов метода onCreate родительского класса
    }

    // Метод onViewCreated, вызываемый после создания View фрагмента
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) // Вызов метода onViewCreated родительского класса

        // Указание, что фрагмент имеет опции меню
        setHasOptionsMenu(true)

        // Если данные об игроке получены
        player?.let{
            // Установка имени игрока в TextView "name"
            binding.name.text = it.name
            // Установка номера игрока в TextView "number"
            binding.number.text = it.Number.toString()
            // Установка возраста игрока в TextView "age_value"
            binding.ageValue.text = it.Age.toString()
            // Установка команды игрока в TextView "team_value"
            binding.teamValue.text = it.Team
            // Установка позиции игрока в TextView "position_value"
            binding.positionValue.text = it.position.rusName
            // Загрузка и отображение фотографии игрока в ImageView "icon" с помощью Glide
            Glide.with(view)
                .load(it.PhotoURL)
                .into(binding.icon)
        }
    }

    // Метод onCreateOptionsMenu, вызываемый для создания меню фрагмента
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Заполнение меню из XML-ресурса card_menu
        inflater.inflate(R.menu.card_menu, menu)
    }

    // Метод onOptionsItemSelected, вызываемый при выборе элемента меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Если выбран элемент "Поделиться" (R.id.action_share)
        if (item.itemId == R.id.action_share){
            // Вызов метода sharePlayerData презентера для обработки действия "Поделиться"
            presentor.sharePlayerData(player!!)
            return true // Возврат true, чтобы указать, что событие обработано
        }
        return true // Возврат true, чтобы указать, что событие обработано
    }

    // Companion object для хранения константы CARD_PLAYER_KEY
    companion object{
        // Константа, используемая для передачи данных об игроке в аргументах фрагмента
        const val CARD_PLAYER_KEY = "PLAYER_DATA"
    }

    // Метод share, вызываемый презентером для запуска интента с данными об игроке
    override fun share(intent: Intent) {
        // Запуск интента
        startActivity(intent)
    }
}
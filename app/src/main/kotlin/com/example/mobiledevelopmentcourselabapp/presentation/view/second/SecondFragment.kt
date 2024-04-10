package com.example.mobiledevelopmentcourselabapp.presentation.view.second // Объявление пакета, в котором находится данный фрагмент (SecondFragment)

// Импортирование необходимых классов и интерфейсов
import android.os.Bundle // Класс для работы с сохраненным состоянием фрагмента
import android.view.LayoutInflater // Класс для создания View из XML-макета
import android.view.View // Базовый класс для всех визуальных компонентов
import android.view.ViewGroup // Базовый класс для контейнеров View
import androidx.core.os.bundleOf // Функция для создания Bundle из пар "ключ-значение"
import androidx.fragment.app.Fragment // Базовый класс для фрагментов
import androidx.navigation.findNavController // Функция для получения объекта NavController
import com.example.mobiledevelopmentcourselabapp.App // Класс приложения
import com.example.mobiledevelopmentcourselabapp.R // Импорт ресурсов приложения
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentSecondBinding // Класс привязки для макета fragment_second.xml
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.Generator.Generator // Объект Generator для генерации данных
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.adapter.PlayerAdapter // Класс адаптера для RecyclerView
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Player // Класс Player, представляющий данные об игроке
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.iUModal // Интерфейс iUModal, общий для всех элементов списка
import moxy.MvpAppCompatFragment // Базовый класс для фрагментов Moxy (MVP-фреймворк)
import moxy.ktx.moxyPresenter // Функция для создания презентера Moxy
import javax.inject.Inject // Аннотация для внедрения зависимостей
import javax.inject.Provider // Интерфейс для предоставления экземпляров классов

// Класс SecondFragment, наследующий от MvpAppCompatFragment и реализующий интерфейс SecondMVPView
class SecondFragment : MvpAppCompatFragment(), SecondMVPView {

    // Приватная переменная для хранения объекта привязки к макету fragment_second.xml (nullable)
    private var _binding: FragmentSecondBinding? = null

    // Ленивая инициализация адаптера для RecyclerView с передачей функции onPlayerClicked из презентера
    private val adapter by lazy {PlayerAdapter(presentor::onPlayerClicked)}

    // Геттер для получения объекта привязки, бросающий исключение, если он null
    private val binding get() = _binding!!

    // Внедрение зависимости Provider<SecondPresentor> для создания презентера
    @Inject
    lateinit var presenterProvider: Provider<SecondPresentor>

    // Создание презентера с помощью moxyPresenter и Provider
    private val presentor by moxyPresenter { presenterProvider.get() }

    // Метод onCreate, вызываемый при создании фрагмента
    override fun onCreate(savedInstanceState: Bundle?){
        App.appComponent?.inject(this) // Внедрение зависимостей во фрагмент с помощью AppComponent
        super.onCreate(savedInstanceState) // Вызов метода onCreate родительского класса
    }

    // Метод onCreateView, вызываемый для создания View фрагмента
    override fun onCreateView(
        inflater: LayoutInflater, // Объект LayoutInflater для создания View из XML
        container: ViewGroup?, // Родительский контейнер View (может быть null)
        savedInstanceState: Bundle? // Сохраненное состояние фрагмента (может быть null)
    ): View { // Возвращает созданную View фрагмента

        // Инициализация объекта привязки к макету fragment_second.xml
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        // Получение корневого элемента View из объекта привязки
        val root: View = binding.root

        // Установка адаптера для RecyclerView
        binding.playerList.adapter = adapter

        // Возврат корневого элемента View фрагмента
        return root
    }

    // Метод onDestroyView, вызываемый при уничтожении View фрагмента
    override fun onDestroyView() {
        super.onDestroyView() // Вызов метода onDestroyView родительского класса
        _binding = null // Освобождение объекта привязки для предотвращения утечек памяти
    }

    // Метод navigateToPlayer для перехода к экрану с деталями игрока
    override fun navigateToPlayer(iUModal: iUModal) {
        // Создание Bundle с данными об игроке
        val bundle = bundleOf(CardFragment.CARD_PLAYER_KEY to iUModal)

        // Поиск NavController и навигация к фрагменту CardFragment с передачей данных
        view?.findNavController()?.navigate(R.id.action_to_navigation_card, bundle)
    }

    // Метод showPlayers для отображения списка игроков в RecyclerView
    override fun showPlayers(player: List<iUModal>) {
        // Обновление элементов адаптера с новым списком игроков
        adapter.updateItems(player)
    }
}
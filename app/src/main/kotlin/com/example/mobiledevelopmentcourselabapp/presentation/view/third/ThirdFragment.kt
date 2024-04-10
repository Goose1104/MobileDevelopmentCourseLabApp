package com.example.mobiledevelopmentcourselabapp.presentation.view.third // Объявление пакета, в котором находится данный фрагмент (ThirdFragment)

// Импортирование необходимых классов и интерфейсов
import android.os.Bundle // Класс для работы с сохраненным состоянием фрагмента
import android.view.LayoutInflater // Класс для создания View из XML-макета
import android.view.View // Базовый класс для всех визуальных компонентов
import android.view.ViewGroup // Базовый класс для контейнеров View
import androidx.fragment.app.Fragment // Базовый класс для фрагментов
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentThirdBinding // Класс привязки для макета fragment_third.xml

// Класс ThirdFragment, наследующий от Fragment
class ThirdFragment : Fragment() {

    // Приватная переменная для хранения объекта привязки к макету fragment_third.xml (nullable)
    private var _binding: FragmentThirdBinding? = null

    // Геттер для получения объекта привязки, бросающий исключение, если он null
    private val binding get() = _binding!!

    // Метод onCreateView, вызываемый для создания View фрагмента
    override fun onCreateView(
        inflater: LayoutInflater, // Объект LayoutInflater для создания View из XML
        container: ViewGroup?, // Родительский контейнер View (может быть null)
        savedInstanceState: Bundle? // Сохраненное состояние фрагмента (может быть null)
    ): View { // Возвращает созданную View фрагмента

        // Инициализация объекта привязки к макету fragment_third.xml
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        // Получение корневого элемента View из объекта привязки
        val root: View = binding.root

        // Комментарий, указывающий место для обращения к элементам View

        // Возврат корневого элемента View фрагмента
        return root
    }

    // Метод onDestroyView, вызываемый при уничтожении View фрагмента
    override fun onDestroyView() {
        super.onDestroyView() // Вызов метода onDestroyView родительского класса
        _binding = null // Освобождение объекта привязки для предотвращения утечек памяти
    }
}
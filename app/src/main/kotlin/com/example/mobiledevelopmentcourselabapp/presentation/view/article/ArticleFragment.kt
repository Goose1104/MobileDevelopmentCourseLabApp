package com.example.mobiledevelopmentcourselabapp.presentation.view.article // Объявление пакета, в котором находится данный файл (ArticleFragment)

// Импорт необходимых классов и интерфейсов
import android.os.Bundle // Класс для работы с сохраненным состоянием фрагмента
import android.view.LayoutInflater // Класс для создания View из XML-макета
import android.view.View // Базовый класс для всех визуальных компонентов
import android.view.ViewGroup // Базовый класс для контейнеров View
import androidx.fragment.app.Fragment // Базовый класс для фрагментов
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentArticleBinding // Класс привязки для макета fragment_article.xml

// Класс ArticleFragment, наследующий от Fragment
class ArticleFragment : Fragment() {

    // Приватная переменная для хранения объекта привязки к макету fragment_article.xml (nullable)
    private var _binding: FragmentArticleBinding? = null

    // Геттер для получения объекта привязки, бросающий исключение, если он null
    private val binding get() = _binding!!

    // Метод onCreateView, вызываемый для создания View фрагмента
    override fun onCreateView(
        inflater: LayoutInflater, // Объект LayoutInflater для создания View из XML
        container: ViewGroup?, // Родительский контейнер View (может быть null)
        savedInstanceState: Bundle? // Сохраненное состояние фрагмента (может быть null)
    ): View { // Возвращает созданную View фрагмента

        // Инициализация объекта привязки к макету fragment_article.xml
        _binding = FragmentArticleBinding.inflate(inflater, container, false)

        // Получение корневого элемента View из объекта привязки
        val root: View = binding.root

        // Инициализация переменной для хранения результата лайков/дизлайков
        var likeResult1 = 0

        // Установка обработчика клика на кнопку "thumb_up" (лайк)
        binding.thumbUp.setOnClickListener {
            // Увеличение значения likeResult1 на 1
            likeResult1 += 1
            // Обновление текста TextView "like_result" с новым значением likeResult1
            binding.likeResult.text = likeResult1.toString()
        }

        // Установка обработчика клика на кнопку "thumb_down" (дизлайк)
        binding.thumbDown.setOnClickListener {
            // Уменьшение значения likeResult1 на 1, если оно больше 0
            if (likeResult1 > 0) {
                likeResult1 -= 1
                // Обновление текста TextView "like_result" с новым значением likeResult1
                binding.likeResult.text = likeResult1.toString()
            }
        }

        // Возврат корневого элемента View фрагмента
        return root
    }

    // Метод onDestroyView, вызываемый при уничтожении View фрагмента
    override fun onDestroyView() {
        super.onDestroyView() // Вызов метода onDestroyView родительского класса
        _binding = null // Освобождение объекта привязки для предотвращения утечек памяти
    }
}
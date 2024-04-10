package com.example.mobiledevelopmentcourselabapp.presentation.view.second.adapter // Объявление пакета, в котором находится данный файл (адаптер для второго экрана)

import android.view.LayoutInflater // Импорт класса LayoutInflater для создания View из XML-макетов
import android.view.ViewGroup // Импорт класса ViewGroup, представляющего контейнер для View
import androidx.core.view.isVisible // Импорт функции isVisible из androidx.core.view для управления видимостью View
import androidx.navigation.findNavController // Импорт функции findNavController из androidx.navigation для получения объекта NavController
import androidx.recyclerview.widget.RecyclerView // Импорт класса RecyclerView для отображения списка элементов
import com.bumptech.glide.Glide // Импорт библиотеки Glide для загрузки и отображения изображений
import com.example.mobiledevelopmentcourselabapp.R // Импорт ресурсов приложения
import com.example.mobiledevelopmentcourselabapp.databinding.ItemAddBinding // Импорт класса привязки для макета элемента "Добавить"
import com.example.mobiledevelopmentcourselabapp.databinding.ItemObjectBinding // Импорт класса привязки для макета элемента "Объект"
import com.example.mobiledevelopmentcourselabapp.databinding.ItemPlayerBinding // Импорт класса привязки для макета элемента "Игрок"
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Add // Импорт класса Add, представляющего элемент "Добавить"
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Pic // Импорт класса Pic, представляющего элемент "Объект"
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.Player // Импорт класса Player, представляющего элемент "Игрок"
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.player.iUModal // Импорт интерфейса iUModal, общего для всех элементов списка
import java.util.Objects // Импорт класса Objects для сравнения объектов

// Класс адаптера для RecyclerView, наследующий от RecyclerView.Adapter
class PlayerAdapter(private val onPlayerClicked:(Player)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Companion object для хранения констант типов элементов списка
    companion object {
        const val Player_Card: Int = 0 // Константа для типа элемента "Игрок"
        const val Ad_Card: Int = 1 // Константа для типа элемента "Добавить"
        const val Pic_Card: Int = 2 // Константа для типа элемента "Объект"
    }

    // Приватная переменная для хранения списка элементов, реализующих интерфейс iUModal
    private var items: MutableList<iUModal> = arrayListOf()

    // Метод getItemViewType, возвращающий тип элемента по его позиции в списке
    override fun getItemViewType(position: Int): Int {
        // Возвращение типа элемента в зависимости от его класса
        return when (items[position]) {
            is Player -> Player_Card
            is Add -> Ad_Card
            else -> Pic_Card
        }
    }

    // Метод onCreateViewHolder, создающий ViewHolder для элемента списка в зависимости от его типа
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // Если тип элемента - "Игрок"
        if (viewType == Player_Card) {
            // Создание объекта привязки для макета элемента "Игрок"
            val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            // Возвращение объекта PlayerHolder, хранящего привязку к макету
            return PlayerHolder(binding)
        }
        // Если тип элемента - "Объект"
        if (viewType == Pic_Card) {
            // Создание объекта привязки для макета элемента "Объект"
            val binding = ItemObjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            // Возвращение объекта PicHolder, хранящего привязку к макету
            return PicHolder(binding)
        }
        // Если тип элемента - "Добавить"
        val binding = ItemAddBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Возвращение объекта addHolder, хранящего привязку к макету
        return addHolder(binding)
    }

    // Метод updateItems, обновляющий список элементов адаптера
    fun updateItems(newItems: List<iUModal>){
        // Преобразование списка newItems в MutableList и сохранение его в переменной items
        items = newItems.toMutableList()
    }

    // Метод getItemCount, возвращающий количество элементов в списке
    override fun getItemCount(): Int {
        return items.size // Возврат размера списка items
    }

    // Метод onBindViewHolder, связывающий данные элемента с ViewHolder
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Получение элемента по позиции из списка items
        val item = items[position]

        // Если ViewHolder - PlayerHolder и элемент - Player
        if (holder is PlayerHolder && item is Player){
            // Вызов метода bind для связывания данных игрока с ViewHolder
            holder.bind(item)
            // Установка обработчика клика на элемент списка
            holder.setOnClickListener {
                // Вызов функции onPlayerClicked с переданным объектом Player
                onPlayerClicked.invoke(item)
                // Изменение состояния isExpended элемента Player
                item.isExpended = !item.isExpended
                // Уведомление адаптера об изменении элемента по позиции
                notifyItemChanged(position)
            }
        }
        // Если ViewHolder - addHolder и элемент - Add
        if (holder is addHolder && item is Add){
            // Вызов метода bind для связывания данных элемента "Добавить" с ViewHolder
            holder.bind(item)
        }
        // Если ViewHolder - PicHolder и элемент - Pic
        if (holder is PicHolder && item is Pic) {
            // Вызов метода bind для связывания данных элемента "Объект" с ViewHolder
            holder.bind(item)
        }
    }
}

// Класс PlayerHolder, наследующий от RecyclerView.ViewHolder, для хранения привязки к макету элемента "Игрок"
class PlayerHolder(private val binding: ItemPlayerBinding) :RecyclerView.ViewHolder(binding.root){

    // Метод bind для связывания данных игрока с элементами макета
    fun bind(plaet: Player){
        binding.name.text = plaet.name // Установка имени игрока в TextView "name"
        binding.number.text = plaet.Number.toString() // Установка номера игрока в TextView "number"
        // Форматирование строки с возрастом игрока и установка ее в TextView "age"
        binding.age.text = itemView.context.resources.getString(R.string.age_pattern, plaet.Age, itemView.context.resources.getQuantityString(R.plurals.age, plaet.Age))
        binding.position.text = plaet.position.rusName // Установка позиции игрока в TextView "position"
        binding.team.text = plaet.Team // Установка команды игрока в TextView "team"
        // Управление видимостью дополнительных полей в зависимости от состояния isExpended
        binding.additionFields.isVisible = plaet.isExpended
        // Загрузка и отображение фотографии игрока с помощью Glide
        Glide.with(itemView)
            .load(plaet.PhotoURL)
            .into(binding.icon)
    }

    // Метод setOnClickListener для установки обработчика клика на элемент списка
    fun setOnClickListener(action: () -> Unit){
        binding.root.setOnClickListener{
            action.invoke() // Вызов переданной функции action при клике
        }
    }
}

// Класс addHolder, наследующий от RecyclerView.ViewHolder, для хранения привязки к макету элемента "Добавить"
class addHolder(private val binding: ItemAddBinding) :RecyclerView.ViewHolder(binding.root) {

    // Метод bind для связывания данных элемента "Добавить" с TextView "add"
    fun bind(add: Add) {
        binding.add.text = add.text // Установка текста элемента "Добавить" в TextView "add"
    }
}

// Класс PicHolder, наследующий от RecyclerView.ViewHolder, для хранения привязки к макету элемента "Объект"
class PicHolder(private  val binding: ItemObjectBinding) :RecyclerView.ViewHolder(binding.root){

    // Метод bind для связывания данных элемента "Объект" с элементами макета
    fun bind(pic: Pic){
        binding.Nameobject.text = pic.name // Установка имени объекта в TextView "Nameobject"
        // Форматирование строки с возрастом объекта и установка ее в TextView "Ageobject"
        binding.Ageobject.text = itemView.context.resources.getString(R.string.age_pattern, pic.Age, itemView.context.resources.getQuantityString(R.plurals.age, pic.Age))
        // Загрузка и отображение фотографии объекта с помощью Glide
        Glide.with(itemView)
            .load(pic.PhotoURL)
            .into(binding.Photoobject)
    }
}
package weapon

class Stack<T>() {
    /*
    Коллекция на основе last in first out — последний вошёл, первый вышел.
    Цель: магазин патронов
    */

    private val elements = mutableListOf<T>() // элементы

    fun push(element: T) {  // положить элемент в конец
        elements.add(element)
    }

    fun pop(): T? { // извлечь и удаление последнего элемента при не пустом или null
        if (!isEmpty()) {
            val element = elements.last() // последний
            if (element != null) {
                elements.remove(element)
                return element // возвращаем удалив и проверив на пустоту
            }
        }
        return null // при пусто null
    }

    fun isEmpty(): Boolean = elements.isEmpty() // проверка на пустоту
}
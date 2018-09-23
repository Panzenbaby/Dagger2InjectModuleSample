package de.panzenbaby.data

class Incrementally(initValue: Int) {

    var currentValue: Int = 0
        private set

    init {
        currentValue = initValue
    }

    fun increment() {
        currentValue++
    }
}
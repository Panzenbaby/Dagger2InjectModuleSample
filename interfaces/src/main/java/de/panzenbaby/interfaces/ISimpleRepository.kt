package de.panzenbaby.interfaces

import io.reactivex.Flowable

interface ISimpleRepository {

    abstract fun increment()

    abstract fun getValue(): Flowable<Int>
}
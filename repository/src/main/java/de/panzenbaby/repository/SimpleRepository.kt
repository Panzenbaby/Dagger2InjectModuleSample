package de.panzenbaby.repository

import de.panzenbaby.data.Incrementally
import de.panzenbaby.interfaces.ISimpleRepository
import io.reactivex.Flowable
import io.reactivex.processors.PublishProcessor

class SimpleRepository(private var value : Incrementally) : ISimpleRepository {

    private val processor by lazy { PublishProcessor.create<Int>() }

    override fun increment() {
        value.increment()
        processor.onNext(value.currentValue)
    }

    override fun getValue(): Flowable<Int> {
        return processor
    }
}
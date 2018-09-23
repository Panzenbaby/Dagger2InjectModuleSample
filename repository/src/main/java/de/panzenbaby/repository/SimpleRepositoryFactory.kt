package de.panzenbaby.repository

import de.panzenbaby.data.Incrementally

object SimpleRepositoryFactory {

    val repository: SimpleRepository = SimpleRepository(Incrementally(0))
}
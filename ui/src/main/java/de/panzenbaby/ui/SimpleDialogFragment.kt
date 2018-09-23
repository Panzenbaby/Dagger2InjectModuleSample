package de.panzenbaby.ui

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import de.panzenbaby.interfaces.ISimpleRepository

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SimpleDialogFragment : DialogFragment() {

    @Inject
    lateinit var repository: ISimpleRepository

    private var compositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        val view = inflater.inflate(R.layout.fragment_simple_dialog, container, false)

        view.findViewById<View>(R.id.button).setOnClickListener { _ -> incrementRepositoryCounter() }

        return view
    }

    override fun onResume() {
        super.onResume()
        val disposables = repository.getValue()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { value -> Log.i("Foo", "new value: $value") }

        compositeDisposable.add(disposables)
    }

    override fun onPause() {
        compositeDisposable.dispose()
        super.onPause()
    }

    private fun incrementRepositoryCounter() {
        repository.increment()
    }
}

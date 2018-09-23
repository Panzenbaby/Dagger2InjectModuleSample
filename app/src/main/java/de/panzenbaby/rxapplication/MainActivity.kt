package de.panzenbaby.rxapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import dagger.android.AndroidInjection
import de.panzenbaby.repository.SimpleRepository
import de.panzenbaby.ui.SimpleDialogFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: SimpleRepository

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.main_button)
        compositeDisposable.add(repository.getValue()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { button.text = it.toString() })
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    fun showDialog(view: View) {
        SimpleDialogFragment().show(supportFragmentManager, null)
    }
}
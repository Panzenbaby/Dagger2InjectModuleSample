//package de.panzenbaby.rxapplication;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//
//import javax.inject.Inject;
//
//import dagger.android.AndroidInjection;
//import de.panzenbaby.repository.SimpleRepository;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.CompositeDisposable;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Inject
//    SimpleRepository repository;
//
//    CompositeDisposable compositeDisposable = new CompositeDisposable();
//
//    public void onCreate(Bundle savedInstanceState) {
//        AndroidInjection.inject(this);
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        compositeDisposable.add(repository.getValue().observeOn(AndroidSchedulers.mainThread()).subscribe(it -> {
//            ((Button) findViewById(R.id.main_button)).setText(it.toString());
//        }));
//    }
//
//    public void onDestroy() {
//        compositeDisposable.clear();
//        super.onDestroy();
//    }
//
//    public void showDialog(View view) {
//        new SimpleDialogFragment().show(getFragmentManager(), null);
//    }
//}
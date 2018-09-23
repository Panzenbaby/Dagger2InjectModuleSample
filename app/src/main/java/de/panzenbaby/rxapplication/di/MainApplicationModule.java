package de.panzenbaby.rxapplication.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import de.panzenbaby.data.Incrementally;
import de.panzenbaby.interfaces.ISimpleRepository;
import de.panzenbaby.repository.SimpleRepository;
import de.panzenbaby.rxapplication.MainActivity;
import de.panzenbaby.ui.SimpleDialogFragment;

@Module
public abstract class MainApplicationModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInjector();

    @ContributesAndroidInjector
    abstract SimpleDialogFragment contributeSimpleDialogFragment();

    @Singleton
    @Provides
    public static Incrementally provideIncrementally() {
        return new Incrementally(0);
    }

    @Singleton
    @Provides
    public static SimpleRepository provideSimpleRepository(Incrementally incrementally) {
        return new SimpleRepository(incrementally);
    }

    @Singleton
    @Provides
    public static ISimpleRepository provideISimpleRepository(SimpleRepository repository) {
        return repository;
    }
}
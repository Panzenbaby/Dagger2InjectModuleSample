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
public abstract class UiModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInjector();

    @ContributesAndroidInjector
    abstract SimpleDialogFragment contributeSimpleDialogFragment();
}
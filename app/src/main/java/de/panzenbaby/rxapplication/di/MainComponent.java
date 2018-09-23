package de.panzenbaby.rxapplication.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import de.panzenbaby.rxapplication.BaseApplication;

@Singleton
@Component(modules = { AndroidInjectionModule.class, MainApplicationModule.class})
public interface MainComponent extends AndroidInjector<BaseApplication> {
}

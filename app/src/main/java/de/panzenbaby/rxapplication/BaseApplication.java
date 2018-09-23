package de.panzenbaby.rxapplication;


import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;
import de.panzenbaby.rxapplication.di.DaggerMainComponent;

public class BaseApplication extends Application implements HasActivityInjector, HasSupportFragmentInjector {
    @Inject
    public DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    public DispatchingAndroidInjector<Fragment> dispatchingAndroid;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerMainComponent.create().inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<android.support.v4.app.Fragment> supportFragmentInjector() {
        return dispatchingAndroid;
    }
}
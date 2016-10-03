package pl.krystiankaniowski.mvp_test;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Created by kryst on 03.10.2016.
 */

@dagger.Module
public class Module {

    @Provides
    @Singleton
    static TaskManager provideTaskManager() {
        return new TaskManager();
    }

}

package pl.krystiankaniowski.mvp_test;

import javax.inject.Singleton;

import dagger.Component;
import pl.krystiankaniowski.mvp_test.task.TaskPresenter;

@Singleton
@Component(modules = {Module.class})
public interface MyComponent {

    void inject(TaskPresenter taskPresenter);

}
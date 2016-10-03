package pl.krystiankaniowski.mvp_test.task;

import pl.krystiankaniowski.mvp_test.BasePresenter;
import pl.krystiankaniowski.mvp_test.BaseView;

public interface TaskContract {

    interface View extends BaseView<Presenter> {

        void showMessage(String message);

    }

    interface Presenter extends BasePresenter {

        void requestProcess();

    }

}

package pl.krystiankaniowski.mvp_test.task;

import javax.inject.Inject;

import pl.krystiankaniowski.mvp_test.DaggerMyComponent;
import pl.krystiankaniowski.mvp_test.TaskManager;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class TaskPresenter implements TaskContract.Presenter {

    @Inject
    TaskManager manager;

    private TaskContract.View view;

    private CompositeSubscription subscriptions;

    public TaskPresenter(TaskContract.View view) {

        DaggerMyComponent.builder().build().inject(this);

        this.view = view;
        view.setPresenter(this);

        subscriptions = new CompositeSubscription();

    }

    @Override
    public void subscribe() {

        view.showMessage("List: " + manager.getTask());

    }

    @Override
    public void unsubscribe() {
        subscriptions.clear();
    }

    @Override
    public void requestProcess() {
        subscriptions.add(
                Observable
                        .from(new String[]{"1", "2", "3"})
                        .observeOn(Schedulers.computation())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<String>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(String string) {
                                view.showMessage("Process " + string + " requested");
                            }
                        }));
    }

}

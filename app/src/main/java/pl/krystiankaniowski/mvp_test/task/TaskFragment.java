package pl.krystiankaniowski.mvp_test.task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.krystiankaniowski.mvp_test.R;

public class TaskFragment extends Fragment implements TaskContract.View {

    private TextView textView;
    private TaskContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        return view;
    }

    @Override
    public void showMessage(String message) {
        textView.setText(textView.getText() + "\n" + message);
    }

    @Override
    public void setPresenter(TaskContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public static TaskFragment newInstance() {
        return new TaskFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
        presenter.requestProcess();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

}

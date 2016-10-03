package pl.krystiankaniowski.mvp_test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pl.krystiankaniowski.mvp_test.task.TaskFragment;
import pl.krystiankaniowski.mvp_test.task.TaskPresenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaskFragment fragment = (TaskFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (fragment == null) {
            fragment = TaskFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.contentFrame);
        }

        new TaskPresenter(fragment);

    }

}

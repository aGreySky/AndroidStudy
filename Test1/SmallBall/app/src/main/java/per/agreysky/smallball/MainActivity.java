package per.agreysky.smallball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_linear)
    LinearLayout main_linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DrawView view = new DrawView(this);
        view.setMinimumHeight(300);
        view.setMinimumWidth(300);
        main_linear.addView(view);
    }
}


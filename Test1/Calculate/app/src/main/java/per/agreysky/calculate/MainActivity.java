package per.agreysky.calculate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_grid)
    GridLayout main_grid;

    String[] strs = new String[] {
            "7", "8", "9", "÷",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            ".", "0", "=", "+"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        for (int i = 0; i < strs.length; i++) {
            Button btn = new Button(this);
            btn.setText(strs[i]);
            btn.setTextSize(40);
            btn.setPadding(5, 35, 5, 35);
            GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
            GridLayout.Spec colSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, colSpec);
            params.setGravity(Gravity.FILL);
            main_grid.addView(btn, params);
        }
    }
}

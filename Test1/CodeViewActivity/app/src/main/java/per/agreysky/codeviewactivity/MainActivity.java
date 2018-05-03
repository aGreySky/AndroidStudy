package per.agreysky.codeviewactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LinearLayout linear = new LinearLayout(this);
        super.onCreate(savedInstanceState);
        setContentView(linear);
        linear.setOrientation(LinearLayout.VERTICAL);
        final TextView show = new TextView(this);
        Button btn = new Button(this);
        btn.setText("单击我");
        btn.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linear.addView(show);
        linear.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText("Hello, Android, "+ new Date());
            }
        });
    }
}
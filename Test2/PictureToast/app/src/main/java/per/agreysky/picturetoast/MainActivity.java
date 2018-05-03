package per.agreysky.picturetoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toast(View view) {
        Toast toast = new Toast(this);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.mouse3);
        LinearLayout ll = new LinearLayout(this);
        TextView text = new TextView(this);
        text.setText("mouse");
        text.setTextSize(40);
        ll.addView(text);
        ll.addView(imageView);
        toast.setView(ll);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

}

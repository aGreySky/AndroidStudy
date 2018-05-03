package per.agreysky.autoplaypicture2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private ViewSwitcher main_vs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_vs = (ViewSwitcher) findViewById(R.id.main_vs);
    }

    public void prev(View v) {
        main_vs.showPrevious();
    }

    public void next(View v) {
        main_vs.showNext();
    }

}

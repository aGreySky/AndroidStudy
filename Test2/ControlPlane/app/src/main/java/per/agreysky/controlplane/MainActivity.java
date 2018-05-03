package per.agreysky.controlplane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    private int speed = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final PlaneView planeView = new PlaneView(this);
        setContentView(planeView);
        WindowManager manager = getWindowManager();
        Display display = manager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        planeView.currentX = metrics.widthPixels / 2;
        planeView.currentY = metrics.heightPixels / 2;
        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getKeyCode()) {
                    case KeyEvent.KEYCODE_S:
                        planeView.currentY += speed;
                        break;
                    case KeyEvent.KEYCODE_W:
                        planeView.currentY -= speed;
                        break;
                    case KeyEvent.KEYCODE_A:
                        planeView.currentX -= speed;
                        break;
                    case KeyEvent.KEYCODE_D:
                        planeView.currentX += speed;
                        break;
                    default:
                        break;
                }
                planeView.invalidate();
                return true;
            }
        });
    }
}

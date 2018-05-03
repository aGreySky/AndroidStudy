package per.agreysky.autoplaypicture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper main_vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_vf = (ViewFlipper) findViewById(R.id.main_vf);
    }

    public void prev(View v) {
    //显示上一个组件
    main_vf.showPrevious();
    //停止自动播放
    main_vf.stopFlipping();
}

    public void next(View v) {
        //显示下一个组件
        main_vf.showNext();
        //停止自动播放
        main_vf.stopFlipping();
    }

    public void auto(View v) {
        main_vf.startFlipping();
    }

}

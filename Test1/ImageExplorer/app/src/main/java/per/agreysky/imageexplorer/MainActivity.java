package per.agreysky.imageexplorer;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    private LinearLayout main_linear;

    int currentImg = 0;
    private int alpha =255;
    int[] images = new int[] {R.drawable.mouse1, R.drawable.mouse2,
            R.drawable.mouse3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button plus = (Button) findViewById(R.id.plus);
        final Button minus = (Button) findViewById(R.id.minus);
        Button next = (Button) findViewById(R.id.next);
        final ImageView image1 = (ImageView) findViewById(R.id.iamge1);
        final ImageView image2 = (ImageView) findViewById(R.id.iamge2);

        //定义下一张图片的监听器
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //控制ImageView显示下一张图片
                image1.setImageResource(images[++currentImg % images.length]);
            }
        });
        //定义改变图片透明度的方法
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == plus){
                    alpha += 20;
                }
                if (v == minus){
                    alpha -= 20;
                }
                if (alpha >= 255){
                    alpha = 255;
                }
                if (alpha <= 0){
                    alpha = 0;
                }
                //改变图片的1透明度
                image1.setImageAlpha(alpha);
            }
        };
        //为两个按钮设置监听器
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
                //获取第一个图片显示框中的位图
                Bitmap bitmap = bitmapDrawable.getBitmap();
                //bitMap图片实际大小与第一个ImageView的缩放比例
                double scale = 1.0 * bitmap.getHeight() / image1.getHeight();
                //获取需要显示的图片的开始点
                int x = (int)(motionEvent.getX() * scale);
                int y = (int)(motionEvent.getY() * scale);
                if (x + 120 > bitmap.getWidth()){
                    x = bitmap.getWidth() - 120;
                }
                if ( y + 120 >bitmap.getHeight()){
                    y = bitmap.getHeight() - 120;
                }
                //显示图片的指定区域
                image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                image2.setImageAlpha(alpha);
                return false;
                }
        });


        /*main_linear = (LinearLayout) findViewById(R.id.main_linear);
        final ImageView image = new ImageView(this);
        image.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        main_linear.addView(image);
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageResource(images[++current % images.length]);
            }
        });*/
    }
}


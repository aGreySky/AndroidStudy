package per.agreysky.smallball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2018/3/29 0029.
 */

public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    private float currentX = 40;
    private float currentY = 50;

    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔颜色
        paint.setColor(Color.RED);
        //绘制小球
        canvas.drawCircle(currentX, currentY, 15, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();
        currentY = event.getY();
        //通知重绘
        invalidate();
        return true;
    }
}

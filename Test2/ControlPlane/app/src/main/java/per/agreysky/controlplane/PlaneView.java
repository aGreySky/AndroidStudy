package per.agreysky.controlplane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;



public class PlaneView extends View {

    public float currentX;
    public float currentY;

    private Bitmap plane;

    public PlaneView(Context context) {
        super(context);
        plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawBitmap(plane, currentX, currentY, paint);
    }
}

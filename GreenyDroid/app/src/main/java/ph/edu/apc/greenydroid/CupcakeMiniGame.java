package ph.edu.apc.greenydroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Renzo on 13/08/2016.
 */
public class CupcakeMiniGame extends AppCompatActivity {
    GreenyCanvas cv;

    class GreenyCanvas extends View {

        Bitmap greeny, cupcake;
        Rect greenySrc, greenyDst;
        int greenyLeft = 0, greenyTop = 0, greenyRight = 325, greenyBottom = 245;
        
        GreenyCanvas(Context c){
            super(c);
            greeny = BitmapFactory.decodeResource(getResources(),R.mipmap.android);
            greenySrc = new Rect(greenyLeft, greenyTop, greenyRight, greenyBottom);
            greenyDst = new Rect(360, 500, 480, 630);

            cupcake = BitmapFactory.decodeResource(getResources(),R.mipmap.cupcake);
        }
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            canvas.drawBitmap(greeny, greenySrc, greenyDst, null);
            invalidate();
        }
    }


    protected void onCreate(Bundle savedInstanceCreate){
        super.onCreate(savedInstanceCreate);
        cv = new GreenyCanvas(this);
        setContentView(cv);
    }
}

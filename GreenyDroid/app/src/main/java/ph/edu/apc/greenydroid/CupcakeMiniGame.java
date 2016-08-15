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
    Rect greenySrc, greenyDst;
    int greenyLeft = 2030, greenyTop = 490, greenyRight = 2245, greenyBottom = 720;
    Rect cupcakeSrc, cupcakeDst;


    class GreenyCanvas extends View {
        Bitmap greeny, cupcake;

        GreenyCanvas(Context c){
            super(c);
            greeny = BitmapFactory.decodeResource(getResources(),R.mipmap.android);
            greenySrc = new Rect(greenyLeft, greenyTop, greenyRight, greenyBottom);
            greenyDst = new Rect(20, 500, 140, 630);
            cupcake = BitmapFactory.decodeResource(getResources(),R.mipmap.cupcake);
            cupcakeSrc = new Rect(130, 140, 465, 555);
            cupcakeDst = new Rect(190, 250, 300, 450);

        }
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            canvas.drawBitmap(greeny, greenySrc, greenyDst, null);
            canvas.drawBitmap(cupcake, cupcakeSrc, cupcakeDst, null);
            invalidate();
        }
    }

    Thread wave;

    class waving implements Runnable{
        public void run(){
                while(true){
                    greenyLeft+=329;
                    greenyRight+=329;
                    if(greenyLeft > 329 * 3){
                        greenyLeft=60;
                        greenyRight=330;
                    }
                    greenySrc.left = greenyLeft;
                    greenySrc.right = greenyRight;
                SystemClock.sleep(100);
            }
        }
    }


    protected void onCreate(Bundle savedInstanceCreate){
        super.onCreate(savedInstanceCreate);
        cv = new GreenyCanvas(this);
        setContentView(cv);

        Runnable hand = new waving();
        wave = new Thread(hand);
        wave.start();
    }
}

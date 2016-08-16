package ph.edu.apc.greenydroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Renzo on 13/08/2016.
 */
public class CupcakeMiniGame extends AppCompatActivity {
    GreenyCanvas cv;
    Rect greenySrc, greenyDst;
    int greenyML = 175, greenyMR = 305;
    Rect cupcakeSrc, cupcakeDst;
    int cupcakeLeft = 190, cupcakeTop = 250, cupcakeRight = 300, cupcakeBottom = 450;
    Rect bananaSrc, bananaDst;
    Rect pearsSrc, pearsDst;
    Rect watermelonSrc, watermelonDst;

    class GreenyCanvas extends View {
        Bitmap greeny, cupcake, banana, pears, watermelon;

        GreenyCanvas(Context c){
            super(c);
            greeny = BitmapFactory.decodeResource(getResources(),R.mipmap.android);
            greenySrc = new Rect(0, 0, 330, 240);
            greenyDst = new Rect(greenyML, 500, greenyMR, 630);
            cupcake = BitmapFactory.decodeResource(getResources(),R.mipmap.cupcake);
            cupcakeSrc = new Rect(130, 140, 465, 555);
            cupcakeDst = new Rect(cupcakeLeft, cupcakeTop, cupcakeRight, cupcakeBottom);
            banana = BitmapFactory.decodeResource(getResources(), R.mipmap.banana);
            bananaSrc = new Rect(0, 0, 1950, 1670);
            bananaDst = new Rect(50, 90, 150, 190);
            pears = BitmapFactory.decodeResource(getResources(),R.mipmap.pears);
            pearsSrc = new Rect(0, 0, 130, 190);
            pearsDst = new Rect(170, 200, 270, 300);
            watermelon = BitmapFactory.decodeResource(getResources(),R.mipmap.watermelon);
            watermelonSrc = new Rect(0, 0, 150, 200);
            watermelonDst = new Rect(170, 100, 270, 200);

        }
        int mx;
        public boolean onTouchEvent(MotionEvent event) {
            mx = (int) event.getX();
            if(mx <= 240){
                if(greenyML > 0) {
                    greenyML -= 100;
                    greenyMR -= 100;
                }else{
                    greenyML -= 0;
                    greenyMR -= 0;
                }
            }else{
                if(greenyMR < 470) {
                    greenyML += 100;
                    greenyMR += 100;
                }else{
                    greenyML += 0;
                    greenyMR += 0;
                }
            }
            greenyDst.left = greenyML;
            greenyDst.right = greenyMR;
            return super.onTouchEvent(event);
        }
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(greeny, greenySrc, greenyDst, null);
            canvas.drawBitmap(cupcake, cupcakeSrc, cupcakeDst, null);
            canvas.drawBitmap(banana, bananaSrc, bananaDst, null);
            canvas.drawBitmap(pears, pearsSrc, pearsDst, null);
            canvas.drawBitmap(watermelon, watermelonSrc, watermelonDst, null);
            invalidate();
        }
    }

   /* Thread wave;

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
    }*/


    protected void onCreate(Bundle savedInstanceCreate){
        super.onCreate(savedInstanceCreate);
        cv = new GreenyCanvas(this);
        setContentView(cv);

       /* Runnable hand = new waving();
        wave = new Thread(hand);
        wave.start();*/
    }
}

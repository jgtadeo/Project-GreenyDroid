package ph.edu.apc.greenydroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

/**
 * Created by Renzo on 13/08/2016.
 */

public class CupcakeMiniGame extends AppCompatActivity {

    GreenyCanvas cv;

    Rect greenySrc, greenyDst;
    int greenyLeft = 175, greenyTop = 500, greenyRight = 305, greenyBottom = 630;
   // int greenyML = 175, greenyMR = 305;
    Rect cupcakeSrc, cupcakeDst;
    int cupcakeLeft = 190, cupcakeTop = 250, cupcakeRight = 300, cupcakeBottom = 450;
    Rect bananaSrc, bananaDst;
    int bananaTop = -155, bananaBottom = -5;
    Rect pearsSrc, pearsDst;
    int pearsLeft, pearsTop = -105, pearsRight, pearsBottom = -5;
    Rect watermelonSrc, watermelonDst;

    Thread down;

    Random p;

    class GreenyCanvas extends View {

        Bitmap greeny, cupcake, banana, pears, watermelon;

        GreenyCanvas(Context c){

            super(c);

            greeny = BitmapFactory.decodeResource(getResources(),R.mipmap.android);
            greenySrc = new Rect(0, 0, 330, 240);
            greenyDst = new Rect(greenyLeft, greenyTop, greenyRight, greenyBottom);
            cupcake = BitmapFactory.decodeResource(getResources(),R.mipmap.cupcake);
            cupcakeSrc = new Rect(130, 140, 465, 555);
            cupcakeDst = new Rect(cupcakeLeft, cupcakeTop, cupcakeRight, cupcakeBottom);
            // banana = BitmapFactory.decodeResource(getResources(),R.mipmap.banana);
            // bananaSrc = new Rect(0, 0, 1950, 1670);
            // bananaDst = new Rect(50, bananaTop, 150, bananaBottom);
            pears = BitmapFactory.decodeResource(getResources(),R.mipmap.pears);
            pearsSrc = new Rect(0, 0, 130, 190);
            pearsDst = new Rect(pearsLeft, pearsTop, pearsRight, pearsBottom);
            // watermelon = BitmapFactory.decodeResource(getResources(),R.mipmap.watermelon);
            // watermelonSrc = new Rect(0, 0, 150, 200);
            // watermelonDst = new Rect(170, 100, 270, 200);
        }

        int mx;
        public boolean onTouchEvent(MotionEvent event) {
            mx = (int) event.getX();
            if(mx <= 240){
                if(greenyLeft > 0) {
                    greenyLeft -= 100;
                    greenyRight -= 100;
                }else{
                    greenyLeft -= 0;
                    greenyRight -= 0;
                }
            }else{
                if(greenyRight < 470) {
                    greenyLeft += 100;
                    greenyRight += 100;
                }else{
                    greenyLeft += 0;
                    greenyRight += 0;
                }
            }
            greenyDst.left = greenyLeft;
            greenyDst.right = greenyRight;
            return super.onTouchEvent(event);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(greeny, greenySrc, greenyDst, null);
            canvas.drawBitmap(cupcake, cupcakeSrc, cupcakeDst, null);
            // canvas.drawBitmap(banana, bananaSrc, bananaDst, null);
            canvas.drawBitmap(pears, pearsSrc, pearsDst, null);
            //canvas.drawBitmap(watermelon, watermelonSrc, watermelonDst, null);
            invalidate();
        }
    }

    class  AnimateDown implements Runnable{
        public void run(){
            while(true){
                if(pearsBottom >= 900){
                    p = new Random();
                    pearsLeft = p.nextInt(350);
                    pearsRight = pearsLeft + 130;
                    pearsTop = -155;
                    pearsBottom = -5;
                }
                if(greenyTop <= pearsBottom && greenyTop >= pearsTop || greenyBottom <= pearsBottom && greenyBottom >= pearsTop){
                    if(greenyLeft <= pearsLeft && greenyLeft >= pearsRight || greenyRight <= pearsLeft && greenyRight >= pearsRight){
                        p = new Random();
                        pearsLeft = p.nextInt(350);
                        pearsRight = pearsLeft + 130;
                        pearsTop = -155;
                        pearsBottom = -5;
                    }
                }
                pearsTop += 100;
                pearsBottom += 100;
                pearsDst.top = pearsTop;
                pearsDst.bottom = pearsBottom;
                pearsDst.left = pearsLeft;
                pearsDst.right = pearsRight;
                SystemClock.sleep(1000);
            }
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

        Runnable d = new AnimateDown();
        down = new Thread(d);
        down.start();

       /* Runnable hand = new waving();
        wave = new Thread(hand);
        wave.start();*/
    }
}
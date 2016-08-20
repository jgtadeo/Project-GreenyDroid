package ph.edu.apc.greenydroid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
    Rect cupcakeSrc, cupcakeDst;
    int cupcakeLeft, cupcakeTop = -125, cupcakeRight, cupcakeBottom = -5;
    Rect bananaSrc, bananaDst;
    int bananaTop = -155, bananaBottom = -5;
    Rect pearsSrc, pearsDst;
    int pearsLeft = 100, pearsTop = -105, pearsRight = 200, pearsBottom = -20;
    Rect watermelonSrc, watermelonDst;
    int waterLeft = 150, waterTop = -190, waterRight = 250, waterBottom = -105;

    int count, score;

    Thread down, time;

    Random p, c;

    Paint blck;

    class GreenyCanvas extends View {

        Bitmap greeny, cupcake, banana, pears, watermelon;

        GreenyCanvas(Context c){

            super(c);

            blck = new Paint();
            blck.setColor(Color.BLACK);
            blck.setTextSize(30);

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
            watermelon = BitmapFactory.decodeResource(getResources(),R.mipmap.watermelon);
            watermelonSrc = new Rect(0, 0, 150, 200);
            watermelonDst = new Rect(waterLeft, waterTop, waterRight, waterBottom);
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
            canvas.drawBitmap(watermelon, watermelonSrc, watermelonDst, null);
            canvas.drawText("Score: " + score, 320, 50, blck);
            invalidate();
        }
    }

    class Timer implements Runnable{
        @Override
        public void run() {
            while(count != 5){
                SystemClock.sleep(1000);
                count++;
            }
        }
    }

    class  AnimateDown implements Runnable{
        public void run(){
            while(true){

                pearsTop += 100;
                pearsBottom += 100;
                waterTop += 100;
                waterBottom += 100;
                cupcakeTop += 150;
                cupcakeBottom += 150;

                if(pearsBottom >= 1000){
                    p = new Random();
                    pearsLeft = p.nextInt(350);
                    pearsRight = pearsLeft + 100;
                    pearsTop = -105;
                    pearsBottom = -20;
                }
                if(waterBottom >= 1000){
                    p = new Random();
                    waterLeft = p.nextInt(350);
                    waterRight = waterLeft + 100;
                    waterTop = -190;
                    waterBottom = -105;
                }
                if(count == 5) {
                    if (cupcakeBottom >= 2000) {
                        c = new Random();
                        cupcakeLeft = c.nextInt(350);
                        cupcakeRight = cupcakeLeft + 130;
                        cupcakeTop = -125;
                        cupcakeBottom = -5;
                    }
                }

                if(greenyLeft >= pearsLeft && greenyLeft <= pearsRight || greenyRight >= pearsLeft && greenyRight <= pearsRight){
                    if(greenyTop >= pearsTop && greenyTop <= pearsBottom || greenyBottom >= pearsTop && greenyBottom <= pearsBottom){
                        p = new Random();
                        pearsLeft = p.nextInt(350);
                        pearsRight = pearsLeft + 100;
                        pearsTop = -105;
                        pearsBottom = -5;
                        score += 20;
                    }
                }
                if(greenyLeft >= waterLeft && greenyLeft <= waterRight || greenyRight >= waterLeft && greenyRight <= waterRight){
                    if(greenyTop >= waterTop && greenyTop <= waterBottom || greenyBottom >= waterTop && greenyBottom <= waterBottom){
                        p = new Random();
                        waterLeft = p.nextInt(350);
                        waterRight = waterLeft + 100;
                        waterTop = -190;
                        waterBottom = -105;
                        score += 40;
                    }
                }
                if(greenyLeft >= cupcakeLeft && greenyLeft <= cupcakeRight || greenyRight >= cupcakeLeft && greenyRight <= cupcakeRight){
                    if(greenyTop >= cupcakeTop && greenyTop <= cupcakeBottom || greenyBottom >= cupcakeTop && greenyBottom <= cupcakeBottom){
                        Intent i = new Intent(CupcakeMiniGame.this, MiniGameOver.class);
                        startActivity(i);
                        finish();
                        break;
                    }
                }
                if(score == 500){
                    Intent i = new Intent(CupcakeMiniGame.this, MiniGameContinueActivity.class);
                    startActivity(i);
                    finish();
                    break;
                }
                pearsDst.top = pearsTop;
                pearsDst.bottom = pearsBottom;
                pearsDst.left = pearsLeft;
                pearsDst.right = pearsRight;
                watermelonDst.top = waterTop;
                watermelonDst.bottom = waterBottom;
                watermelonDst.left = waterLeft;
                watermelonDst.right = waterRight;
                cupcakeDst.top = cupcakeTop;
                cupcakeDst.bottom = cupcakeBottom;
                cupcakeDst.left = cupcakeLeft;
                cupcakeDst.right = cupcakeRight;
                SystemClock.sleep(500);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceCreate){
        super.onCreate(savedInstanceCreate);
        cv = new GreenyCanvas(this);
        setContentView(cv);

        Runnable d = new AnimateDown();
        down = new Thread(d);
        down.start();

        Runnable t = new Timer();
        time = new Thread(t);
        time.start();
    }
}
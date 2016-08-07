package ph.edu.apc.greenydroid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /*GreenyCanvas cv;
    //Background
    Rect bsrc, bdst;
    Bitmap bgd;
    //Greeny
    Rect gsrc, gdst;
    Bitmap greeny;
    //Cupcake
    Rect csrc, cdst;
    Bitmap cupcake;
    //Donut
    Rect dsrc, ddst;
    Bitmap donut;
    //Eclair
    Rect esrc, edst;
    Bitmap eclair;
    //Froyo
    Rect fsrc, fdst;
    Bitmap froyo;
    //Gingerbread
    Rect gisrc,gidst;
    Bitmap gingerbread;
    //Honeycomb
    Rect hsrc, hdst;
    Bitmap honeycomb;
    //Ice Cream
    Rect isrc, idst;
    Bitmap icecream;
    //Jellybean
    Rect jsrc, jdst;
    Bitmap jellybean;
    //Kitkat
    Rect ksrc, kdst;
    Bitmap kitkat;
    //Lollipop
    Rect lsrc, ldst;
    Bitmap lollipop;
    //Marshmallow
    Rect msrc, mdst;
    Bitmap marshmallow;

    class GreenyCanvas extends View {
        GreenyCanvas(Context c) {
            super(c);
            bgd = BitmapFactory.decodeResource(getResources(),R.mipmap.background);
            bsrc = new Rect(0,0,800,480);
            bdst = new Rect(0,0,480,800);

            greeny = BitmapFactory.decodeResource(getResources(),R.mipmap.greenydroid);
            gsrc = new Rect(180,310,340,485);
            gdst = new Rect(120,170,340,400);

            cupcake = BitmapFactory.decodeResource(getResources(),R.mipmap.cupcake);
            csrc = new Rect(120,150,455,555);
            cdst = new Rect(50,480,130,560);

            donut = BitmapFactory.decodeResource(getResources(),R.mipmap.donut);
            dsrc = new Rect(115,70,530,400);
            ddst = new Rect(145,480,235,560);

            eclair = BitmapFactory.decodeResource(getResources(),R.mipmap.eclair);
            esrc = new Rect(140,200,550,350);
            edst = new Rect(245,520,335,560);

            froyo = BitmapFactory.decodeResource(getResources(), R.mipmap.froyo);
            fsrc = new Rect(150,190,510,550);
            fdst = new Rect(345,480,435,560);

            gingerbread = BitmapFactory.decodeResource(getResources(), R.mipmap.gingerbread);
            gisrc = new Rect(100,0,596,482);
            gidst = new Rect();

            honeycomb = BitmapFactory.decodeResource(getResources(), R.mipmap.honeycomb);
            hsrc = new Rect(15,42,377,333);
            hdst = new Rect();

            icecream = BitmapFactory.decodeResource(getResources(), R.mipmap.icecreamsandwich);
            isrc = new Rect(72,62,391,271);
            idst = new Rect();

            jellybean = BitmapFactory.decodeResource(getResources(), R.mipmap.jellybean);
            jsrc = new Rect(0,0,499,499);
            jdst = new Rect();

            kitkat = BitmapFactory.decodeResource(getResources(), R.mipmap.kitkat);
            ksrc = new Rect(235,291,618,520);
            kdst = new Rect();

            lollipop = BitmapFactory.decodeResource(getResources(), R.mipmap.lollipop);
            lsrc = new Rect(41,236,553,588);
            ldst = new Rect();

            marshmallow = BitmapFactory.decodeResource(getResources(), R.mipmap.marshmallow);
            msrc = new Rect(145,26,545,479);
            mdst = new Rect();
        }
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawBitmap(bgd, bsrc, bdst, null);
            canvas.drawBitmap(greeny, gsrc, gdst, null);
            canvas.drawBitmap(cupcake, csrc, cdst, null);
            canvas.drawBitmap(donut,dsrc,ddst,null);
            canvas.drawBitmap(eclair,esrc,edst,null);
            canvas.drawBitmap(froyo,fsrc,fdst,null);
            canvas.drawBitmap(gingerbread,gisrc,gidst,null);
            canvas.drawBitmap(honeycomb,hsrc,hdst,null);
            canvas.drawBitmap(icecream,isrc,idst,null);
            canvas.drawBitmap(jellybean,jsrc,jdst,null);
            canvas.drawBitmap(kitkat,ksrc,kdst,null);
            canvas.drawBitmap(lollipop,lsrc,ldst,null);
            canvas.drawBitmap(marshmallow,msrc,mdst,null);
        }
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setting = (Button)findViewById(R.id.btnSetting);
        setting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}

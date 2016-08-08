package ph.edu.apc.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
NQACanvas canvas;
Paint pg, pr, pb, pw,pblack;
Bitmap mirra;
class NQACanvas extends View {
    NQACanvas(Context c) {
        super(c);
        pg = new Paint(); pg.setColor(Color.GREEN);
        pr = new Paint(); pr.setColor(Color.RED);
        pb = new Paint(); pb.setColor(Color.BLUE);
        pw = new Paint(); pw.setColor(Color.WHITE);
        pblack = new Paint(); pblack.setColor(Color.BLACK);
        pblack.setTextSize(28); pblack.setFakeBoldText(true);
        pcolor = new Paint[]{pg,pb,pr,pw,pg,pb,pw,pg,pb,pw,pr};
        rlabel = new String[] {"Walk Up","Walk Down","Stand Up","Stand Down"};
        mirra = BitmapFactory.decodeResource(getResources(),R.mipmap.mirrab);
        misrc = new Rect(70,210,70+70,210+70);
        midst = new Rect(73,370,73+170,370+170);
    }
    int rwidth = 220, rleft = 250, rtop =80, rheight=50, maxr=4;
    int mileft=0,mitop=0;
    Paint [] pcolor= new Paint[maxr];
    String [] rlabel = new String[maxr];
    Rect misrc, midst;
    String msg="Coordinate";
    public boolean onTouchEvent(MotionEvent event) {
        msg = " x="+event.getX()+" y="+event.getY();
        mileft= (int)event.getX(); mitop = (int) event.getY();
        midst.left = mileft; midst.top = mitop; midst.right = midst.left +170;
        midst.bottom = midst.top + 170;
        return super.onTouchEvent(event);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    canvas.drawColor(Color.YELLOW);
        for (int i = 0; i <maxr; i++) {
  canvas.drawRect(rleft,rtop+rheight*i,rleft+rwidth,rtop + rheight*(i+1),pcolor[i]);
    canvas.drawText(rlabel[i],rleft+10,rtop+30+rheight*i,pblack);
   canvas.drawBitmap(mirra,misrc,midst,null);

        }
        canvas.drawText(msg,20,300,pblack);
        invalidate();
        /*

    canvas.drawRect(rleft,rtop,rleft+rwidth,rtop + rheight,pg);
    canvas.drawRect(rleft,rtop+ rheight,rleft+rwidth,rtop + rheight*2,pb);
    canvas.drawRect(rleft,rtop+ rheight*2,rleft+rwidth,rtop + rheight*3,pr);
    canvas.drawRect(rleft,rtop+ rheight*3,rleft+rwidth,rtop + rheight*4,pw);
*/

    }
} //end of canvas

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canvas = new NQACanvas(this);
        setContentView(canvas);
    }}
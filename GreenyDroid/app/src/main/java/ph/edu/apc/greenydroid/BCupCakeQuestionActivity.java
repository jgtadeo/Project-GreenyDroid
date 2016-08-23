package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;

/**
 * Created by Renzo on 22/08/2016.
 */
public class BCupcakeQuestionActivity extends AppCompatActivity {

    static RadioButton A, B, C ,D;

    int t = 0;

    Thread tim;

    boolean here = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcupcakequestion);

        Runnable ti = new timer();
        tim = new Thread(ti);
        tim.start();

        A = (RadioButton)findViewById(R.id.radioButtonA);
        A.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    nextButton();
                }else{
                    nextButton();
                }
            }
        });
        B = (RadioButton)findViewById(R.id.radioButtonB);
        B.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    SharedPreferences sp = getSharedPreferences("QuestionCupcake",MODE_PRIVATE);
                    SharedPreferences.Editor spsave = sp.edit();
                    spsave.commit();
                    nextButton();
                }else{
                    nextButton();
                }
            }
        });
        C = (RadioButton)findViewById(R.id.radioButtonC);
        C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    nextButton();
                }else{
                    nextButton();
                }
            }
        });
        D = (RadioButton)findViewById(R.id.radioButtonD);
        D.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    nextButton();
                }else{
                    nextButton();
                }
            }
        });
    }
    private void nextButton(){
        Button next = (Button)findViewById(R.id.btnNext);
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(BCupcakeQuestionActivity.this, CCupcakeQuestionActivity.class);
                startActivity(i);
                finish();
                here = false;
            }
        });
    }
    class timer implements Runnable{
        @Override
        public void run() {
            while(t != 10) {
                SystemClock.sleep(1000);
                t++;
            }
            if(t == 10 && here){
                Intent i = new Intent(BCupcakeQuestionActivity.this, CCupcakeQuestionActivity.class);
                startActivity(i);
                finish();
                here = false;

            }
        }
    }
}

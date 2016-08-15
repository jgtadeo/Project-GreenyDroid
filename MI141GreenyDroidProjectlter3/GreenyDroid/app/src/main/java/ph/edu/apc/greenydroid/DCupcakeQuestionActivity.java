package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;

/**
 * Created by Renzo on 14/08/2016.
 */
public class DCupcakeQuestionActivity extends AppCompatActivity {

    static RadioButton A, B, C ,D;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcupcakequestion);

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
                Intent i = new Intent(DCupcakeQuestionActivity.this, ECupcakeQuestionActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

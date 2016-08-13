package ph.edu.apc.greenydroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Renzo on 13/08/2016.
 */
public class CupcakeResultActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcakeresult);

        int c = 0;
        String name = StartActivity.name;

        if(StartActivity.name.isEmpty()){
            TextView Score = (TextView)findViewById(R.id.score);
            Score.setText("Your score is: " + c);
        }else{
            TextView Name = (TextView)findViewById(R.id.textView);
            Name.setText("Congratulation " + name);
        }

        if(CCupcakeQuestionActivity.D.isChecked()){
            c+=1;
        }else{

        }
        if(BCupCakeQuestionActivity.C.isChecked()){
            c+=1;
        }else{

        }
        if(ACupcakeQuestionActivity.C.isChecked()){
            c+=1;
        }else{

        }




    }
}

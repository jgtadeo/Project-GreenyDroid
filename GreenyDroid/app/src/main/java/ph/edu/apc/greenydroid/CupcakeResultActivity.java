package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Renzo on 13/08/2016.
 */
public class CupcakeResultActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcakeresult);

        int c = 0;
        String name = StartActivity.name;

        Toast.makeText(CupcakeResultActivity.this, "Score must be 3 to proceed.", Toast.LENGTH_LONG).show();

        if(CCupcakeQuestionActivity.D.isChecked()){
            c+=1;
        }
        if(BCupCakeQuestionActivity.C.isChecked()){
            c+=1;
        }
        if(ACupcakeQuestionActivity.C.isChecked()){
            c+=1;
        }

        if(c == 3){
            nextButton();
        }else if(c < 3){
            retryButton();
        }

        if(StartActivity.name.isEmpty()){
            TextView Score = (TextView)findViewById(R.id.score);
            Score.setText("Your score is: " + c);
        }else{
            TextView Name = (TextView)findViewById(R.id.congratulation);
            Name.setText("Congratulation " + name);
        }


    }
    private void retryButton(){
        Button retry = (Button)findViewById(R.id.btnRetry);
        retry.setVisibility(View.VISIBLE);
        retry.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(CupcakeResultActivity.this, ACupcakeQuestionActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void nextButton(){
        Button next = (Button)findViewById(R.id.btnNext);
        next.setVisibility(View.VISIBLE);
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                Intent i = new Intent(CupcakeResultActivity.this, CupcakeMiniGame.class);
                startActivity(i);
                finish();
                }
            });
    }

}

package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Renzo on 13/08/2016.
 */
public class CupcakeResultActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcakeresult);

        int c = 0;
        String name = StartActivity.name;

        if(CCupcakeQuestionActivity.D.isChecked()){
            c+=1;
        }
        if(BCupCakeQuestionActivity.C.isChecked()){
            c+=1;
        }
        if(ACupcakeQuestionActivity.C.isChecked()){
            c+=1;
        }
        switch(c){
            case 1:
                if(StartActivity.name.isEmpty()){

                }else{
                    TextView Name = (TextView)findViewById(R.id.congratulation);
                    Name.setText("Try again "  + name);
                    TextView Score = (TextView)findViewById(R.id.score);
                    Score.setText("" + c);
                }
                retryButton();
                break;
            case 2:
                if(StartActivity.name.isEmpty()){

                }else{
                    TextView Name = (TextView)findViewById(R.id.congratulation);
                    Name.setText("Almost there "  + name);
                    TextView Score = (TextView)findViewById(R.id.score);
                    Score.setText("" + c);
                }
                retryButton();
                break;
            case 3:
                if(StartActivity.name.isEmpty()){

                }else{
                    TextView Name = (TextView)findViewById(R.id.congratulation);
                    Name.setText("Congratulation " + name);
                    TextView Score = (TextView)findViewById(R.id.score);
                    Score.setText("" + c);
                }
                nextButton();
                break;
            default:
                if(StartActivity.name.isEmpty()){

                }else{
                    TextView Name = (TextView)findViewById(R.id.congratulation);
                    Name.setText("Please try again " + name);
                    TextView Score = (TextView)findViewById(R.id.score);
                    Score.setText("" + c);
                }
                retryButton();
                break;

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
                Intent i = new Intent(CupcakeResultActivity.this, Introduction3Activity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

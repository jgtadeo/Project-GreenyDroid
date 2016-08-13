package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Renzo on 11/08/2016.
 */
public class IntroductionActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        beginButton();

    }
    private void beginButton() {
        Button begin = (Button)findViewById(R.id.btnBegin);
        begin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(IntroductionActivity.this, ACupcakeStoryActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

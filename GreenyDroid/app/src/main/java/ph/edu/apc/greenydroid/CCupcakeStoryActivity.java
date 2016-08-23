package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Renzo on 22/08/2016.
 */
public class CCupcakeStoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccupcakestory);
        beginButton();
    }
    private void beginButton(){
        Button begin = (Button)findViewById(R.id.btnBegin);
        begin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CCupcakeStoryActivity.this, ACupcakeQuestionActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

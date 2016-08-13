package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Renzo on 03/08/2016.
 */
public class AboutActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        backButton();

        /*Button back = (Button)findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AboutActivity.this, MainActivity.class);
                startActivity(i);
                bgdCheck = 1;
                finish();
            }
        });*/
    }
    public void backButton(){
        Button back = (Button)findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(AboutActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Renzo on 13/08/2016.
 */
public class Introduction3Activity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction3);
        beginButton();
    }
    private void beginButton(){
        Button begin = (Button)findViewById(R.id.btnBegin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Introduction3Activity.this, CupcakeMiniGame.class);
                startActivity(i);
                finish();
            }
        });
    }
}

package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Renzo on 22/08/2016.
 */
public class ACupcakeStoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acupcakestory);
        Thread myThread = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                    Intent i = new Intent(getApplicationContext(),BCupcakeStoryActivity.class);
                    startActivity(i);
                    finish();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}

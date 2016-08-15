package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Renzo on 13/08/2016.
 */
public class BCupcakeStoryActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcupcakestory);
        Thread myThread = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                    Intent i = new Intent(getApplicationContext(), CCupcakeStoryActivity.class);
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

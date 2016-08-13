package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Renzo on 12/08/2016.
 */
public class ACupcakeStoryActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acupcakestory);
        Thread myThread = new Thread(){
            public void run(){
                try{
<<<<<<< HEAD
                    sleep(5000);
                    Intent i = new Intent(getApplicationContext(),IntroductionActivity.class);
=======
                    sleep(8000);
                    Intent i = new Intent(getApplicationContext(),BCupcakeStoryActivity.class);
>>>>>>> origin/master
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

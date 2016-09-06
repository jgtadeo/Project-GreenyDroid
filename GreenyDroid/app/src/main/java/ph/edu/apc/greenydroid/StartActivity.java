package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Renzo on 11/08/2016.
 */
public class StartActivity extends AppCompatActivity {

    static EditText editName;
    static String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Toast.makeText(StartActivity.this, "WARNING! without name, score will not be displayed.", Toast.LENGTH_LONG).show();

        continueButton();
    }
    public void continueButton() {
        Button cntinue = (Button) findViewById(R.id.btnContinue);
        cntinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, IntroductionActivity.class);
                editName = (EditText) findViewById(R.id.editName);
                name = editName.getText().toString();
                SharedPreferences sp = getSharedPreferences("name.txt",MODE_PRIVATE);
                SharedPreferences.Editor spsave = sp.edit();
                spsave.putString("Name", name);
                spsave.commit();
                startActivity(i);
                finish();
            }
        });
    }
}


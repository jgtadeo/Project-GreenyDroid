package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

/**
 * Created by Renzo on 03/08/2016.
 */
public class SettingActivity extends AppCompatActivity {

    public static int bgdCheck = 0;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button back = (Button)findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(i);
                finish();
                bgdCheck = 1;
            }
        });

        final ToggleButton music = (ToggleButton)findViewById(R.id.toggleButton);
        music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if(isChecked){
                    SharedPreferences.Editor editor = getSharedPreferences("GreenyDroid", MODE_PRIVATE).edit();
                    editor.putBoolean("Pause", true);
                    editor.commit();
                    music.setChecked(true);
                    MainActivity.bgdMusic.pause();
                }else{
                    SharedPreferences.Editor editor = getSharedPreferences("GreenyDroid", MODE_PRIVATE).edit();
                    editor.putBoolean("Resume", false);
                    editor.commit();
                    music.setChecked(false);
                    MainActivity.bgdMusic.start();
                }
            }
        });
    }
}

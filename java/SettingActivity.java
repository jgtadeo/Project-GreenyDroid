package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by Renzo on 03/08/2016.
 */
public class SettingActivity extends AppCompatActivity {

    public static int bgdCheck = 0;
    static CheckBox music;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        backButton();

        music = (CheckBox) findViewById(R.id.checkBox);
        if (MainActivity.bgdMusic.isPlaying()) {
            SettingActivity.music.setChecked(true);
        } else {
            SettingActivity.music.setChecked(false);
        }

        music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SharedPreferences.Editor editor = getSharedPreferences("GreenyDroid", MODE_PRIVATE).edit();
                    editor.putBoolean("Resume", true);
                    editor.commit();
                    music.setChecked(true);
                    MainActivity.bgdMusic.start();
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("GreenyDroid", MODE_PRIVATE).edit();
                    editor.putBoolean("Pause", false);
                    editor.commit();
                    music.setChecked(false);
                    MainActivity.bgdMusic.pause();
                }
            }
        });

        /*Button back = (Button)findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(SettingActivity.this, MainActivity.class);
                bgdCheck = 0;
                startActivity(i);
                finish();
                SharedPreferences sp = getSharedPreferences("notepad.txt",MODE_PRIVATE);
                SharedPreferences.Editor spsave = sp.edit();
                spsave.apply();
                spsave.commit();

            }
        });*/
    }
    public void backButton() {
        Button back = (Button) findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bgdCheck = 1;
                Intent i = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(i);
                finish();
                SharedPreferences sp = getSharedPreferences("notepad.txt", MODE_PRIVATE);
                SharedPreferences.Editor spsave = sp.edit();
                spsave.commit();
            }
        });
    }
}


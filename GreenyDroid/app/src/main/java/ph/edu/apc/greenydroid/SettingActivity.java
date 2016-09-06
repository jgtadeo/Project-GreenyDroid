package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
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
    MediaPlayer bgmusic = MainActivity.bgdMusic;
    static CheckBox music;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        scoreButton();
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
                    music.setChecked(true);
                } else {
                    music.setChecked(false);
                    MainActivity.bgdMusic.pause();
                }
            }
        });
    }
    public void backButton() {
        Button back = (Button) findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bgdCheck = 1;
                Intent i = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    private void scoreButton(){
        Button score = (Button)findViewById(R.id.btnScore);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(SettingActivity.this, LastMiniGameCongrats.class);
                startActivity(j);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        bgmusic.stop();
    }
}


package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static MediaPlayer bgdMusic;
    private int bgdChecked = SettingActivity.bgdCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingButton();
        aboutButton();

        if (bgdChecked == 0) {
            bgdMusic = MediaPlayer.create(this, R.raw.sample);
            bgdMusic.setLooping(true);
            bgdMusic.start();
        }

       /* Button setting = (Button) findViewById(R.id.btnSetting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button about = (Button) findViewById(R.id.btnAbout);
        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
                finish();
            }
        });*/
    }
    private void settingButton(){
        Button setting = (Button)findViewById(R.id.btnSetting);
        setting.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    private void aboutButton(){
        Button about = (Button)findViewById(R.id.btnAbout);
        about.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}


package ph.edu.apc.greenydroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static MediaPlayer bgdMusic;
    private int bgdChecked = SettingActivity.bgdCheck;
    private int bgdChecked1 = AboutActivity.bgdCheck1;
    private int bgdChecked2 = MiniGameOver.bgdCheck2;
    private int bgdChecked3 = CupcakeMiniGameOverActivity.bgdCheck3;
    private int bgdChecked4 = MiniGameContinueActivity.bgdCheck4;
    private int bgdChecked5 = CupcakeMiniGameContinueActivity.bgdCheck5;
    private int bgdChecked6 = LastMiniGameCongrats.bgdCheck6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingButton();
        aboutButton();
        startButton();

        if (bgdChecked == 0) {
            if(bgdChecked1 == 0) {
                if(bgdChecked2 == 0) {
                    if(bgdChecked3 == 0) {
                        if(bgdChecked4 == 0) {
                            if(bgdChecked5 == 0) {
                                if(bgdChecked6 == 0) {
                                    bgdMusic = MediaPlayer.create(this, R.raw.tiptoe);
                                    bgdMusic.setLooping(true);
                                    bgdMusic.start();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void settingButton() {
        Button setting = (Button) findViewById(R.id.btnSetting);
        setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void aboutButton() {
        Button about = (Button) findViewById(R.id.btnAbout);
        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void startButton() {
        Button start = (Button) findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StartActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        bgdMusic.stop();
    }
}



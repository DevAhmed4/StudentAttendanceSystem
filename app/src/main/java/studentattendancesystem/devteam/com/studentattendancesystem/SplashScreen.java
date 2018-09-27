package studentattendancesystem.devteam.com.studentattendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private final static int SECONDS = 3;
    Animation scaleDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        final ImageView MTI_Logo = (ImageView)findViewById(R.id.MTI_Logo);


        scaleDown = AnimationUtils.loadAnimation(this, R.anim.splash_animation);

        /****** Create Thread that will sleep for 5 seconds****/
        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 3 seconds
                    //start the animations for MTI_Logo image
                    MTI_Logo.startAnimation(scaleDown);
                    sleep(SECONDS*1000);

                    // After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),LogInActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();

    }

}

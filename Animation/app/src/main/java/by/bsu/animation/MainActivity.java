package by.bsu.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = findViewById(R.id.animationView);
        img.setImageResource(R.mipmap.ic_android);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.common_animation);

        img.startAnimation(animation);

    }
}

package freetesting.masinac.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ActivityMain extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initBackgroundImage();
    }

    private void initBackgroundImage() {
        ImageView backgroundImageView = (ImageView) findViewById(R.id.background);

        if (backgroundImageView != null) {
            Glide.with(this).load(R.drawable.background).centerCrop().into(backgroundImageView);
        }
    }
}

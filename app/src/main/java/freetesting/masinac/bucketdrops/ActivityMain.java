package freetesting.masinac.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Button addDropButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        addDropButton = (Button) findViewById(R.id.btn_add_drop);
        addDropButton.setOnClickListener(this);

        setSupportActionBar(toolbar);
        initBackgroundImage();


    }

    private void initBackgroundImage() {
        ImageView backgroundImageView = (ImageView) findViewById(R.id.background);

        if (backgroundImageView != null) {
            Glide.with(this).load(R.drawable.background).centerCrop().into(backgroundImageView);
        }
    }

    @Override
    public void onClick(View v) {
        showDialogAdd();
    }

    private void showDialogAdd() {
        DialogAdd dialog = new DialogAdd();
        dialog.show(getSupportFragmentManager(), "Add");
    }
}

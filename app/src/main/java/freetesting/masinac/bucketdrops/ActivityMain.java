package freetesting.masinac.bucketdrops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import freetesting.masinac.bucketdrops.adapters.AdapterDrops;
import freetesting.masinac.bucketdrops.beans.Drop;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Button addDropButton;
    RecyclerView recyclerView;
    Realm mRealm;
    AdapterDrops adapterDrops;
    private String tag = "Masinac";
    RealmResults<Drop> results;

    private RealmChangeListener mChangeListener = new RealmChangeListener() {
        @Override
        public void onChange(Object element) {
            adapterDrops.update(results);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        addDropButton = (Button) findViewById(R.id.btn_add_drop);
        addDropButton.setOnClickListener(this);

        // query Realm DB
        mRealm = Realm.getDefaultInstance();
        results = mRealm.where(Drop.class).findAllAsync();

        adapterDrops = new AdapterDrops(this, results);

        recyclerView = (RecyclerView) findViewById(R.id.drops);
        recyclerView.setAdapter(adapterDrops);

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
    protected void onStart() {
        super.onStart();
        mRealm.addChangeListener(mChangeListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRealm.removeChangeListener(mChangeListener);
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

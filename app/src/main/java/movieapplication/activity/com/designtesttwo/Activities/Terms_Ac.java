package movieapplication.activity.com.designtesttwo.Activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import movieapplication.activity.com.designtesttwo.R;

public class Terms_Ac extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_36dp);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        ListView lv = (ListView) findViewById(R.id.courseList);
        ArrayList<String> terms = new ArrayList<>();
        terms.add("Term1");
        terms.add("Term1");
        terms.add("Term1");
        terms.add("Term1");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.content_terms_, R.id.user_term_text, terms);
        lv.setAdapter(adapter);
        pb.setVisibility(View.GONE);

    }

}

package movieapplication.activity.com.designtesttwo.Activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import movieapplication.activity.com.designtesttwo.Classes.DummyQuestion;
import movieapplication.activity.com.designtesttwo.Classes.DummyReviews;
import movieapplication.activity.com.designtesttwo.Classes.DummyUser;
import movieapplication.activity.com.designtesttwo.R;
import movieapplication.activity.com.designtesttwo.UI.FAQ_Adapter;
import movieapplication.activity.com.designtesttwo.UI.ReviewAdapter;

public class FAQ_Ac extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_36dp);
        ListView lv = (ListView) findViewById(R.id.courseList);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        ArrayList<DummyQuestion> questions = new ArrayList<>();
        questions.add(new DummyQuestion(1,"quesion 1") );
        questions.add(new DummyQuestion(1,"quesion 1") );
        questions.add(new DummyQuestion(1,"quesion 1") );
        DummyUser user = new DummyUser(R.mipmap.ic_account_box_white_48dp,"regularuUer","User1");

        FAQ_Adapter adapter = new FAQ_Adapter(getApplicationContext(),questions,user);
        lv.setAdapter(adapter);
        pb.setVisibility(View.GONE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

package movieapplication.activity.com.designtesttwo.Activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import movieapplication.activity.com.designtesttwo.Classes.DummyUser;
import movieapplication.activity.com.designtesttwo.R;
import movieapplication.activity.com.designtesttwo.UI.ReviewAdapter;

public class AcceptNDecline_Ac extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_ndecline_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_36dp);
        View header = getLayoutInflater().inflate(R.layout.header_accept_decline, null);
        View footer = getLayoutInflater().inflate(R.layout.accept_decline_footer, null);
        ListView lv = (ListView) findViewById(R.id.courseList);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        lv.addHeaderView(header);
        ArrayList<String> Users = new ArrayList<>();
        Users.add("student1");
        Users.add("student2");
        Users.add("student3");
        Users.add("student4");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.content_accept_ndecline_, R.id.student, Users);
        lv.setAdapter(adapter);
        lv.addFooterView(footer);
        pb.setVisibility(View.GONE);


    }

}

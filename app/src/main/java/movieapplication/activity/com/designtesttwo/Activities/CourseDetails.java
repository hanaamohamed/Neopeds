package movieapplication.activity.com.designtesttwo.Activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import movieapplication.activity.com.designtesttwo.Classes.DummyReviews;
import movieapplication.activity.com.designtesttwo.R;
import movieapplication.activity.com.designtesttwo.UI.ReviewAdapter;

public class CourseDetails extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_36dp);
        View header = getLayoutInflater().inflate(R.layout.header_course_details, null);
        ListView lv = (ListView) findViewById(R.id.courseList);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        lv.addHeaderView(header);
        ArrayList<DummyReviews> reviews = new ArrayList<>();
        reviews.add(new DummyReviews("author1","review1"));
        reviews.add(new DummyReviews("author2","review2"));
        reviews.add(new DummyReviews("author3","review3"));
        reviews.add(new DummyReviews("author4", "review4"));
        ReviewAdapter adapter = new ReviewAdapter(getApplicationContext(),reviews);
        lv.setAdapter(adapter);
        pb.setVisibility(View.GONE);
    }

}

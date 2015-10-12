package movieapplication.activity.com.designtesttwo.Activities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import movieapplication.activity.com.designtesttwo.Classes.DummyCourse;
import movieapplication.activity.com.designtesttwo.R;
import movieapplication.activity.com.designtesttwo.UI.LeaderAndCourseAdapter;

public class WishList_Ac extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_36dp);
        final Context context = getApplicationContext();
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        ListView lv = (ListView) findViewById(R.id.courseList);
        List<DummyCourse> courseList = new ArrayList<>();
        courseList.add(new DummyCourse(R.mipmap.ic_assignment_black_48dp,"Course1"));
        courseList.add(new DummyCourse(R.mipmap.ic_assignment_black_48dp,"Course2"));
        courseList.add(new DummyCourse(R.mipmap.ic_assignment_black_48dp,"Course3"));
        courseList.add(new DummyCourse(R.mipmap.ic_assignment_black_48dp, "Course4"));
        LeaderAndCourseAdapter adapter = new LeaderAndCourseAdapter(context);
        adapter.addDummyCourses(courseList);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,CourseDetails.class);
                startActivity(intent);
            }
        });
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

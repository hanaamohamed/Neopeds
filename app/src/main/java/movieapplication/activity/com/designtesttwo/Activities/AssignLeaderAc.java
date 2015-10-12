package movieapplication.activity.com.designtesttwo.Activities;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import movieapplication.activity.com.designtesttwo.Fragments.AssignLeaderDialog;
import movieapplication.activity.com.designtesttwo.R;

public class AssignLeaderAc extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_leader);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_36dp);
        Context context = getApplicationContext();
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        ListView mCoursesList = (ListView) findViewById(R.id.courseList);
        ArrayList<String> mCourses = new ArrayList<>();
        mCourses.add("course1");
        mCourses.add("course2");
        mCourses.add("course2");
        ArrayAdapter<String> mCoursesAdapter = new ArrayAdapter<String>(context, R.layout.course_item_con, R.id.courseTv, mCourses);
        mCoursesList.setAdapter(mCoursesAdapter);
        mCoursesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AssignLeaderDialog assignLeaderDialog = new AssignLeaderDialog();
                assignLeaderDialog.show(getFragmentManager()," ");
            }
        });
        pb.setVisibility(View.INVISIBLE);
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

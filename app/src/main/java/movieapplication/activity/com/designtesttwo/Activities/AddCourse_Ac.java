package movieapplication.activity.com.designtesttwo.Activities;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import movieapplication.activity.com.designtesttwo.Fragments.TimerPickerDialog;
import movieapplication.activity.com.designtesttwo.R;

public class AddCourse_Ac extends AppCompatActivity implements TimerPickerDialog.OnFragmentInteractionListener {

    Button startAt, end;
    boolean startClicked;
    boolean endClicked;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_36dp);
        startAt = (Button) findViewById(R.id.courseDateStart);
        end = (Button) findViewById(R.id.courseEnd);
        startAt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TimerPickerDialog timer = new TimerPickerDialog();
                timer.show(getFragmentManager(), "datePicker");
                startClicked = true;
                endClicked = false;
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TimerPickerDialog timer = new TimerPickerDialog();
                timer.show(getFragmentManager(), "datePicker");

                endClicked = true;
                startClicked = false;

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onDatePicker(int year, int monthOfYear, int DayOfMonth) {
        if (startClicked) {
            startAt.setText(DayOfMonth + "/" + monthOfYear + "/" + year);
            startAt.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
        if (endClicked) {
            end.setText(DayOfMonth + "/" + monthOfYear + "/" + year);
            end.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
    }


}

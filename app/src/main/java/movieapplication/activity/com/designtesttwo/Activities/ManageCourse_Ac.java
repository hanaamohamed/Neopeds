package movieapplication.activity.com.designtesttwo.Activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;
import movieapplication.activity.com.designtesttwo.R;

public class ManageCourse_Ac extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_course_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_white_36dp);
        CircleImageView acceptNDecline = (CircleImageView) findViewById(R.id.accept_decline);
        acceptNDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AcceptNDecline_Ac.class);
                startActivity(intent);
            }
        });

    }

}

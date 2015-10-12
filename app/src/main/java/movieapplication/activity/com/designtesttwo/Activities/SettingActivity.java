package movieapplication.activity.com.designtesttwo.Activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import movieapplication.activity.com.designtesttwo.Fragments.SettingsFragment;
import movieapplication.activity.com.designtesttwo.R;

public class SettingActivity extends AppCompatActivity implements SettingsFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        SettingsFragment mSettingsFragment = new SettingsFragment();
        getFragmentManager().beginTransaction().replace(R.id.content, mSettingsFragment).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

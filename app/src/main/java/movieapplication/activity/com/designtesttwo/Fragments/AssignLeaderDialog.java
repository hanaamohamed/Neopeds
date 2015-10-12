package movieapplication.activity.com.designtesttwo.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import movieapplication.activity.com.designtesttwo.Classes.DummyLeader;
import movieapplication.activity.com.designtesttwo.R;
import movieapplication.activity.com.designtesttwo.UI.LeaderAndCourseAdapter;


public class AssignLeaderDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View mShowLeaderLayout = inflater.inflate(R.layout.leader_list, null);
        View headerLayout = inflater.inflate(R.layout.assign_leader_list_dialog_header, null);
        View footerLayout = inflater.inflate(R.layout.assign_leader_dialog_footer, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(mShowLeaderLayout);
        ListView leaderList = (ListView) mShowLeaderLayout.findViewById(R.id.assignLeaderList);
        leaderList.addHeaderView(headerLayout);
        LeaderAndCourseAdapter leaderAdapter = new LeaderAndCourseAdapter(getActivity());
        List<DummyLeader> dummyLeaders = new ArrayList<>();
        dummyLeaders.add(new DummyLeader("leader1"));
        dummyLeaders.add(new DummyLeader("leader2"));
        dummyLeaders.add(new DummyLeader("leader3"));
        dummyLeaders.add(new DummyLeader("leader4"));
        leaderAdapter.addDummyLeaders(dummyLeaders);
        leaderList.setAdapter(leaderAdapter);
        leaderList.addFooterView(footerLayout);
        leaderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DummyLeader leader = (DummyLeader) parent.getItemAtPosition(position);
                //((CallBackAssignLEader) getActivity()).onItemClicked(leader);
            }
        });

        ImageButton addLeaderBt = (ImageButton) footerLayout.findViewById(R.id.addLeaderBt);
        addLeaderBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }

        });


        return builder.create();
    }

    public interface CallBackAssignLEader {
        public void onItemClicked(DummyLeader leader);
        public void addNewLeader();
    }
}

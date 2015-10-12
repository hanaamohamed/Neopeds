package movieapplication.activity.com.designtesttwo.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import movieapplication.activity.com.designtesttwo.Classes.DummyCourse;
import movieapplication.activity.com.designtesttwo.Classes.DummyLeader;
import movieapplication.activity.com.designtesttwo.R;


public class LeaderAndCourseAdapter extends BaseAdapter {

    private static final int COURSE_TYPE = 0;
    private static final int LEADER_TYPE = 1;
    private static final int COUNT_TYPES = 2;

    List<Object> mObjects;
    Context mContext;

    public LeaderAndCourseAdapter(Context mContext) {
        this.mContext = mContext;
        mObjects = new ArrayList<>();
    }

    public void addDummyLeaders(List<DummyLeader> dummyLeaders){
        mObjects.addAll(dummyLeaders);
    }

    public void addDummyCourses(List<DummyCourse> dummyCourses){
       mObjects.addAll(dummyCourses);

    }


    @Override
    public int getViewTypeCount() {
        return COUNT_TYPES;
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public Object getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position) instanceof DummyCourse ? COURSE_TYPE : LEADER_TYPE;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        int itemType = getItemViewType(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            int layoutId = -1;
            switch (itemType) {
                case COURSE_TYPE:
                    layoutId = R.layout.course_item_oth;
                    break;
                case LEADER_TYPE:
                    layoutId = R.layout.leader_item;
                    break;
                default:
                    break;
            }
            convertView = inflater.inflate(layoutId, parent, false);
            mViewHolder = new ViewHolder();
            if (itemType == COURSE_TYPE) {
                mViewHolder.tv = (TextView) convertView.findViewById(R.id.courseTv);
                mViewHolder.iv = (ImageView) convertView.findViewById(R.id.courseIcon);
            }
            if (itemType == LEADER_TYPE)
                mViewHolder.tv = (TextView) convertView.findViewById(R.id.leaderTV);
            convertView.setTag(mViewHolder);
        } else
            mViewHolder = (ViewHolder) convertView.getTag();
        switch (itemType) {
            case COURSE_TYPE:
                DummyCourse course  = (DummyCourse) mObjects.get(position);
                mViewHolder.tv.setText(course.getCourseName());
                mViewHolder.iv.setImageResource(course.getCoruseIcon());
                break;
            case LEADER_TYPE:
                DummyLeader leader = (DummyLeader) mObjects.get(position);
                mViewHolder.tv.setText(leader.getLeaderName());
                break;
            default:
                break;
        }

        return convertView;
    }

    private class ViewHolder {
        TextView tv;
        ImageView iv;

    }
}

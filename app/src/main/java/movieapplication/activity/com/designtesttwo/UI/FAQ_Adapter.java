package movieapplication.activity.com.designtesttwo.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import movieapplication.activity.com.designtesttwo.Classes.DummyQuestion;
import movieapplication.activity.com.designtesttwo.Classes.DummyReviews;
import movieapplication.activity.com.designtesttwo.Classes.DummyUser;
import movieapplication.activity.com.designtesttwo.R;


public class FAQ_Adapter extends BaseAdapter {

    Context mContext;
    List<DummyQuestion> questionList;
    DummyUser mUser;
    private static final int mRegular_type = 0;
    private static final int mFAQ_Type = 1;
    private static final int mTypeCounts = 2;

    public FAQ_Adapter(Context mContext, List<DummyQuestion> questionList, DummyUser user) {
        this.mContext = mContext;
        this.questionList = questionList;
        mUser = user;
    }

    @Override
    public int getCount() {
        return questionList.size();
    }

    @Override
    public DummyQuestion getItem(int position) {
        return questionList.get(position);
    }

    @Override
    public int getViewTypeCount() {
        return mTypeCounts;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getPriority();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        int itemType = getItemViewType(position);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            switch (itemType) {
                case mFAQ_Type:
                    convertView = inflater.inflate(R.layout.faq_item, parent, false);
                    mViewHolder.author = (TextView) convertView.findViewById(R.id.author);
                    mViewHolder.question = (TextView) convertView.findViewById(R.id.question);
                    mViewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
                    mViewHolder.edit = (ImageButton) convertView.findViewById(R.id.edit);
                    mViewHolder.pin = (ImageButton) convertView.findViewById(R.id.pin);
                    break;
                default:
                    break;
            }
            convertView.setTag(mViewHolder);

        } else mViewHolder = (ViewHolder) convertView.getTag();
        switch (itemType) {
            case mFAQ_Type:
                DummyQuestion question = (DummyQuestion) questionList.get(position);
                mViewHolder.question.setText(question.getQuestion());
                mViewHolder.author.setText(mUser.getUserName());
                mViewHolder.avatar.setImageResource(mUser.getAvatar());
                break;
            default:
                break;
        }
        return convertView;

    }

    private class ViewHolder {
        TextView question, author;
        ImageButton edit, pin;
        ImageView avatar;

    }

}

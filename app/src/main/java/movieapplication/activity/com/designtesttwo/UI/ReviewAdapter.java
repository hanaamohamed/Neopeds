package movieapplication.activity.com.designtesttwo.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import movieapplication.activity.com.designtesttwo.Classes.DummyCourse;
import movieapplication.activity.com.designtesttwo.Classes.DummyReviews;
import movieapplication.activity.com.designtesttwo.R;

public class ReviewAdapter extends BaseAdapter {

    List<DummyReviews> mObject;
    Context mContext;
    private static final int ReviewType = 0;
    private static final int SectionType = 1;
    private static final int COUNT = 2;


    public ReviewAdapter(Context mContext, List<DummyReviews> mObject) {
        this.mContext = mContext;
        this.mObject = mObject;
    }

    @Override
    public int getCount() {
        return mObject.size();
    }

    public void AddAllObjects(List<DummyReviews> reviews) {
        mObject.addAll(reviews);
    }

    @Override
    public Object getItem(int position) {
        return mObject.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof DummyReviews)
            return ReviewType;
        else
            return 1;
    }

    @Override
    public int getViewTypeCount() {
        return COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        int itemType = getItemViewType(position);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            switch (itemType) {
                case ReviewType:
                    convertView = inflater.inflate(R.layout.review_item, parent, false);
                    mViewHolder.review = (TextView) convertView.findViewById(R.id.reviewTv);
                    mViewHolder.author = (TextView) convertView.findViewById(R.id.authorTv);
                    mViewHolder.iv = (ImageView) convertView.findViewById(R.id.avatar);
                    break;
                default:
                    break;
            }
            convertView.setTag(mViewHolder);

        } else mViewHolder = (ViewHolder) convertView.getTag();
        switch (itemType) {
            case ReviewType:
                DummyReviews review = (DummyReviews) mObject.get(position);
                mViewHolder.review.setText(review.getReview());
                mViewHolder.author.setText(review.getAuthor());
                mViewHolder.iv.setImageResource(review.getAvatar());
                break;
            default:
                break;
        }
        return convertView;

    }

    private class ViewHolder {
        TextView review, author;
        ImageView iv;

    }
}

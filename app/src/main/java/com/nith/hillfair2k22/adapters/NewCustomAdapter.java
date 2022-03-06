package com.nith.hillfair2k22.adapters;




import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.nith.hillfair2k22.R;
import com.nith.hillfair2k22.screens.home.CommentUserFeedFragment;
import com.nith.hillfair2k22.screens.home.Contact;
import com.nith.hillfair2k22.screens.home.UserComments;

public class NewCustomAdapter extends RecyclerView.Adapter<NewCustomAdapter.ViewHolder> {

    private UserComments[] localDataSet;
//    private TextView user_feed_name;
//    private TextView user_feed_caption_goes_here;
//    private ImageView imageview2;
    private TextView username;
    private  TextView comments;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public NewCustomAdapter(UserComments[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_comment_user_feed, viewGroup, false);
//        user_feed_name=view.findViewById(R.id.user_feed_name);
//        user_feed_caption_goes_here=view.findViewById(R.id.user_feed_caption_goes_here);
//        imageview2=view.findViewById(R.id.user_feed_message_icon);
//        imageview2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(view.getContext(), CommentUserFeedFragment.class);
//                view.getContext().startActivity(intent);
//            }
//        });
        username=view.findViewById(R.id.user_comment_user_name_in_comment);
        comments=view.findViewById(R.id.user_comment_comment_in_comment_section);


        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {



        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        user_feed_name.setText(localDataSet[position].name);
//        user_feed_caption_goes_here.setText(localDataSet[position].caption);
        username.setText(localDataSet[position].username);
        comments.setText(localDataSet[position].comments);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}

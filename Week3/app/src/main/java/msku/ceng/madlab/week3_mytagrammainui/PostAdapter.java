package msku.ceng.madlab.week3_mytagrammainui;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    List<Post> posts;
    private LayoutInflater inflater;

    public PostAdapter(Activity activity, List<Post> posts){
        this.posts = posts;
        inflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row, parent, false);
            holder = new ViewHolder();
            holder.txtMessage = convertView.findViewById(R.id.msg);
            holder.txtLocation = convertView.findViewById(R.id.location);
            holder.imageView = convertView.findViewById(R.id.postImage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Post post = posts.get(position);
        holder.txtMessage.setText(post.getMessage());
        holder.imageView.setImageBitmap(post.getImage());
        if (post.getLocation() != null) {
            holder.txtLocation.setText(
                    post.getLocation().getLatitude() + " " + post.getLocation().getLongitude()
            );
        } else {
            holder.txtLocation.setText("");
        }

        return convertView;
    }

    static class ViewHolder {
        TextView txtMessage;
        TextView txtLocation;
        ImageView imageView;
    }

}

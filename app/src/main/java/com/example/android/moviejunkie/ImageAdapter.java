package com.example.android.moviejunkie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by UD on 04-06-2016.
 */
public class ImageAdapter extends ArrayAdapter<String>{

    private final String BASE_URL = "http://image.tmdb.org/t/p/w185";
   private Context mContext;
    private int mResource;
    private int mFieldId=0;
    private List<String> mObjects;

    public ImageAdapter(Context context, int layoutResource, int resourceId, List<String> objects){
        super(context, layoutResource, resourceId, objects);
        mContext = context;
        mResource = layoutResource;
        mFieldId = resourceId;
        mObjects = objects;
    }


    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(mFieldId);
            convertView.setTag(holder);
        }else {
            // Get the ViewHolder back to get fast access to ImageView.
            holder = (ViewHolder) convertView.getTag();

        }

        String url_full = BASE_URL + getItem(position);
//        while (getItem(position) .equals ("")){
//            //empty to ensure that the view gets updated only when the url is available
//        }

        Picasso.with(mContext)
                .load(url_full)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.image);
        return convertView;
    }

   private static class ViewHolder {
        ImageView image;
    }


    // references to our images
//    public static String[] mThumIds = {
//            "http://i.imgur.com/rFLNqWI.jpg",
//            "http://i.imgur.com/C9pBVt7.jpg",
//            "http://i.imgur.com/rT5vXE1.jpg",
//            "http://i.imgur.com/aIy5R2k.jpg",
//            "http://i.imgur.com/MoJs9pT.jpg",
//            "http://i.imgur.com/S963yEM.jpg",
//            "http://i.imgur.com/rLR2cyc.jpg",
//            "http://i.imgur.com/SEPdUIx.jpg",
//            "http://i.imgur.com/aC9OjaM.jpg",
//            "http://i.imgur.com/76Jfv9b.jpg",
//            "http://i.imgur.com/fUX7EIB.jpg",
//            "http://i.imgur.com/syELajx.jpg",
//            "http://i.imgur.com/COzBnru.jpg",
//            "http://i.imgur.com/Z3QjilA.jpg",
//    };

}

package co.topnews.news_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import co.topnews.R;

public class NewsListItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView newsImage;
    private TextView newsTitle;
    private TextView newsDescription;
    private TextView publishedAt;

    public NewsListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        newsImage = itemView.findViewById(R.id.news_image);
        newsTitle = itemView.findViewById(R.id.title);
        newsDescription = itemView.findViewById(R.id.description);
        publishedAt = itemView.findViewById(R.id.published_at);
    }


    public ImageView getNewsImage() {
        return newsImage;
    }

    public TextView getNewsTitle() {
        return newsTitle;
    }

    public TextView getNewsDescription() {
        return newsDescription;
    }

    public TextView getPublishedAt() {
        return publishedAt;
    }
}

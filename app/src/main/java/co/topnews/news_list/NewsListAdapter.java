package co.topnews.news_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import co.topnews.R;
import co.topnews.news_list.models.NewsItem;

public class NewsListAdapter extends RecyclerView.Adapter {

    private final Context context;
    private static final int NEWS_ITEM = 1;
    private static final int LOADING_MORE = 2;
    List<NewsItem> newsItemList;

    public NewsListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (getItemViewType(i)) {
            case 1:
                return new NewsListItemViewHolder(LayoutInflater.from(context).inflate(R.layout.new_list_item, viewGroup));
            default:
                throw new IllegalArgumentException("View type not supported");

        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof NewsListItemViewHolder) {
            final NewsItem newsItem = newsItemList.get(i);
            ((NewsListItemViewHolder) viewHolder).getNewsTitle().setText(newsItem.getTitle());
            ((NewsListItemViewHolder) viewHolder).getNewsDescription().setText(newsItem.getDescription());
        }

    }

    public void setData(List<NewsItem> newsItems) {
        if (newsItemList == null) {
            newsItemList = new ArrayList<>();

        } else {
            newsItemList.clear();
        }

        newsItemList.addAll(newsItems);
        notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        if (newsItemList == null)
            return 0;
        return newsItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return NEWS_ITEM;
    }
}

package co.topnews.news_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import co.topnews.R;

public class ProgressbarViewHolder extends RecyclerView.ViewHolder {
    private ProgressBar progressBar;
    public ProgressbarViewHolder(@NonNull View itemView) {
        super(itemView);
        progressBar = itemView.findViewById(R.id.progress_bar);
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }
}

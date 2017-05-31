package me.rizqy.amikomdispatch.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.rizqy.amikomdispatch.R;
import me.rizqy.amikomdispatch.ViewNewsActivity;
import me.rizqy.amikomdispatch.models.NewsItem;

/**
 * Created by Rizqy on 05/05/2017.
 */

public class NewsAdapter extends ArrayAdapter<NewsItem> {
    Context context;
    LayoutInflater inflater;

    static class ViewHolder {
        @BindView(R.id.tv_title) TextView title;
        @BindView(R.id.cv_news) CardView newsBody;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public NewsAdapter(Context context, ArrayList<NewsItem> news) {
        super(context, R.layout.news_list_item, news);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        final NewsItem news = getItem(position);
        ViewHolder holder;

        if (view == null) {
            view = inflater.inflate(R.layout.news_list_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.title.setText(news.getTitle());

        holder.newsBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewNewsActivity.class);

                intent.putExtra("item", news);
                context.startActivity(intent);
            }
        });

        return view;
    }


}

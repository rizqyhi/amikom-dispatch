package me.rizqy.amikomdispatch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.rizqy.amikomdispatch.adapters.BookmarkAdapter;
import me.rizqy.amikomdispatch.models.BookmarkItem;

public class BookmarkedNewsFragment extends android.support.v4.app.Fragment {
    private static final String TAG = RecentNewsFragment.class.getName();

    @BindView(R.id.lv_news) ListView lvNews;
    @BindView(R.id.pb_recent_news) ProgressBar pbProgress;

    private Unbinder unbinder;
    private BookmarkAdapter adapter;

    public BookmarkedNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment_content, container, false);
        unbinder = ButterKnife.bind(this, view);

        List<BookmarkItem> items = BookmarkItem.listAll(BookmarkItem.class);
        adapter = new BookmarkAdapter(getContext(), new ArrayList<BookmarkItem>());
        adapter.addAll(items);
        lvNews.setAdapter(adapter);

        pbProgress.setVisibility(View.GONE);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

package me.rizqy.amikomdispatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.rizqy.amikomdispatch.adapters.NewsAdapter;
import me.rizqy.amikomdispatch.models.NewsItem;

public class RecentNewsFragment extends android.support.v4.app.Fragment implements ChildEventListener {
    private static final String TAG = RecentNewsFragment.class.getName();

    @BindView(R.id.lv_news) ListView lvNews;
    @BindView(R.id.pb_recent_news) ProgressBar pbProgress;

    private Unbinder unbinder;
    private NewsAdapter adapter;

    public RecentNewsFragment() {
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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("news");
        Query query = ref.orderByChild("reverseId").limitToFirst(15);

        ArrayList<NewsItem> news = new ArrayList<>();
        adapter = new NewsAdapter(getContext(), news);
        lvNews.setAdapter(adapter);

        query.addChildEventListener(this);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        NewsItem item = dataSnapshot.getValue(NewsItem.class);
        adapter.add(item);

        pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        NewsItem item = (NewsItem) parent.getItemAtPosition(position);
//        Intent intent = new Intent(getActivity(), ViewNewsActivity.class);
//
//        intent.putExtra("item", item);
//        startActivity(intent);
//    }
}

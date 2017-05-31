package me.rizqy.amikomdispatch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.rizqy.amikomdispatch.models.BookmarkItem;

public class ViewBookmarkActivity extends AppCompatActivity {
    BookmarkItem item;

    @BindView(R.id.title) TextView tvTitle;
    @BindView(R.id.contentWebView) WebView wvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras() != null) {
            item = (BookmarkItem) getIntent().getSerializableExtra("item");

            if (item != null) {
//                getSupportActionBar().setTitle(item.getTitle());
                tvTitle.setText(item.getTitle());

                fetchContent();
            }
        }
    }

    protected void fetchContent() {
        final Activity activity = this;

        wvContent.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

                return true;
            }
        });

        wvContent.loadUrl("http://amikom-dispatch.rizqy.me/content/"+item.getOriId().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_single_news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_bookmark:
                bookmarkItem();
                Toast.makeText(this, "Info berhasil dibookmark.", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_share:
                shareItem();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void bookmarkItem() {
//        Long timestamp = System.currentTimeMillis()/1000;
//        BookmarkItem bookmarkedItem = new BookmarkItem(item.getId(), item.getHash(), item.getTitle(), item.getUrl(), item.getDate(), timestamp);
//        bookmarkedItem.save();
    }

    private void shareItem() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, this.item.getTitle());
        shareIntent.putExtra(Intent.EXTRA_TEXT, this.item.getUrl());
        startActivity(Intent.createChooser(shareIntent, "Bagikan..."));
    }
}

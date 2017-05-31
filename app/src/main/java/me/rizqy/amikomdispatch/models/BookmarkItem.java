package me.rizqy.amikomdispatch.models;

import com.orm.SugarRecord;

import java.sql.Date;

/**
 * Created by Rizqy on 29/05/2017.
 */

public class BookmarkItem extends SugarRecord {
    private Integer id;
    private String hash;
    private String title;
    private String url;
    private String date;
    private Date bookmarked_at;

    public BookmarkItem() {
    }

    public BookmarkItem(Integer id, String hash, String title, String url, String date, Date bookmarked_at) {
        this.id = id;
        this.hash = hash;
        this.title = title;
        this.url = url;
        this.date = date;
        this.bookmarked_at = bookmarked_at;
    }
}

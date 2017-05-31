package me.rizqy.amikomdispatch.models;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Rizqy on 29/05/2017.
 */

public class BookmarkItem extends SugarRecord implements Serializable {
    private Integer oriId;
    private String hash;
    private String title;
    private String url;
    private String date;
    private Long bookmarked_at;

    public BookmarkItem() {
    }

    public BookmarkItem(Integer oriId, String hash, String title, String url, String date, Long bookmarked_at) {
        this.oriId = oriId;
        this.hash = hash;
        this.title = title;
        this.url = url;
        this.date = date;
        this.bookmarked_at = bookmarked_at;
    }

    public Integer getOriId() {
        return oriId;
    }

    public String getHash() {
        return hash;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }

    public Long getBookmarked_at() {
        return bookmarked_at;
    }

    @Override
    public String toString() {
        return title;
    }
}

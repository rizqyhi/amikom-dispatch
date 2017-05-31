package me.rizqy.amikomdispatch.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rizqy on 05/05/2017.
 */

public class NewsItem implements Serializable {
    private Integer reverseId;
    private Integer id;
    private String hash;
    private String title;
    private String url;
    private String date;

    public NewsItem(Integer reverseId, String hash, String title, String url, String date) {
        this.reverseId = reverseId;
        this.hash = hash;
        this.title = title;
        this.url = url;
        this.date = date;
    }

    public NewsItem() {
    }

    public Integer getReverseId() {
        return reverseId;
    }

    public void setReverseId(Integer reverseId) {
        this.reverseId = reverseId;
    }

    public Integer getId() {
        return Math.abs(reverseId);
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return title;
    }
}

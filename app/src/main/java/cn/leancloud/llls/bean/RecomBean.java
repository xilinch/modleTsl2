package cn.leancloud.llls.bean;

import java.io.Serializable;

/**
 * describe 该类主要完成以下功能
 */

public class RecomBean implements Serializable{

    private int id;

    private String icon;

    private String text;

    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RecomBean{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

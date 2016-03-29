package com.school.cbis.data;

import org.apache.log4j.Logger;

/**
 * Created by lenovo on 2016-02-15.
 * 自动完成数据
 */
public class AutoCompleteData {

    private static Logger logger = Logger.getLogger(AutoCompleteData.class);

    private String value;//值
    private String title;//标题
    private String url;//网址
    private String text;//描述

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AutoCompleteData{" +
                "value='" + value + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

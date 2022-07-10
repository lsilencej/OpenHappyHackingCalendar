package com.lsilencej.openhappyhackingcalendar.model;

import java.io.Serializable;

public class Wiki implements Serializable {

    private String lang;
    private String code;
    private String descWiki;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescWiki() {
        return descWiki;
    }

    public void setDescWiki(String descWiki) {
        this.descWiki = descWiki;
    }

    @Override
    public String toString() {
        return "Wiki{" +
                "lang='" + lang + '\'' +
                ", code='" + code + '\'' +
                ", descWiki='" + descWiki + '\'' +
                '}';
    }
}

package com.example.kontest.database;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DataBaseModel {
    public String id;
    public String name;
    public String url;
    public String start_time;
    public String end_time;
    public String duration;
    public String site;
    public String in_24_hours;
    public String status;

    public DataBaseModel(String id, String name, String url, String start_time, String end_time, String duration, String site, String in_24_hours, String status) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.start_time = start_time;
        this.end_time = end_time;
        this.duration = duration;
        this.site = site;
        this.in_24_hours = in_24_hours;
        this.status = status;
    }
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getStart_time() {
//        return start_time;
//    }
//
//    public void setStart_time(String start_time) {
//        this.start_time = start_time;
//    }
//
//    public String getEnd_time() {
//        return end_time;
//    }
//
//    public void setEnd_time(String end_time) {
//        this.end_time = end_time;
//    }
//
//    public String getDuration() {
//        return duration;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }
//
//    public String getSite() {
//        return site;
//    }
//
//    public void setSite(String site) {
//        this.site = site;
//    }
//
//    public String getIn_24_hours() {
//        return in_24_hours;
//    }
//
//    public void setIn_24_hours(String in_24_hours) {
//        this.in_24_hours = in_24_hours;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
}

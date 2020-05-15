/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDate;

public class Seminar {

    private Integer seminarID;
    private String topic;
    private String title;
    private String abstracts;
    private String location;
    private String modality;
    private String date;
    private String displayName;

    public Seminar(Integer seminarID, String topic, String title, String abstracts, String location, String modality, String date, String displayName) {
        this.seminarID = seminarID;
        this.topic = topic;
        this.title = title;
        this.abstracts = abstracts;
        this.location = location;
        this.modality = modality;
        this.date = date;
        this.displayName = displayName;
    }

    public Seminar(String topic, String title, String abstracts, String location, String modality, String date, String displayName) {
        this.topic = topic;
        this.title = title;
        this.abstracts = abstracts;
        this.location = location;
        this.modality = modality;
        this.date = date;
        this.displayName = displayName;
    }

    public Seminar() {
    }
    
    
    

    //Getters
    public Integer getSeminarID() {
        return seminarID;
    }

    public String getTopic() {
        return topic;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public String getLocation() {
        return location;
    }

    public String getModality() {
        return modality;
    }

    public String getDate() {
        return date;
    }

    public String getDisplayName() {
        return displayName;
    }

    //Setters
    public void setSeminarID(Integer seminarID) {
        this.seminarID = seminarID;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "Seminar{" + "seminarID=" + seminarID + ", topic=" + topic + ", title=" + title + ", abstracts=" + abstracts + ", location=" + location + ", modality=" + modality + ", date=" + date + ", displayName=" + displayName + '}';
    }
}

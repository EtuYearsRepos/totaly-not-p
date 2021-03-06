package fr.univ_smb.isc.m1.totaly_not_p.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;

public class ComicDTO {
    private Long id;
    private String title;
    private String publisher;
    private String writer;
    private String artist;
    private String publicationDate;
    private String status;
    private String summary;
    private Integer subNb;
    private ArrayList<String> issues;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWriter() {
        return writer;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setIssues(List<String> list) {
        this.issues = (ArrayList<String>) list;
    }

    public ArrayList<String> getIssues() {
        return issues;
    }

    public Integer getSubNb() {
        return subNb;
    }

    public void setSubNb(Integer subNb) {
        this.subNb = subNb;
    } 
}

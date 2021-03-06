package fr.univ_smb.isc.m1.totaly_not_p.infrastructure.persistence;

import javax.persistence.*;

import fr.univ_smb.isc.m1.totaly_not_p.infrastructure.persistence.user.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

@Entity
//@Transactional
public class Comic implements Serializable {

    private static final long serialVersionUID = -905369955137519862L;

    @Id
    @Column(name="comic_id")
    private Long id = System.nanoTime();

    private String title;
    private String publisher;
    private String writer;
    private String artist;
    private String publicationDate;
    private String status;

    private String summary;
    @Basic 
    private ArrayList<String> issues = new ArrayList<>();
    private Integer subNb = 0;
    
    @ManyToMany(mappedBy="subscriptions", fetch = FetchType.EAGER)
    private HashSet<User> subscribers = new HashSet<>();
    

    public Comic() {
        // JPA
    }

    public Comic(String title, String publisher, String writer, String artist, String publicationDate, String status, String summary) {
        this.title = title;
        this.publisher = publisher;
        this.writer = writer;
        this.artist = artist;
        this.publicationDate = publicationDate;
        this.status = status;
        this.summary = summary;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Id
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setIssues(ArrayList<String> issues) {
        this.issues = issues;
    }

    public ArrayList<String> getIssues() {
        return issues;
    }

    public Integer getSubNb() {
        return subNb;
    }

    //Shouldn't be used
    public void setSubNb(Integer subNb) {
        this.subNb = subNb;
    } 

    
    public HashSet<User> getSubscribers() {
        return subscribers;
    }
    public void setSubscribers(HashSet<User> subscribers) {
        this.subscribers = subscribers;
    }

    public void addSubscriber(User user) {
        this.subscribers.add(user);
    }

    public void removeSubscriber(User user) {
        this.subscribers.remove(user);
    }
    
    public void removeSubscribers() {
        for (User u : this.subscribers) {
            this.removeSubscriber(u);
        }
    }

    public String toString() {        
        return id + " : " + title + " by " + publisher;
    }
}
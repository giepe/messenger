package com.github.giepe.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Piotrek on 22.06.15.
 */

@XmlRootElement
public class Message {
    private long id;
    private String message;
    private Date createdDate;
    private String author;

    public Message(){
    }

    public Message(long id, String message, String author, Date createdDate) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}

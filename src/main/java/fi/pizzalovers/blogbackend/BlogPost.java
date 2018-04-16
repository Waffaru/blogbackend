package fi.pizzalovers.blogbackend;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blogpost")
public class BlogPost {
    @Id
    @GeneratedValue
    long id;
    @Column(name = "title")
    String title;
    @Column(name = "body",columnDefinition="CLOB")
    String body;
    @Column(name = "username")
    String username;
    @Column(name ="date")
    Date date;


    public BlogPost() {
        setDate(new Date());

    }

    public BlogPost(String title, String body,String user) {
        this.title = title;
        this.body = body;
        this.date = new Date();
        this.username = user;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }
}

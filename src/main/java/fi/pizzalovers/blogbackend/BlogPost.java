package fi.pizzalovers.blogbackend;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blogpost")
public class BlogPost {
    @Id
    @GeneratedValue
    int id;
    @Column(name = "title")
    String title;
    @Column(name = "body")
    String body;
    @Column(name = "username")
    String username;
    @Column(name ="date")
    Date date;

    public BlogPost() {

    }

    public BlogPost(String title, String body,String user) {
        this.title = title;
        this.body = body;
        this.date = new Date();
        this.username = user;
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

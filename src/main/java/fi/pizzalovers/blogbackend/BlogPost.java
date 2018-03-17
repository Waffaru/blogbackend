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
    @Column(name ="date")
    Date date;
    @Column(name ="user")
    String user;


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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

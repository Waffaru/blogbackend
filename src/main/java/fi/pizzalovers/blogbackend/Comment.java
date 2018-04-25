package fi.pizzalovers.blogbackend;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue
    long id;
    @Column(name = "body")
    String body;
    @Column(name = "username")
    String username;
    @Column(name = "date")
    Date date;
    @Column(name = "blogPostId")
    Long blogPostId;
    @Column(name = "dislikes")
    long dislikes;

    public Comment(String body, String username, Long blogPostId) {
        setBody(body);
        setUsername(username);
        setBlogPostId(blogPostId);
        this.date = new Date();
        this.dislikes = 0;
    }
    public Comment(){
        this.date = new Date();
        this.dislikes = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username.length() == 0){
            this.username = "Anonymous";
        }else {
            this.username = username;
        }

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getBlogPostId() {
        return blogPostId;
    }

    public void setBlogPostId(Long blogPostId) {
        this.blogPostId = blogPostId;
    }
    public long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }
}

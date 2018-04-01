package fi.pizzalovers.blogbackend;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="Comments")
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
    @Column(name = "blogpostId")
    String blogpostId;

}

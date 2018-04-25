package fi.pizzalovers.blogbackend;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(name = "username")
    String username;
    @Column(name = "password")
    String password;
    @Column(name = "rights")
    Boolean adminRights;

    public User(String username, String password) throws NoSuchProviderException, NoSuchAlgorithmException {
        setUsername(username);
        setPassword(password);
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) throws NoSuchProviderException, NoSuchAlgorithmException {
        //this.password = password;
        this.password = getSecurePassword(password);
    }
    private String getSecurePassword(String passwordToHash)
    {
        String generatedPassword = this.username + ":" + passwordToHash;
        String encoded = Base64.encode(generatedPassword.getBytes());
        System.out.println(encoded);
        return encoded;
    }

    public boolean logIn(String loginInfo) throws Base64DecodingException {

            if(password.equals(loginInfo)){
                return true;
            }
        return false;
    }
}

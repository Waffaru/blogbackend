package fi.pizzalovers.blogbackend;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
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
        this.password = password;
        //this.password = getSecurePassword(password,saltIt());
    }
    private String getSecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes
            byte[] bytes = md.digest(passwordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            String tmp = Base64.encode(salt);
            generatedPassword = sb.toString() + "$" + tmp;
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private byte[] saltIt() throws NoSuchAlgorithmException, NoSuchProviderException {
        SecureRandom tmp = SecureRandom.getInstance("SHA1PRNG","SUN");
        byte[] salt = new byte[16];
        tmp.nextBytes(salt);
        return salt;
    }
    public boolean logIn(String username,String password) throws Base64DecodingException {
        System.out.println(password);
            if(username.equals(this.username)){
                String userPassword = password;
                String []tmp = userPassword.split("\\$");
                String tmpPassword = getSecurePassword(password,Base64.decode(tmp[1]));
                System.out.println(tmpPassword);
                return tmpPassword.equals(password);
            }
        return false;
    }
}

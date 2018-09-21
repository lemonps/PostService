package com.sit.cloudnative.PostService.Post;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sit.cloudnative.PostService.User.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    /*@Temporal(TemporalType.DATE)
    private Date dateOfPost;
    */

    public Post() {
        super();
    }

    public Post(long id, String title, String description/* Date dateOfPost*/, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
    }

    /**
     * @return the dateOfPost
     */
   /* public Date getDateOfPost() {
        return dateOfPost;
    }

    /**
     * @param dateOfPost the dateOfPost to set
     */
    /*public void setDateOfPost(Date dateOfPost) {
        this.dateOfPost = dateOfPost;
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    public String toString(){
        return "post_id: "+ this.id + "title: "+ this.title + "description: "+ this.description + "user: "+ this.user;
    }

}
package com.sit.cloudnative.PostService.Comment;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sit.cloudnative.PostService.Post.Post;
import com.sit.cloudnative.PostService.User.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "comments")
public class Comment {

    public Comment(){
        super();
    }

    public Comment(Long id, String commentDetail, Post post, User user){
        this.id = id;
        this.commentDetail = commentDetail;
       /* this.dateOfComment = dateOfComment;*/
        this.post = post;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

   /* @Temporal(TemporalType.DATE)
    private Date dateOfComment;

        public Date getDateOfComment() {
            return dateOfComment;
        }

        public void setDateOfComment(Date dateOfComment) {
            this.dateOfComment = dateOfComment;
        }
    */

    @NotBlank
    private String commentDetail;

        public String getCommentDetail() {
            return commentDetail;
        }

        public void setCommentDetail(String commentDetail) {
            this.commentDetail = commentDetail;
        }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnore
    private Post post;

        public void setPost(Post post) {
            this.post = post;
        }

        public void setUser(User user) {
            this.user = user;
        }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

        public User getUser() {
            return user;
        }

        public Post getPost() {
            return post;
        }

        public String toString(){
            return "comment_id: " + this.id 
                    + " commentDetail: " + this.commentDetail
                    /*+ " commentDate: " + this.dateOfComment*/
                    + " PostOfComment: " + this.post
                    + " UserOfComment: " + this.user;
        }
}
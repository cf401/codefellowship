package jack.kinne.Codefellowship.models;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Post {
    //vars
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "text")
    String body;

    @CreationTimestamp
    private Date created;

    @ManyToOne
    ApplicationUser owner;

    //constructors
    public Post(String body, ApplicationUser owner){
        this.body = body;
        this.owner = owner;
    }
    public Post(){}

    //methods
    public String toString() {
        return String.format("%s.  Created at: %s.", this.body, this.created);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public ApplicationUser getOwner() {
        return owner;
    }

    public void setOwner(ApplicationUser owner) {
        this.owner = owner;
    }
}

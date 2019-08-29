package jack.kinne.Codefellowship.models;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {
    //vars
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(unique = true)
    String username;
    String password;
    String bio;
    public String pictureURL = "https://i.imgur.com/qgQLw.jpg";

    String fullName;

    // normal, boring, one-to-many annotations
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    List<Post> posts;

    //subscribed to and subscribed by
    @ManyToMany
    @JoinTable(
            name = "subscribes",
            joinColumns = @JoinColumn(name = "subscribedTo"),
            inverseJoinColumns = @JoinColumn(name = "subscribedBy"))
    ArrayList<ApplicationUser> subscribedTo;

    @ManyToMany(mappedBy = "subscribedTo")
    ArrayList<ApplicationUser> subscribedBy;

    //constructors
    public ApplicationUser(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }
    public ApplicationUser() {}

    //methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<ApplicationUser> getSubscribedTo() {
        return subscribedTo;
    }

    public void setSubscribedTo(ArrayList<ApplicationUser> subscribedTo) {
        this.subscribedTo = subscribedTo;
    }

    public ArrayList<ApplicationUser> getSubscribedBy() {
        return subscribedBy;
    }

    public void setSubscribedBy(ArrayList<ApplicationUser> subscribedBy) {
        this.subscribedBy = subscribedBy;
    }

    public void addSubTo(ApplicationUser u){
        subscribedTo.add(u);
    }

    public void addSubBy(ApplicationUser u){
        subscribedBy.add(u);
    }

    public void removeSubTo(ApplicationUser u){
        subscribedTo.remove(u);
    }

    public void removeSubBy(ApplicationUser u){
        subscribedBy.remove(u);
    }
}

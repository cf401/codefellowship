package jack.kinne.Codefellowship.models;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {
    //vars
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    String username;
    String password;
    String bio;
    public String pictureURL = "https://i.imgur.com/qgQLw.jpg";

    String fullName;

    // normal, boring, one-to-many annotations
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    List<Post> posts;

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
}

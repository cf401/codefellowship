package jack.kinne.Codefellowship.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    public List<Post> findByOwner(ApplicationUser owner);
}
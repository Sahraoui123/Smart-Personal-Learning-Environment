package tn.esprit.pi2024.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pi2024.Entity.Comment;
@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
}

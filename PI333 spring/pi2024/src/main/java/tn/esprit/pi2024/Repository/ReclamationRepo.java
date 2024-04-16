package tn.esprit.pi2024.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pi2024.Entity.Reclamation;

@Repository
public interface ReclamationRepo extends JpaRepository<Reclamation,Long> {
}

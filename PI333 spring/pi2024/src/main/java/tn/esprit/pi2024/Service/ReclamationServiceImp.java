package tn.esprit.pi2024.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pi2024.Entity.Reclamation;
import tn.esprit.pi2024.Repository.ReclamationRepo;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReclamationServiceImp implements IReclamationService {

    private ReclamationRepo reclamationRepo;

    private BadWordDetectorService badWordDetectorService;

    public List<Reclamation> retrieveAllReclamations() {
        return reclamationRepo.findAll();
    }

    public Reclamation retrieveReclamation(Long reclamationId) {
        return reclamationRepo.findById(reclamationId).orElse(null);
    }

    public Reclamation addReclamation(Reclamation r) {
        r.setDateSubmitted(new Date());

        String filteredDescription = badWordDetectorService.filterBadWords(r.getDescription());
        r.setDescription(filteredDescription);

        String filteredReason = badWordDetectorService.filterBadWords(r.getReason());
        r.setReason(filteredReason);
        Reclamation savedReclamation = reclamationRepo.save(r);

        return savedReclamation;
    }

    public void removeReclamation(Long reclamationId) {
        reclamationRepo.deleteById(reclamationId);
    }

    public Reclamation modifyReclamation(Reclamation reclamation) {
        reclamation.setDateUpdated(new Date());
        return reclamationRepo.save(reclamation);
    }

}

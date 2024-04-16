package tn.esprit.pi2024.Service;

import tn.esprit.pi2024.Entity.Reclamation;

import java.util.List;

public interface IReclamationService {
    public List<Reclamation> retrieveAllReclamations();
    public Reclamation retrieveReclamation(Long reclamationId);
    public Reclamation addReclamation(Reclamation r);
    public void removeReclamation(Long reclamationId);
    public Reclamation modifyReclamation( Reclamation updatedReclamation);
}

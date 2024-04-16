package tn.esprit.pi2024.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pi2024.Entity.Reclamation;
import tn.esprit.pi2024.Service.IReclamationService;
import tn.esprit.pi2024.Service.IStorage;


import java.util.List;

@Tag(name = "Gestion Reclamation")
@RestController
@AllArgsConstructor
@RequestMapping("/reclamation")
public class ReclamationRestController {
    IReclamationService reclamationService;
    private final IStorage imgstorage;
    @Operation(description = "Récupérer tous les reclamations de la base de données!")
    @GetMapping("/retrieve-all-reclamations")
    public List<Reclamation> getReclamations() {
        return reclamationService.retrieveAllReclamations();
    }


    @Operation(description = "Récupérer le reclamation avec l'ID correspondante de la base de données!")
    @GetMapping("/retrieve-reclamation/{reclamation-id}")
    public Reclamation retrieveReclamation(@PathVariable("reclamation-id") Long reclamationId) {
        return reclamationService.retrieveReclamation(reclamationId);
    }


    @Operation(description = "Ajouter reclamation à la base de données!")
    @PostMapping("/add-reclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.addReclamation(reclamation);
    }
    @Operation(description = "Ajouter reclamation à la base de données!")
    @PostMapping("/add-reclamation")
    public Reclamation addReclamationWithImage(@RequestBody Reclamation reclamation) {
        return reclamationService.addReclamation(reclamation);
    }


    @Operation(description = "Enlever le reclamation avec l'ID correspondante de la base de données!")
    @DeleteMapping("/remove-reclamation/{reclamation-id}")
    public void removeReclamation(@PathVariable("reclamation-id") Long reclamationId) {
        reclamationService.removeReclamation(reclamationId);
    }


    @Operation(description = "Modifier le reclamation!")
    @PutMapping("/modify-reclamation")
    public Reclamation modifyReclamation(@RequestBody Reclamation reclamation) {

        return reclamationService.modifyReclamation(reclamation);
    }

}

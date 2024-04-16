package tn.esprit.pi2024.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long reclamationId ;
    @NotBlank
    @Size(max = 255)
    String Description ;
    @NotBlank
    @Size(max = 255)
    String Reason;
    @Enumerated(EnumType.STRING)
    Status status;
    Date dateSubmitted;
    Date dateUpdated;

    @ManyToOne
    private User user;
    @OneToOne(mappedBy = "reclamation", cascade = CascadeType.ALL)
    ImageData image;

}


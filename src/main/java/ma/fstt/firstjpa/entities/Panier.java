package ma.fstt.firstjpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "panier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateCreation;
    private Double total;
    @OneToOne
    @JoinColumn(name = "id_internaute")
    private Internaute internaute;
    @OneToMany(mappedBy = "panier",cascade = CascadeType.ALL)
    private List<LignePanier> lignesPanier;
}

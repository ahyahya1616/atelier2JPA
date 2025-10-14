package ma.fstt.firstjpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "ligne_panier")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LignePanier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantite;
    private Double sousTotal;

    @ManyToOne
    @JoinColumn(name = "id_panier")
    private Panier panier;


    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;
}
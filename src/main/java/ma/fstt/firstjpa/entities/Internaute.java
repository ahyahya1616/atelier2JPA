package ma.fstt.firstjpa.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "internaute")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String password;
    @OneToOne(mappedBy = "internaute",cascade = CascadeType.ALL)
    private Panier panier;
    @OneToMany(mappedBy = "internaute",cascade = CascadeType.ALL)
    private List<Commande> listCommandes;
}

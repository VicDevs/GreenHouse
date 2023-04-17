package br.com.fiap.GreenHouse.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ranking {
    
    @Id
    private Long id;

    @OneToMany
    private Usuario usuario;
}

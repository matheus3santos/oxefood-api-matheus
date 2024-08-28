package br.com.ifpe.oxefood.modelo.empresa;



import org.hibernate.annotations.SQLRestriction;


import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;



@Entity
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel {
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @Column
    private String site;

    @Column
    private String cnpj;
}


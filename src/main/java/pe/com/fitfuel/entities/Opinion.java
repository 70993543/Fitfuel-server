package pe.com.fitfuel.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="opiniones")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opinion_id")
    private Long opinionId;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "calificacion")
    private Integer calificacion;
    @Column(name = "fecha_hora")
    private Date fechaHora;
    @ManyToOne
    @JoinColumn(name = "nutricionista_id")
    private Nutricionista nutricionista;
}

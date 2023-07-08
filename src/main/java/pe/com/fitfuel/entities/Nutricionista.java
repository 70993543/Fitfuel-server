package pe.com.fitfuel.entities;

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
@Table(name = "nutricionistas")
public class Nutricionista {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "nutricionista_id")
     private Long nutricionistaId;
     @Column(name = "nombre")
     private String nombre;
     @Column(name = "apellido")
     private String apellido;
     @Column(name = "imagen")
     private String imagen;
     @Column(name = "video_url")
     private String videoUrl;
     @Column(name = "especialidad")
     private String especialidad;
     @Column(name = "descripcion")
     private String descripcion;
     @ManyToOne
     @JoinColumn(name = "objetivo_id")
     private Objetivo objetivo;
     @ManyToOne
     @JoinColumn(name = "precio_id")
     private Precio precio;
     
     public Nutricionista(String nombre, String apellido, String imagen, String videoUrl, String especialidad,
               String descripcion, Objetivo objetivo, Precio precio) {
          this.nombre = nombre;
          this.apellido = apellido;
          this.imagen = imagen;
          this.videoUrl = videoUrl;
          this.especialidad = especialidad;
          this.descripcion = descripcion;
          this.objetivo = objetivo;
          this.precio = precio;
     }

    public Nutricionista(String nombre, String apellido, String imagen, String videoUrl, String especialidad,
            String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.videoUrl = videoUrl;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
    }

     

    
     
}

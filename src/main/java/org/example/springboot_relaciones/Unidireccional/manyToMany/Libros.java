package org.example.springboot_relaciones.Unidireccional.manyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="uni_libros_many_to_many")
@Table(name="uni_libros_many_to_many")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "autores_libros",
            joinColumns = @JoinColumn(name = "libros_id"),
            inverseJoinColumns = @JoinColumn(name = "autores_id")
    )
    List<Autores> autores;

}

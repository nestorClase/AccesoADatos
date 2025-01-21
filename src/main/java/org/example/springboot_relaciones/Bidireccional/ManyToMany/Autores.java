package org.example.springboot_relaciones.Bidireccional.ManyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="bi_autores_many_to_many")
@Table(name="bi_autores_many_to_many")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "autores")
    private List<Libros> libros;
}

package org.example.springboot_relaciones.Unidireccional.manyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="uni_autores_many_to_many")
@Table(name="uni_autores_many_to_many")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}

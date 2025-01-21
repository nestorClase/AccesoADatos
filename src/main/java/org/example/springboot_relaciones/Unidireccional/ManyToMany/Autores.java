package org.example.springboot_relaciones.Unidireccional.ManyToMany;

import jakarta.persistence.*;

@Entity(name="uni_autores_many_to_many")
@Table(name="uni_autores_many_to_many")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}

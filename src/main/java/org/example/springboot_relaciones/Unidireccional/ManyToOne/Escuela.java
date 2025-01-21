package org.example.springboot_relaciones.Unidireccional.ManyToOne;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="uni_escuela_many_to_one")
@Table(name="uni_escuela_many_to_one")
public class Escuela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

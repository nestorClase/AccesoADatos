package org.example.springboot_relaciones.Bidireccional.ManyToOne;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="bi_escuela_many_to_one")
@Table(name="bi_escuela_many_to_one")
public class Escuela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "escuela")
    private List<Estudiante> estudiantes;
}

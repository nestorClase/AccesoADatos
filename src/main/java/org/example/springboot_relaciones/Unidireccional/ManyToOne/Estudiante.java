package org.example.springboot_relaciones.Unidireccional.ManyToOne;

import jakarta.persistence.*;

@Entity(name="uni_estudiante_many_to_one")
@Table(name="uni_estudiante_many_to_one")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "escuela_id")
    private Escuela escuela;
}

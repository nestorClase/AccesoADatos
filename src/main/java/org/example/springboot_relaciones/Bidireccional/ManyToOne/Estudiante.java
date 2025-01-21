package org.example.springboot_relaciones.Bidireccional.ManyToOne;

import jakarta.persistence.*;

@Entity(name="bi_estudiante_many_to_one")
@Table(name="bi_estudiante_many_to_one")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "escuela_id")
    private Escuela escuela;
}

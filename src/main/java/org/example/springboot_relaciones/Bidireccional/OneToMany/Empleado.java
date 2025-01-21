package org.example.springboot_relaciones.Bidireccional.OneToMany;

import jakarta.persistence.*;

@Entity(name="bi_empleado_one_to_many")
@Table(name="bi_empleado_one_to_many")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DepartamentoId")
    private Departamento departamento;
}

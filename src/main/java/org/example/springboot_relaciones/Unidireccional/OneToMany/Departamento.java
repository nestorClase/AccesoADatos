package org.example.springboot_relaciones.Unidireccional.OneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="uni_departamento_one_to_many")
@Table(name="uni_departamento_one_to_many")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "DepartamentoId")
    List<Empleado> empleados;
}

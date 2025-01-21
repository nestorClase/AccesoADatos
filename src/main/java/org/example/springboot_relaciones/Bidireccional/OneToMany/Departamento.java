package org.example.springboot_relaciones.Bidireccional.OneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="bi_departamento_one_to_many")
@Table(name="bi_departamento_one_to_many")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "departamento")
    List<Empleado> empleados;
}

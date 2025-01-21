package org.example.springboot_relaciones.Unidireccional.OneToMany;

import jakarta.persistence.*;

@Entity(name="uni_empleado_one_to_many")
@Table(name="uni_empleado_one_to_many")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}

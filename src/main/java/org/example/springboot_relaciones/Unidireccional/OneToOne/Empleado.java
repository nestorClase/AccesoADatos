package org.example.springboot_relaciones.Unidireccional.OneToOne;

import jakarta.persistence.*;

@Entity(name="uni_empleado_one_to_one")
@Table(name="uni_empleado_one_to_one")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "parkingId")
    private Parking parking;

}

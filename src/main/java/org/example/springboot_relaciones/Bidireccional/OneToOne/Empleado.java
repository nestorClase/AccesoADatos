package org.example.springboot_relaciones.Bidireccional.OneToOne;

import jakarta.persistence.*;

@Entity(name="bi_empleado_one_to_one")
@Table(name="bi_empleado_one_to_one")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "parkingId")
    private Parking parking;

}

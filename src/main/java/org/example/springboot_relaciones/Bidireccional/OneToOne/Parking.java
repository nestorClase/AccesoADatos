package org.example.springboot_relaciones.Bidireccional.OneToOne;

import jakarta.persistence.*;

@Entity(name="bi_parking_one_to_one")
@Table(name="bi_parking_one_to_one")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "parking")
    private Empleado empleado;
}

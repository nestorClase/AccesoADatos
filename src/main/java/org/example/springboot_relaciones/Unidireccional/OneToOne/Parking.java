package org.example.springboot_relaciones.Unidireccional.OneToOne;

import jakarta.persistence.*;

@Entity(name="uni_parking_one_to_one")
@Table(name="uni_parking_one_to_one")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}

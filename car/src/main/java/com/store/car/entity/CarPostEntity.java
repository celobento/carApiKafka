package com.store.car.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "car_post")
@Data
@NoArgsConstructor
public class CarPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "engine_version")
    private String engineVersion;

    @Column(name = "city")
    private String city;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_type")
    private String ownerType;

    @Column(name = "contact")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPostEntity ounerPost;

}

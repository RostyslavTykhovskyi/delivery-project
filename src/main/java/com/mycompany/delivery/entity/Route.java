package com.mycompany.delivery.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name="route", schema = "public")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_seq_gen")
    @SequenceGenerator(name = "route_seq_gen", sequenceName = "route_id_seq")
    @Column(name = "route_id", nullable = false)
    private long id;
    @Column(name = "start_point", nullable = false)
    private String startPoint;
    @Column(name = "end_point", nullable = false)
    private String endPoint;
    @Column(name = "length", nullable = false)
    private int length;
    @OneToMany(
            mappedBy = "route",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders = new ArrayList<>();
}
package com.andersen.onlinestore.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    private String id;
    private String name;
    private String surname;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    @OneToMany
    @JoinTable(
            name = "clients_orders",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;
    private Boolean visible;
}

package org.example3;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.List;

@Data
@ToString(exclude = "customer")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", unique = true, nullable = false)
    private Long Id;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "address")
    private String  address;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "address",cascade = CascadeType.ALL)
    private Customer customer;
}

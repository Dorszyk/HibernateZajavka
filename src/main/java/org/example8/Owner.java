package org.example8;

import jakarta.persistence.*;

import jakarta.persistence.NamedQuery;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.util.Set;

@Setter
@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner")
@NamedQueries(
        {
                @NamedQuery(
                        name = "Owner.findAll",
                        query = "FROM Owner"
                ),
                @NamedQuery(
                        name = "Owner.findOwnerByEmail",
                        query = "FROM Owner WHERE email = :email"
                )
        }
)
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", cascade = CascadeType.ALL)
    @Fetch(value = org.hibernate.annotations.FetchMode.JOIN)
    private Set<Pet> pets;

}

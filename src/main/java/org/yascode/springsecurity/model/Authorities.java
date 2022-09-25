package org.yascode.springsecurity.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority_name")
    private String authorityName;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

}

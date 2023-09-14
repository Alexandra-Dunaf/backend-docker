package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "role_data", schema = "todolist", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users;

    @Override
    public String toString() {
        return name;
    }
}

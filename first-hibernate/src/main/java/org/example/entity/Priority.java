package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "priority", schema = "todolist", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Priority {

    private String title;
    private String color;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Override
    public String toString() {
        return title;
    }
}

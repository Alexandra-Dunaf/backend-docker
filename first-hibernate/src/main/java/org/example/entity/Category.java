package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category", schema = "todolist", catalog = "postgres")
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Basic
    @Column(name = "completed_count", updatable = false)
    private Long completedCount;
    @Basic
    @Column(name = "uncompleted_count", updatable = false)
    private Long uncompletedCount;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}

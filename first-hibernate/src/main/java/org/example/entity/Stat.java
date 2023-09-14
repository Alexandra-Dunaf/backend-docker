package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stat", schema = "todolist", catalog = "postgres")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Stat { // в этой таблице всего 1 запись, которая обновляется (но никогда не удаляется)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "completed_total", updatable = false)
    private Long completedTotal;

    @Column(name = "uncompleted_total", updatable = false)
    private Long uncompletedTotal;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "activity", schema = "todolist", catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Activity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Basic
    @Convert(converter = org.hibernate.type.NumericBooleanType.class) // для автоматической конвертации числа в true/false
    private boolean activated; // становится true только после подтверждения активации пользователем (обратно false уже стать не может по логике)

    @Column(updatable = false)
    private String uuid; // создается только один раз с помощью триггера в БД

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}

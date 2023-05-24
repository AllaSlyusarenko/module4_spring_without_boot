package ru.practicum.item;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "url")
    private String url;

    @ElementCollection //указывает на связь таблиц
    @CollectionTable(name="tags", joinColumns=@JoinColumn(name="item_id")) //определено, какую именно таблицу нужно
    // использовать, по какой колонке связаны строки таблицы tags со строкой таблицы items — по item_id
    @Column(name="name") //указывает на имя колонки со значениями — сейчас это колонка из присоединяемой таблицы
    private Set<String> tags = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        return id != null && id.equals(((Item) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
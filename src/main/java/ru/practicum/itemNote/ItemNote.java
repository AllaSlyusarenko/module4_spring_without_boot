package ru.practicum.itemNote;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.practicum.item.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "item_notes")
@Getter
@Setter
@ToString
public class ItemNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "items_id")
    private Item idItem;

    @Column(name = "registration_date_notes")
    private Instant registrationDateNote = Instant.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemNote)) return false;
        ItemNote itemNote = (ItemNote) o;
        return id != null && id.equals(((ItemNote) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


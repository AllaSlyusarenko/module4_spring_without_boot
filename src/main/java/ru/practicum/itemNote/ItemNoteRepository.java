package ru.practicum.itemNote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ItemNoteRepository extends JpaRepository<ItemNote, Long> {


    List<ItemNote> findByIdUserAndUrlContaining(Long userId, String url);

    @Query("select itNote " +
            "from ItemNote as itNote " +
            "join itNote.idItem as i " +
            "join i.userId as u " +
            "where i.userId = ?1 and  ?2 member of i.tags")
    List<ItemNote> findByIdUserAndTagEquals(Long userId, String tag);
}

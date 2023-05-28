package ru.practicum.itemNote;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;


public interface ItemNoteRepository extends JpaRepository<ItemNote, Long> {


//    List<ItemNote> findByIdUserAndUrlContaining(Long userId, String url);
//
//    @Query("select itNote " +
//            "from ItemNote as itNote " +
//            "join itNote.idItem as i " +
//            "where i.userId = ?1 and  ?2 member of i.tags")
//    List<ItemNote> findByIdUserAndTagEquals(Long userId, String tag);
//
//    @Query(" select itNote " +
//            "from ItemNote as itNote" +
//            "JOIN FETCH itNote.idItem as i" +
//            "where i.userId = ?1  limit ?2 PageRequest.of(from > 0 ? from / size : 0, size)")
//     // JOIN FETCH гарантирует немедленную выборку
//    List<ItemNote> findAllWithAuthorsAndPage(Long userId,  int from, int size);

    List<ItemNote> findAllByItemUrlContainingAndItemUserId(String itemUrl, Long userId);

    @Query("select itNote " +
            "from ItemNote as itNote " +
            "join itNote.item as i " +
            "where i.user.id = ?1" +
            "  and ?2 member of i.tags")
    List<ItemNote> findByTag(Long userId, String tag);

    Page<ItemNote> findAllByItemUserId(long userId, Pageable page);

}

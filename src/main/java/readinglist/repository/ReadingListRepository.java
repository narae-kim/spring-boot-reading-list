package readinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import readinglist.domain.Book;

import java.util.List;

/**
 * Version 1 - Create only interface using JpaRepository.
 * Spring boot creates its implementation during build time.
 */
//public interface ReadingListRepository extends JpaRepository<Book, Long> {
//    List<Book> findByReader(String reader);
//}

/**
 * Version 2 - Create an interface and its implementation.
 */
public interface ReadingListRepository {
    List<Book> findByReader(String reader);

    void save(Book book);
}
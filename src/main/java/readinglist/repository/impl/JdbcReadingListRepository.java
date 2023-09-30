package readinglist.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import readinglist.domain.Book;
import readinglist.repository.ReadingListRepository;
import readinglist.util.BookRowMapper;

import java.util.List;

@Repository
public class JdbcReadingListRepository implements ReadingListRepository {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Book> findByReader(String reader) {
        String sql = "select id, reader, isbn, title, author, description from Book where reader=?";

        return jdbc.query(sql, new BookRowMapper(), reader);
    }

    @Override
    public void save(Book book) {
        String sql = "insert into Book (id, reader, isbn, title, author, description) values (?, ?, ?, ?, ?, ?)";

        jdbc.update(sql, System.currentTimeMillis(), book.getReader(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getDescription());
    }
}

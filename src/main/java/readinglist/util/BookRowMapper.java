package readinglist.util;

import org.springframework.jdbc.core.RowMapper;
import readinglist.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
                rs.getLong("id"),
                rs.getString("reader"),
                rs.getString("isbn"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("description")
        );
    }
}

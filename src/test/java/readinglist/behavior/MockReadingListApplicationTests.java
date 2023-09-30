package readinglist.behavior;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import readinglist.domain.Book;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;


@Disabled("This test works when using JpaRepository interface")
@SpringBootTest
@AutoConfigureMockMvc
class MockReadingListApplicationTests {

    private static final String READING_LIST_URL = "/readingList/";
    private static final String READER = "reader";

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void homePage() throws Exception {
        mockMvc.perform(get(READING_LIST_URL + READER))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", is(empty())));
    }

    @Test
    public void postBook() throws Exception {
        mockMvc.perform(post(READING_LIST_URL + READER)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("title", "BOOK TITLE")
                        .param("author", "BOOK AUTHOR")
                        .param("isbn", "1234567890")
                        .param("description", "DESCRIPTION")
                )
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", READING_LIST_URL + READER));

        Book expectedBook = new Book();
        expectedBook.setId(1L);
        expectedBook.setReader(READER);
        expectedBook.setTitle("BOOK TITLE");
        expectedBook.setAuthor("BOOK AUTHOR");
        expectedBook.setIsbn("1234567890");
        expectedBook.setDescription("DESCRIPTION");

        mockMvc.perform(get(READING_LIST_URL + READER))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", hasSize(1)))
                .andExpect(model().attribute("books", contains(samePropertyValuesAs(expectedBook))));
    }

}

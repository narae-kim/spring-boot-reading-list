package readinglist.behavior;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import readinglist.controller.ReadingListController;
import readinglist.domain.Book;
import readinglist.repository.ReadingListRepository;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
class MockRepositoryForReadingListApplicationTest {

    private static final String READING_LIST_URL = "/readingList/";
    private static final String READER = "reader";

    private MockMvc mockMvc;

    @Test
    public void shouldReturnReadingListFromRepository() throws Exception {
        List<Book> expectedList = List.of(new Book(1L, READER, "12345", "BOOK TITLE", "BOOK AUTHOR", "BOOK DESCRIPTION"));

        ReadingListRepository mockRepo = mock(ReadingListRepository.class);
        when(mockRepo.findByReader(READER)).thenReturn(expectedList);

        ReadingListController controller = new ReadingListController(mockRepo);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get(READING_LIST_URL + READER))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", expectedList));
    }

}

package readinglist;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReadingListApplicationTests {

    private static final String READING_LIST_URL = "/readingList/";
    private static final String READER = "reader";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void readerPage() {
        ResponseEntity<String> response = restTemplate.getForEntity(READING_LIST_URL + READER, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}

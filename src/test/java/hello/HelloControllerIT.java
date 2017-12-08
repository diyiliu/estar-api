package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.net.URL;

import com.tiza.Application;
import com.tiza.web.dao.CertificateDao;
import com.tiza.web.model.bean.Operator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description: HelloControllerIT
 * Author: DIYILIU
 * Update: 2017-12-05 16:34
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private CertificateDao certificateDao;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
    }


    @Test
    public void findOperator(){
        Operator operator = certificateDao.findOperator("39879");
        System.out.println(operator);
    }

    @Test
    public void getStations() {
        ResponseEntity<String> response = template.getForEntity(base + "query_stations_info", String.class);
        System.out.println(response.getBody());
    }
}

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.ramnar.Application;
import com.ramnar.model.UserDetails;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private List<UserDetails> mockUsers = new ArrayList<UserDetails>();

	@Test
	public void retrieveDetailsForCourse() throws Exception {

		UserDetails user1 = new UserDetails();
		user1.setId(1);
		user1.setEmail("admin@admin.com");
		user1.setFirstName("admin");
		user1.setLastName("admin");
		user1.setPassword("admin");
		mockUsers.add(user1);

		UserDetails user2 = new UserDetails();
		user2.setId(2);
		user2.setEmail("john@gmail.com");

		user2.setFirstName("john");
		user2.setLastName("doe");
		user2.setPassword("johndoe");
		mockUsers.add(user2);

		UserDetails user3 = new UserDetails();
		user3.setId(3);
		user3.setEmail("sham@yahoo.com");
		user3.setFirstName("sham");
		user3.setLastName("tis");
		user3.setPassword("shamtis");
		mockUsers.add(user3);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/list").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		Assert.assertEquals("Test Failed", new Gson().toJson(mockUsers), result.getResponse().getContentAsString());
	}

}

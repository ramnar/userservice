
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
import com.ramnar.model.Note;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
public class NotesControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private List<Note> mockNotes = new ArrayList<Note>();

	@Test
	public void testGetAll() throws Exception {
		
		Note note1 = new Note();
		note1.setId(1l);
		note1.setTitle("todo");
		note1.setContent("prepare for demo");

		mockNotes.add(note1);

		Note note2 = new Note();

		note2.setId(2l);
		note2.setTitle("shopping");
		note2.setContent("vegetables");

		mockNotes.add(note2);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/notes").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		 Assert.assertEquals("Test Failed", new Gson().toJson(mockNotes),
		 result.getResponse().getContentAsString());
	}
	
	@Test
	public void testPositiveGetId() throws Exception {
		
		Note note1 = new Note();
		note1.setId(1l);
		note1.setTitle("todo");
		note1.setContent("prepare for demo");

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/notes/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		 Assert.assertEquals("Test Failed", new Gson().toJson(note1),
		 result.getResponse().getContentAsString());
	}
	
//	@Test
//	public void testNegativeGetId() throws Exception{
//		
//		Note note1 = new Note();
//		note1.setId(1l);
//		note1.setTitle("todo");
//		note1.setContent("prepare for demo");
//
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/notes/5").accept(MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		result.getResponse();
//
//	}

}

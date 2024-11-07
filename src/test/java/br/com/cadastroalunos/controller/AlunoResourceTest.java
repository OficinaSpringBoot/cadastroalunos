// package br.com.cadastroalunos.controller;

// import static org.hamcrest.Matchers.containsString;
// import static org.mockito.ArgumentMatchers.longThat;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.util.List;

// import org.junit.jupiter.api.Test;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.web.servlet.MockMvc;

// import com.fasterxml.jackson.core.JsonFactory;
// import com.fasterxml.jackson.core.JsonParser;

// import br.com.cadastroalunos.model.Aluno;
// import br.com.cadastroalunos.service.AlunoService;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class AlunoResourceTest {


//     private final static String basePath = "/api/aluno";

//     @Autowired
// 	private MockMvc mockMvc;

//     @Autowired
//     private AlunoService service;
    

// 	// @Test
// 	// void shouldReturnListOfAlunos() throws Exception {     
        
//     //     var johnDoe = new Aluno((long) 0, "123", (long) 1, "John Doe", "123", "john@example.com", "01/01/2001");
//     //     var joeDoe = new Aluno((long) 1, "456", (long) 1, "Joe Doe", "123", "joe@example.com", "01/01/2001");
        
//     //     service.createAluno(johnDoe);
//     //     service.createAluno(joeDoe);
        
//     //     this.mockMvc
//     //         .perform(get(basePath))
//     //         .andDo(print())
//     //         .andExpect(status().isOk())
//     //         .andExpect(jsonPath("$[0].nomeAluno").value(johnDoe.getNomeAluno()))
//     //         .andExpect(jsonPath("$[2].nomeAluno").value(johnDoe.getNomeAluno()));
// 	// }

// 	// @Test
// 	// void shouldSaveAluno() throws Exception {     
        
//     //     var johnDoe = new Aluno((long) 0, "123", (long) 1, "John Doe", "123", "john@example.com", "01/01/2001");

//     //     var result = this.mockMvc
//     //         .perform(post(basePath))
//     //         .andDo(print())
//     //         .andReturn();

//     //     JsonParser parser = 
        
//     //     new JsonFactory()
//     //         .createParser(result.getResponse().getContentAsString());

//     //     parser.parseMap


//     //     assert(service.getAlunoById(
//     //                     .
//     //         )
//     //     ); 
// 	// }

// 	@Test
// 	void shouldReturnList() throws Exception {
// 		this.mockMvc
//             .perform(get(basePath))
//             .andExpect(status().isOk());
// 	}
// }



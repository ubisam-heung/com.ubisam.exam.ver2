package com.ubisam.exam;

<<<<<<< HEAD
import static io.u2ware.common.docs.MockMvcRestDocs.get;

=======
>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static io.u2ware.common.docs.MockMvcRestDocs.get;
import static io.u2ware.common.docs.MockMvcRestDocs.is2xx;
import static io.u2ware.common.docs.MockMvcRestDocs.post;
import static io.u2ware.common.docs.MockMvcRestDocs.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationApiConfigTests {
<<<<<<< HEAD

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void contextLoads() throws Exception {

    mockMvc
      .perform(get("/api/"))
      .andDo(print())
      .andExpect(is2xx());

  }
  
=======
    
    @Autowired
	private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        mockMvc.perform(get("/")).andExpect(is2xx()).andDo(print());
    }

>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7
}

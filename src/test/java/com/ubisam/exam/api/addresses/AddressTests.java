package com.ubisam.exam.api.addresses;

<<<<<<< HEAD
import static io.u2ware.common.docs.MockMvcRestDocs.delete;
import static io.u2ware.common.docs.MockMvcRestDocs.get;
import static io.u2ware.common.docs.MockMvcRestDocs.is2xx;
import static io.u2ware.common.docs.MockMvcRestDocs.post;
import static io.u2ware.common.docs.MockMvcRestDocs.print;
import static io.u2ware.common.docs.MockMvcRestDocs.put;
import static io.u2ware.common.docs.MockMvcRestDocs.result;
import static io.u2ware.common.docs.MockMvcRestDocs.isJson;

=======
>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

<<<<<<< HEAD
import com.ubisam.exam.domain.Address;

=======
import static io.u2ware.common.docs.MockMvcRestDocs.is2xx;
import static io.u2ware.common.docs.MockMvcRestDocs.post;
import static io.u2ware.common.docs.MockMvcRestDocs.print;
import static io.u2ware.common.docs.MockMvcRestDocs.put;
import static io.u2ware.common.docs.MockMvcRestDocs.result;
import static io.u2ware.common.docs.MockMvcRestDocs.get;
import static io.u2ware.common.docs.MockMvcRestDocs.isJson;
>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7

@SpringBootTest
@AutoConfigureMockMvc
public class AddressTests {

<<<<<<< HEAD
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private AddressDocs docs;
  
  @Test
  public void contextLoads() throws Exception {

    //Crud - C
    // Address a = new Address();
    // a.setName("name1");
    // a.setPhone("010-1234-5678");
    // a.setAddress("address1");
    
    // mockMvc
    //   .perform(post("/addresses")
    //   .content(a))
    //   .andDo(print())
    //   .andExpect(is2xx());

    //Crud - C ver2
    mockMvc
      .perform(post("/api/addresses")
      .content(docs::newEntity, "홍길동"))
      .andDo(print())
      .andExpect(is2xx())
      .andDo(result(docs::context , "data_body"))
      ;

    String name = docs.context("data_body", "$.name");
    System.out.println(name);
    
    //Crud - R
    String url = docs.context("data_body", "$._links.self.href");
    mockMvc
      .perform(get(url))
      .andExpect(is2xx())
      .andDo(print());

    //Crud - U
    Map<String, Object> entity = docs.context("data_body", "$");

    mockMvc
      .perform(put(url)
      .content(docs::updateEntity, entity, "홍길동111"))
      .andExpect(is2xx())
      .andDo(print())
      .andExpect(isJson("$.name", "홍길동111"))
    ;

    //Crud - D
    mockMvc
      .perform(delete(url))
      .andExpect(is2xx())
      .andDo(print());

    //Crud - R (삭제된 데이터 조회)
    mockMvc
      .perform(get("/api/addresses"))
      .andExpect(is2xx())
      .andDo(print());

  }
=======
    @Autowired
	private MockMvc mockMvc;

    @Autowired
    private AddressDocs docs;

    @Test
    public void contextLoads() throws Exception {

        //CRUD - Create
        mockMvc
            .perform(post("/api/addresses").content(docs::newEntity, "홍길동"))
            .andExpect(is2xx())
            .andDo(print())
            // .andDo(print())
            // .andExpect(isJson("$.name", "test1"))
            // 응답 받은 json을 docs에 저장
            .andDo(result(docs::context , "a"))
        ;

        String name = docs.context("a", "$.name");
        System.out.println(name);

        String url = docs.context("a", "$._links.self.href");

        //CRUD - Read
        mockMvc.perform(get(url)).andExpect(is2xx()).andDo(print());

        //CRUD - Update
        Map<String, Object> entity = docs.context("a", "$");

        mockMvc
            .perform(put(url).content(docs::updateEntity, entity, "홍길동111"))
            .andExpect(is2xx())
            .andDo(print())
            .andExpect(isJson("$.name", "홍길동111"))
        ;
    }

>>>>>>> 0c893d8988430cc347921237be980fb47eb20eb7
}

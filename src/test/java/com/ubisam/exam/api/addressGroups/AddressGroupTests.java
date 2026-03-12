package com.ubisam.exam.api.addressGroups;

import static io.u2ware.common.docs.MockMvcRestDocs.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.ubisam.exam.api.addresses.AddressDocs;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressGroupTests {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private AddressGroupDocs docs;
  
  @Test
  public void contextLoads() throws Exception {
    //Crud - C
    mockMvc
      .perform(post("/api/addressGroups")
      .content(docs::newEntity, "연구소1"))
      .andDo(print())
      .andExpect(is2xx())
      .andDo(result(docs::context , "entity1"))
    ;
    mockMvc
      .perform(post("/api/addressGroups")
      .content(docs::newEntity, "연구소2"))
      .andDo(print())
      .andExpect(is2xx())
      .andDo(result(docs::context , "entity2"))
    ;
    mockMvc
      .perform(post("/api/addressGroups")
      .content(docs::newEntity, "연구소3"))
      .andDo(print())
      .andExpect(is2xx())
      .andDo(result(docs::context , "entity3"))
    ;
    mockMvc
      .perform(post("/api/addressGroups")
      .content(docs::newEntity, "연구소4"))
      .andDo(print())
      .andExpect(is2xx())
      .andDo(result(docs::context , "entity4"))
    ;
    //Crud - R (해당 행)
    String url = docs.context("entity1", "$._links.self.href");
    System.out.println("url : " + url);
    mockMvc
      .perform(post(url))
      .andDo(print())
      .andExpect(is2xx())
    ;
    mockMvc
      .perform(get(url))
      .andDo(print())
      .andExpect(is4xx())
    ;
    
    //Crud - U
    Map<String, Object> entity = docs.context("entity1", "$");
    mockMvc
      .perform(put(url)
      .content(docs::updateEntityName, entity, "시스템"))
      .andExpect(is2xx())
      .andDo(print())
      .andExpect(isJson("$.name", "시스템"))
    ;

    //Crud - R (수정 후 단건)
    mockMvc
      .perform(post(url))
      .andDo(print())
      .andExpect(is2xx())
      .andExpect(isJson("$.name", "시스템"))
    ;
  
    //Crud - D
    mockMvc
      .perform(delete(url))
      .andExpect(is2xx())
      .andDo(print());

    //Crud - R (삭제 후 단건) - 지워져서 데이터가 없으므로 is4xx() 기대
    mockMvc
      .perform(post(url))
      .andDo(print())
      .andExpect(is4xx())
    ;
    
    //Search (검색)
    mockMvc
      .perform(post("/api/addressGroups/search")
      .content(docs::setKeyword, ""))
      .andDo(print())
      .andExpect(is2xx())
    ;

    //Search (검색)
    mockMvc
      .perform(post("/api/addressGroups/search")
      .content(docs::setKeyword, "연구소1"))
      .andDo(print())
      .andExpect(is2xx())
    ;
  }

}

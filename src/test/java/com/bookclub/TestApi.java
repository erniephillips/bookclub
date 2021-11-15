package com.bookclub;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

public class TestApi {
  @Autowired
  private MockMvc mockMvc;

  @Test
  @WithMockUser(username = "user", password = "password", roles = "USER")
  public void test() throws Exception {
    mockMvc.perform(get("/api/wishlist")).andExpect(status().isOk());
  }
}

package com.example.ecapitest.api.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.example.ecapitest.auth.AuthController;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthControllerTest {

    private MockMvc mockMvc;

    @Autowired
    AuthController target;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(target).build();
    }

    @Test
    public void loginSuccess()throws Exception {
       mockMvc.perform(get("/auth?name=test&pass=test"))
               .andExpect(status().isOk());
    }
    @Test
    public void loginFailure()throws Exception {
       mockMvc.perform(get("/auth?name=name&pass=pass"))
               .andExpect(status().isNotFound());
    }
}

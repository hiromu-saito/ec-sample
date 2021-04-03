package com.example.ecapi.auth;

import com.example.AbstractBaseTest;
import com.example.eccommon.ApiExceptionHandler;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthControllerTest extends AbstractBaseTest {

    private MockMvc mockMvc;

    @Autowired
    AuthController target;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(target)
                .setControllerAdvice(new ApiExceptionHandler())
                .build();
    }

    @Test
    public void loginSuccessTest()throws Exception {
        dataSetupByFile("setup/AuthControllerTest/loginSuccessTest.sql");
       mockMvc.perform(get("/auth?memNo=1&pass=111"))
               .andExpect(status().isOk());

    }
    @Test
    public void loginFailureTest()throws Exception {
        dataSetupByFile("setup/AuthControllerTest/loginFailureTest.sql");
      mockMvc.perform(get("/auth?memNo=1&pass=111"))
               .andExpect(status().is(401));
    }
}

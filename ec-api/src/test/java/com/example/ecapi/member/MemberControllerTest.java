package com.example.ecapi.member;


import com.example.eccommon.ApiExceptionHandler;
import com.example.ecdomain.dao.MemberDao;
import com.example.ecdomain.dto.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MemberControllerTest {

    private MockMvc mockMvc;

    @Autowired
    MemberController target;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MemberDao memberDao;

    @Autowired
    ModelMapper modelMapper;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(target)
                .setControllerAdvice(new ApiExceptionHandler())
                .build();
    }

    @Test
    public void signupTest() throws Exception {
        MemberResource resource = new MemberResource();
        int memNo = memberDao.getLatestMemNo();
        resource.setName("testName");
        resource.setPassword("testPass");
        resource.setAge(10);
        resource.setSex("M");
        resource.setZip("testZip");
        resource.setAddress("testAddress");
        resource.setTel("000-0000-0000");

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(resource)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("memNo").value(memNo+1));

        Member insertRecord = memberDao.selectByMemNo(memNo+1);
        assertEquals("testName",insertRecord.getName());
        assertEquals("testPass",insertRecord.getPassword());
        assertEquals(10,insertRecord.getAge());
        assertEquals("M",insertRecord.getSex());
        assertEquals("testZip",insertRecord.getZip());
        assertEquals("testAddress",insertRecord.getAddress());
        assertEquals("000-0000-0000",insertRecord.getTel());



    }
}

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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        resource.setAddress1("testAddress1");
        resource.setAddress2("testAddress2");
        resource.setTel("000-0000-0000");

        mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(resource)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("memNo").value(memNo + 1));

        Member insertRecord = memberDao.selectByMemNo(memNo + 1);
        assertEquals("testName", insertRecord.getName());
        assertEquals("testPass", insertRecord.getPassword());
        assertEquals(10, insertRecord.getAge());
        assertEquals("M", insertRecord.getSex());
        assertEquals("testZip", insertRecord.getZip());
        assertEquals("testAddress1", insertRecord.getAddress1());
        assertEquals("testAddress2", insertRecord.getAddress2());
        assertEquals("000-0000-0000", insertRecord.getTel());
    }

    @Test
    public void modifyMemberInfoTest() throws Exception {
        MemberResource resource = new MemberResource();
        int memNo = memberDao.getLatestMemNo();
        resource.setMemNo(memNo);
        resource.setName("updateName");
        resource.setPassword("upPass");
        resource.setAge(20);
        resource.setSex("M");
        resource.setZip("123-2345");
        resource.setAddress1("updateAddress1");
        resource.setAddress2("updateAddress2");
        resource.setTel("111-1111-1111");


        mockMvc.perform(put("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(resource)))
                .andExpect(status().isOk());

        Member updatedMember = memberDao.selectByMemNo(memNo);
        assertEquals("updateName",updatedMember.getName());
        assertEquals("upPass",updatedMember.getPassword());
        assertEquals(20,updatedMember.getAge());
        assertEquals("M",updatedMember.getSex());
        assertEquals("123-2345",updatedMember.getZip());
        assertEquals("updateAddress1",updatedMember.getAddress1());
        assertEquals("updateAddress2",updatedMember.getAddress2());
        assertEquals("111-1111-1111",updatedMember.getTel());
    }

    @Test
    public void deleteMemberTest()throws Exception{
        MemberResource resource = new MemberResource();
        int memNo = memberDao.getLatestMemNo();
        resource.setMemNo(memNo);

        mockMvc.perform(delete("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(resource)))
                .andExpect(status().isOk());

        Member member = memberDao.selectByMemNo(memNo);
        assertNull(member);
    }
}

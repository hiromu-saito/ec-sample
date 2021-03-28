package com.example.ecapi.item;


import com.example.eccommon.ApiExceptionHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemControllerTest {

    private MockMvc mockMvc;

    @Autowired
    ItemController target;

    @Before
    public  void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(target)
                .setControllerAdvice(new ApiExceptionHandler())
                .build();
    }

    @Test
    public void getItemCategoryTest()throws  Exception{
        mockMvc.perform(get("/item/category"))
                .andExpect(status().isOk());
        //TODO テスト詳細化
    }

    @Test
    public void itemSearchTest()throws Exception{
        mockMvc.perform(get("/item"))
                .andExpect(status().isOk());
    }
}

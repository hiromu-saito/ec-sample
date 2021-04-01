package com.example.ecapi.item;


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

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemControllerTest extends AbstractBaseTest {

    private MockMvc mockMvc;

    @Autowired
    ItemController target;

    @Before
    public  void setUp()  {
        mockMvc = MockMvcBuilders.standaloneSetup(target)
                .setControllerAdvice(new ApiExceptionHandler())
                .build();
    }

    @Test
    public void getItemCategoryTest()throws  Exception{
        dataSetupByFile("setup/ItemControllerTest/getItemCategoryTest.sql");
        mockMvc.perform(get("/item/category"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].ctgrId").value(0))
                .andExpect(jsonPath("$[0].name").value("サプリ"))
                .andExpect(jsonPath("$[0].lastUpdDate").value(nullValue()));
    }

    @Test
    public void itemSearchTest()throws Exception{
        dataSetupByFile("setup/ItemControllerTest/itemSearchTest.sql");
        mockMvc.perform(get("/item?categoryId=0&itemName=サプリ"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        mockMvc.perform(get("/item?minPrice=3000&maxPrice=5000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }
}

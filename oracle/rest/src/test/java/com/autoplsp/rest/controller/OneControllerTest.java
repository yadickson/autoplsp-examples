package com.autoplsp.rest.controller;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.autoplsp.rest.constant.Constants;
import com.autoplsp.rest.domain.OneTO;
import com.autoplsp.rest.service.OneService;

@RunWith(MockitoJUnitRunner.class)
public class OneControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    OneController controller;

    @Mock
    OneService oneService;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    public void testToDo() throws Exception {
        Mockito.when(oneService.toDo(Mockito.anyString())).thenReturn("output");
        String result = controller.toDoText("text");
        Assert.assertEquals("output", result);
    }

    @Test
    public void testTest() throws Exception {
        String result = controller.test();
        Assert.assertEquals("hello world", result);
    }

    @Test
    public void testJson() throws Exception {
        OneTO result = controller.json();
        Assert.assertNotNull(result);
    }

    @Test
    public void testRestToDo() throws Exception {
        Mockito.when(oneService.toDo(Mockito.anyString())).thenReturn("output");
        mockMvc.perform(get("/one/toDo/texto"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRestTest() throws Exception {

        mockMvc.perform(get("/one/test"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRestJson() throws Exception {

        mockMvc.perform(get("/one/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(Constants.APPLICATION_JSON_VALUE));
    }

}

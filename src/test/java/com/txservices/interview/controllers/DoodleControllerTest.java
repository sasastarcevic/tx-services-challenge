package com.txservices.interview.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.txservices.interview.services.DoodleServiceImpl;
import com.txservices.interview.models.DoodleCollection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit tests.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DoodleController.class)
public class DoodleControllerTest {

    private static final String POLL_ID = "1";
    private static final String POLL_TITLE = "poll_title";
    private static final String ENDPOINT_DOODLES_GET_BY_TITLE = "/doodles/title/customTitleText";
    private static List<DoodleCollection> DOODLE_LIST;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private DoodleServiceImpl doodlesService;

    @Before
    public void setupBeforeEachTest() {
        DOODLE_LIST = new ArrayList<>();
        DoodleCollection doodleCollection = new DoodleCollection();
        doodleCollection.setId(POLL_ID);
        doodleCollection.setTitle(POLL_TITLE);
        DOODLE_LIST.add(doodleCollection);
    }

    @Test
    public void findByTitleShouldReturnStatusOk() throws Exception {
        when(doodlesService.findByTitle(any())).thenReturn(DOODLE_LIST);

        MvcResult mvcResult = mockMvc.perform(get(ENDPOINT_DOODLES_GET_BY_TITLE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").value(POLL_ID))
                .andReturn();

        assertThat(objectMapper.writeValueAsString(DOODLE_LIST))
                .isEqualToIgnoringWhitespace(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void findByTitleShouldReturnCorrectIdAndTitle() throws Exception {
        when(doodlesService.findByTitle(any())).thenReturn(DOODLE_LIST);

        MvcResult mvcResult = mockMvc.perform(get(ENDPOINT_DOODLES_GET_BY_TITLE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").value(POLL_ID))
                .andExpect(jsonPath("$[*].title").value(POLL_TITLE))
                .andReturn();

        assertThat(objectMapper.writeValueAsString(DOODLE_LIST))
                .isEqualToIgnoringWhitespace(mvcResult.getResponse().getContentAsString());
    }


}
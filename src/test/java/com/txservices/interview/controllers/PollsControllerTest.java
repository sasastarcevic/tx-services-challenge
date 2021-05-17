package com.txservices.interview.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.txservices.interview.services.PollsServiceImpl;
import com.txservices.interview.models.PollCollection;
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
@WebMvcTest(PollsController.class)
public class PollsControllerTest {

    private static final String POLL_ID = "1";
    private static final String POLL_TITLE = "poll_title";
    private static final String ENDPOINT_POLLS_GET_BY_TITLE = "/doodle-polls/title/customTitleText";
    private static List<PollCollection> DOODLE_LIST;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PollsServiceImpl pollsService;

    @Before
    public void setupBeforeEachTest() {
        DOODLE_LIST = new ArrayList<>();
        PollCollection pollCollection = new PollCollection();
        pollCollection.setId(POLL_ID);
        pollCollection.setTitle(POLL_TITLE);
        DOODLE_LIST.add(pollCollection);
    }

    @Test
    public void findByTitleShouldReturnStatusOk() throws Exception {
        when(pollsService.findByTitle(any())).thenReturn(DOODLE_LIST);

        MvcResult mvcResult = mockMvc.perform(get(ENDPOINT_POLLS_GET_BY_TITLE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").value(POLL_ID))
                .andReturn();

        assertThat(objectMapper.writeValueAsString(DOODLE_LIST))
                .isEqualToIgnoringWhitespace(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void findByTitleShouldReturnCorrectIdAndTitle() throws Exception {
        when(pollsService.findByTitle(any())).thenReturn(DOODLE_LIST);

        MvcResult mvcResult = mockMvc.perform(get(ENDPOINT_POLLS_GET_BY_TITLE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id").value(POLL_ID))
                .andExpect(jsonPath("$[*].title").value(POLL_TITLE))
                .andReturn();

        assertThat(objectMapper.writeValueAsString(DOODLE_LIST))
                .isEqualToIgnoringWhitespace(mvcResult.getResponse().getContentAsString());
    }


}
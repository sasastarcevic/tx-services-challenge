package com.txservices.interview.repositories;

import com.txservices.interview.models.PollCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Integration tests.
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class PollRepositoryIntegrationTest {

    @Autowired
    PollCollectionRepository pollCollectionRepository;

    @Before
    public void setupBeforeEachTest() throws Exception {
        List<PollCollection> pollCollections = new ArrayList<>();
        PollCollection pollCollection1 = new PollCollection();
        pollCollection1.setId("id1");
        pollCollection1.setTitle("title1");
        pollCollections.add(pollCollection1);

        PollCollection pollCollectio2 = new PollCollection();
        pollCollectio2.setId("id2");
        pollCollectio2.setTitle("title2");
        pollCollections.add(pollCollectio2);

        pollCollectionRepository.saveAll(pollCollections);
    }

    @Test
    public void shouldFindPollsByTitle() {
        Optional<List<PollCollection>> pollCollectionList = pollCollectionRepository.findByTitle("title1");

        Assert.assertEquals(1, pollCollectionList.get().size());
    }

    @Test
    public void shouldFindPollsByTitleAndReturnCorrectValueForIdAndTitleFields() {
        Optional<List<PollCollection>> pollCollectionList = pollCollectionRepository.findByTitle("title2");

        Assert.assertEquals("id2", pollCollectionList.get().get(0).getId());
        Assert.assertEquals("title2", pollCollectionList.get().get(0).getTitle());
    }

}
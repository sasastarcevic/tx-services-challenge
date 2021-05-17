package com.txservices.interview.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration tests.
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class DoodleRepositoryITTest {

    @Autowired
    DoodleCollectionRepository doodleCollectionRepository;

    @Test
    public void checkContextInitialization() {

    }

}
package com.txservices.interview.repositories;

import com.txservices.interview.models.PollCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PollCollectionRepository extends MongoRepository<PollCollection, String> {

    @Query("{ 'initiator.email' : ?0 }")
    Optional<List<PollCollection>> findByInitiatorEmail(String email);

    @Query("{ 'title' : ?0 }")
    Optional<List<PollCollection>> findByTitle(String title);

    @Query("{'initiated' : { $gte: ?0 } }")
    Optional<List<PollCollection>> findGraterByDate(long from);

}

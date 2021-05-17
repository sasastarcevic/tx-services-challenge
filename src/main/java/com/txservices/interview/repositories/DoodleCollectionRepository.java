package com.txservices.interview.repositories;

import com.txservices.interview.models.DoodleCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoodleCollectionRepository extends MongoRepository<DoodleCollection, String> {

    @Query("{ 'initiator.email' : ?0 }")
    Optional<List<DoodleCollection>> findByInitiatorEmail(String email);

    @Query("{ 'title' : ?0 }")
    Optional<List<DoodleCollection>> findByTitle(String title);

    @Query("{'initiated' : { $gte: ?0 } }")
    Optional<List<DoodleCollection>> findGraterByDate(long from);

}

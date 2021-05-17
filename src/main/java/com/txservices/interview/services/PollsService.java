package com.txservices.interview.services;

import com.txservices.interview.models.PollCollection;

import java.util.List;

public interface PollsService {

    List<PollCollection> findByInitiatorEmail(String email);

    List<PollCollection> findByTitle(String title);

    List<PollCollection> findGraterByDate(long from);

}

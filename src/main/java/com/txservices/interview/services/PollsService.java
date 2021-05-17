package com.txservices.interview.services;

import com.txservices.interview.models.PollCollection;

import java.util.List;

public interface PollsService {

    List<PollCollection> listAllPollsCreatedByUser(String email);

    List<PollCollection> searchPollsByTitle(String title);

    List<PollCollection> listAllPollsCreatedAfterDate(long from);

}

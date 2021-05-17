package com.txservices.interview.services;

import com.txservices.interview.models.DoodleCollection;

import java.util.List;

public interface DoodleService {

    List<DoodleCollection> findByInitiatorEmail(String email);

    List<DoodleCollection> findByTitle(String title);

    List<DoodleCollection> findGraterByDate(long from);

}

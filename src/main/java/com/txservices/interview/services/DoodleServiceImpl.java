package com.txservices.interview.services;

import com.txservices.interview.errors.ApiException;
import com.txservices.interview.errors.ErrorType;
import com.txservices.interview.models.DoodleCollection;
import com.txservices.interview.repositories.DoodleCollectionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoodleServiceImpl implements DoodleService {

    private static final Logger LOGGER = LogManager.getLogger(DoodleServiceImpl.class);

    @Autowired
    private DoodleCollectionRepository doodleCollectionRepository;

    @Override
    public List<DoodleCollection> findByInitiatorEmail(String email) {
        LOGGER.debug("Getting the polls by email: " + email);
        return doodleCollectionRepository.findByInitiatorEmail(email).orElseThrow(() -> {
            LOGGER.warn("Initiator email: " + email + " not found!");
            return new ApiException(ErrorType.POLL_NOT_FOUND, email);
        });
    }

    @Override
    public List<DoodleCollection> findByTitle(String title) {
        LOGGER.debug("Getting the polls by title: " + title);
        return doodleCollectionRepository.findByTitle(title).orElseThrow(() -> {
            LOGGER.warn("Poll title: " + title + " not found!");
            return new ApiException(ErrorType.POLL_NOT_FOUND, title);
        });
    }

    @Override
    public List<DoodleCollection> findGraterByDate(long from) {
        LOGGER.debug("Getting the polls by email: " + from);
        return doodleCollectionRepository.findGraterByDate(from).orElseThrow(() -> {
            LOGGER.warn("Date gratter then: " + from + " not found!");
            return new ApiException(ErrorType.POLL_NOT_FOUND, String.valueOf(from));
        });
    }
}

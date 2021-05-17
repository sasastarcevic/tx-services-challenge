package com.txservices.interview.services;

import com.txservices.interview.errors.ApiException;
import com.txservices.interview.errors.ErrorType;
import com.txservices.interview.models.PollCollection;
import com.txservices.interview.repositories.PollCollectionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollsServiceImpl implements PollsService {

    private static final Logger LOGGER = LogManager.getLogger(PollsServiceImpl.class);

    @Autowired
    private PollCollectionRepository pollCollectionRepository;

    @Override
    public List<PollCollection> findByInitiatorEmail(String email) {
        LOGGER.debug("Getting the polls by email: " + email);
        return pollCollectionRepository.findByInitiatorEmail(email).orElseThrow(() -> {
            LOGGER.warn("Initiator email: " + email + " not found!");
            return new ApiException(ErrorType.POLL_NOT_FOUND, email);
        });
    }

    @Override
    public List<PollCollection> findByTitle(String title) {
        LOGGER.debug("Getting the polls by title: " + title);
        return pollCollectionRepository.findByTitle(title).orElseThrow(() -> {
            LOGGER.warn("Poll title: " + title + " not found!");
            return new ApiException(ErrorType.POLL_NOT_FOUND, title);
        });
    }

    @Override
    public List<PollCollection> findGraterByDate(long from) {
        LOGGER.debug("Getting the polls by email: " + from);
        return pollCollectionRepository.findGraterByDate(from).orElseThrow(() -> {
            LOGGER.warn("Date gratter then: " + from + " not found!");
            return new ApiException(ErrorType.POLL_NOT_FOUND, String.valueOf(from));
        });
    }
}

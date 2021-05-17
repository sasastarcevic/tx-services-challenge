package com.txservices.interview.controllers;

import com.txservices.interview.models.PollCollection;
import com.txservices.interview.services.PollsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Api(value = "Polls")
@RequestMapping("/doodle-polls")
public class PollsController {

    private static final Logger LOGGER = LogManager.getLogger(PollsController.class);

    @Autowired
    private PollsService pollsService;

    @ApiOperation(value = "List all polls created by a user")
    @RequestMapping(value = "/email/{initiatorEmail}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PollCollection> listAllPollsCreatedByUser(@PathVariable("initiatorEmail") String initiatorEmail) {
        LOGGER.info("Entering in rest endpoint to List all polls created by a user by initiatorEmail");
        return pollsService.listAllPollsCreatedByUser(initiatorEmail);
    }

    @ApiOperation(value = "Search polls by its title")
    @RequestMapping(value = "/title/{title}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public List<PollCollection> searchPollsByTitle(@RequestBody SearchFilter searchFilter) {
        LOGGER.info("Entering in rest endpoint to search polls by its title");
        return pollsService.searchPollsByTitle(searchFilter.getTitle());
    }

    @ApiOperation(value = "List all polls created after a certain date")
    @RequestMapping(value = "/afterdate/{date}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PollCollection> listAllPollsCreatedAfterDate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws ParseException {
        LOGGER.info("Entering in rest endpoint to List all polls created after a certain date");
        return pollsService.listAllPollsCreatedAfterDate(date.getTime());
    }
}
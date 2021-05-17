package com.txservices.interview.controllers;

import com.txservices.interview.models.DoodleCollection;
import com.txservices.interview.services.DoodleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@Api(value = "Doodle")
@RequestMapping("/doodles")
public class DoodleController {

    private static final Logger LOGGER = LogManager.getLogger(DoodleController.class);

    @Autowired
    private DoodleService doodleService;

    @ApiOperation(value = "List all polls created by a user")
    @RequestMapping(value = "/email/{initiatorEmail}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<DoodleCollection> getAllPollsCreatedByUser(@PathVariable("initiatorEmail") String initiatorEmail) {
        LOGGER.info("Entering in rest endpoint to List all polls created by a user by initiatorEmail");
        return doodleService.findByInitiatorEmail(initiatorEmail);
    }

    @ApiOperation(value = "Search polls by its title")
    @RequestMapping(value = "/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<DoodleCollection> getAllPollsByTitle(@PathVariable("title") String title) {
        LOGGER.info("Entering in rest endpoint to Search polls by its title");
        return doodleService.findByTitle(title);
    }

    @ApiOperation(value = "List all polls created after a certain date")
    @RequestMapping(value = "/afterdate/{date}}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<DoodleCollection> getAllPollsAfterDate(@PathVariable("date") String date) throws ParseException {
        LOGGER.info("Entering in rest endpoint to List all polls created after a certain date");

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse("06/24/2016");
        Date secondDate = sdf.parse("04/30/2021");

        return doodleService.findGraterByDate(Long.parseLong(date));
    }
}
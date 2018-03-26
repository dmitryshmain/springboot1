package com.dataart.dshmain.boottest1.controller;

import com.dataart.dshmain.boottest1.entity.Scorecard;
import com.dataart.dshmain.boottest1.service.ScorecardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "/scorecard")
public class ScorecardController {

    private ScorecardService scorecardService;

    public ScorecardController(ScorecardService scorecardService) {
        this.scorecardService = scorecardService;
    }

    @RequestMapping(path = "", method= RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Scorecard scorecard) {
        scorecardService.insert(scorecard);

        return new ResponseEntity("", HttpStatus.CREATED);
    }
}

package com.dataart.dshmain.boottest1.service.impl;

import com.dataart.dshmain.boottest1.entity.Scorecard;
import com.dataart.dshmain.boottest1.repository.ScorecardRepository;
import com.dataart.dshmain.boottest1.service.ScorecardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class DefaultScorecardService implements ScorecardService {

    private MongoOperations ops;

    private ScorecardRepository scorecardRepository;

    public DefaultScorecardService(MongoOperations ops, ScorecardRepository scorecardRepository) {
        this.ops = ops;
        this.scorecardRepository = scorecardRepository;
    }

    @Override
    public void insert(Scorecard scorecard) {
        ops.insert(scorecard);
        log.info("Inserted scorecard: " + ops.findOne(new Query(where("scorecardId").is(scorecard.getScorecardId())), Scorecard.class));
    }

    @Override
    public void update(UUID id, String content) {
        Scorecard scorecard = ops.findById(id, Scorecard.class);
        scorecard.setContent(content);
        ops.save(scorecard);
    }

    @Override
    public List<Scorecard> findByLayoutNative(String name) {
        List<Scorecard> scorecards = scorecardRepository.findByLayoutNative(name);
        log.info("Found scorecards by layout name '{}': {}", name, scorecards.size());
        return scorecards;
    }
}

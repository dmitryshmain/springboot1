package com.dataart.dshmain.boottest1.startup;

import com.dataart.dshmain.boottest1.entity.Scorecard;
import com.dataart.dshmain.boottest1.service.ScorecardService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitMongoCollections implements ApplicationListener<ContextRefreshedEvent> {

    private ScorecardService scorecardService;

    public InitMongoCollections(ScorecardService scorecardService) {
        this.scorecardService = scorecardService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Scorecard scorecard = new Scorecard(null, "{'layout': 'test'}");
        scorecardService.insert(scorecard);
        scorecardService.update(scorecard.getId(), "{'layout': 'test2'}");
        //scorecardService.findByLayoutNative("test2");
    }
}

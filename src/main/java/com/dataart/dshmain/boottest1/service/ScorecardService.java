package com.dataart.dshmain.boottest1.service;

import com.dataart.dshmain.boottest1.entity.Scorecard;

import java.util.List;
import java.util.UUID;

public interface ScorecardService {
    void insert(Scorecard scorecard);
    void update(UUID id, String content);
    // List<Scorecard> findAll();
    List<Scorecard> findByLayoutNative(String name);
}

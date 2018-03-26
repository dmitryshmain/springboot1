package com.dataart.dshmain.boottest1.service;

import com.dataart.dshmain.boottest1.entity.Scorecard;

import java.util.List;
import java.util.UUID;

public interface ScorecardService {
    void insert(Scorecard scorecard);
    void update(String id, String content);
    List<Scorecard> findByLayoutNative(String name);
}

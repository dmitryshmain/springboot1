package com.dataart.dshmain.boottest1.repository;

import com.dataart.dshmain.boottest1.entity.Scorecard;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ScorecardRepository extends PagingAndSortingRepository<Scorecard, String> {

    @Query("{'content.layout': ?0}")
    List<Scorecard> findByLayoutNative(String name);
}

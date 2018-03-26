package com.dataart.dshmain.boottest1.repository;

import com.dataart.dshmain.boottest1.entity.Scorecard;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface ScorecardRepository extends PagingAndSortingRepository<Scorecard, UUID> {

    @Query("{'content.layout': ?0}")
    List<Scorecard> findByLayoutNative(String name);
}

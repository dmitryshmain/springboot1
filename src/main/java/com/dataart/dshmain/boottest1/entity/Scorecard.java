package com.dataart.dshmain.boottest1.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "scorecard")
public class Scorecard {
    @Id private UUID scorecardId;
    private String content;
    @Version private Long version;

    public Scorecard(UUID scorecardId, String content) {
        this.scorecardId = scorecardId;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public UUID getScorecardId() {
        return scorecardId;
    }

    public void setScorecardId(UUID scorecardId) {
        this.scorecardId = scorecardId;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scorecard scorecard = (Scorecard) o;
        return Objects.equals(scorecardId, scorecard.scorecardId) &&
                Objects.equals(content, scorecard.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(scorecardId, content);
    }

    @Override
    public String toString() {
        return "Scorecard{" +
                "scorecardId=" + scorecardId +
                '}';
    }
}

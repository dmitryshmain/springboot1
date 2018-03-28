package com.dataart.dshmain.boottest1.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Document(collection = "scorecard")
public class Scorecard {
    @Id
    private String id;

    @NotNull
    private String content;

    @Version
    private Long version;

    public Scorecard(){}

    public Scorecard(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scorecard scorecard = (Scorecard) o;
        return Objects.equals(id, scorecard.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Scorecard{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", version=" + version +
                '}';
    }
}

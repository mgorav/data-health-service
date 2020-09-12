package com.gonnect.datalineage;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDateTime;
import java.util.List;

@NodeEntity
@Data
public class Contributor {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Relationship(type = "WATCHING_DEPENDENT_DATA_CONTRIBUTOR")
    private List<Contributor> contributors;
    @Relationship(type = "CREATE_REPORT")
    private Report report;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}

package com.gonnect.datalineage;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@NodeEntity
@Data
public class Report {
    @Id
    @GeneratedValue
    @EndNode
    private Long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}

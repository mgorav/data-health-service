package com.gonnect.datalineage;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@NodeEntity
@Data
public class DataHealth {
    @Id
    @GeneratedValue
    @Index
    @StartNode
    private Long id;
    @Index
    private String name;
    @Relationship("WATCHING_DATA_CONTRIBUTION")
    private Contributor contributor;


}

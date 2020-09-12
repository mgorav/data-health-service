package com.gonnect.datalineage;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DataHealthRepository extends Neo4jRepository<DataHealth,Long> {
}

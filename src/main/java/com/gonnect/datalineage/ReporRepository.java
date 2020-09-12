package com.gonnect.datalineage;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ReporRepository extends Neo4jRepository<Report, Long> {
}

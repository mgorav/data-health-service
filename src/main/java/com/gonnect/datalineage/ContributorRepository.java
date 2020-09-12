package com.gonnect.datalineage;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ContributorRepository extends Neo4jRepository<Contributor,Long> {
}

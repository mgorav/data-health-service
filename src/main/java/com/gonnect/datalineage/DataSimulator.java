package com.gonnect.datalineage;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

@Service
public class DataSimulator {
    private final DataHealthRepository dataHealthRepository;
    private final ContributorRepository contributorRepository;
    private final ReporRepository reporRepository;
    @Autowired
    private Session session;

    public DataSimulator(DataHealthRepository dataHealthRepository, ContributorRepository contributorRepository, ReporRepository reporRepository) {
        this.dataHealthRepository = dataHealthRepository;
        this.contributorRepository = contributorRepository;
        this.reporRepository = reporRepository;
    }

    //    @Scheduled(initialDelay = 10 * 1000, fixedRate = 30 * 1000)
    @Transactional
    public void simulate() {
        session.query("MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE n,r", Collections.EMPTY_MAP);
        System.out.println("Entering data ....");
        for (long cnt = 1; cnt < 20; cnt++) {
            DataHealth dataHealth = new DataHealth();
            dataHealth.setName("orginator" + cnt);

            Contributor parentContributor = new Contributor();
            parentContributor.setName("contributor" + cnt);
            parentContributor.setStartTime(LocalDateTime.now());
            parentContributor.setEndTime(LocalDateTime.now());

            dataHealth.setContributor(parentContributor);

            Contributor childContributor = new Contributor();
            childContributor.setName("contributor" + cnt);
            childContributor.setStartTime(LocalDateTime.now());
            childContributor.setEndTime(LocalDateTime.now());

            Report report = new Report();
            report.setName("report" + cnt);
            report.setStartTime(LocalDateTime.now());
            report.setEndTime(LocalDateTime.now());
            reporRepository.save(report);

            childContributor.setReport(report);
            contributorRepository.save(childContributor);

            parentContributor.setContributors(Arrays.asList(childContributor));
            contributorRepository.save(parentContributor);


            dataHealthRepository.save(dataHealth);
        }

        System.out.println("Data entered");


    }
}

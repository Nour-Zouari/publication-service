package com.example.demo;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.PublicationRepository;
import com.example.demo.entities.Publication;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
public class PublicationServiceApplication implements CommandLineRunner{
	PublicationRepository publicationRepository;
	RepositoryRestConfiguration configuration;
	public static void main(String[] args) {
		SpringApplication.run(PublicationServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Publication.class);
		Publication pubs1 = 
				Publication.builder()
				.type("article")
				.titre("an approach for testing soa systems")
				.dateApparition(new Date())
				.lien("lien")
				.sourcePdf("pdf")
				.build();
		publicationRepository.save(pubs1);
		Publication pubs2 = 
				Publication.builder()
				.type("rapport")
				.titre("an approach for edge computing")
				.dateApparition(new Date())
				.lien("lien")
				.sourcePdf("pdf")
				.build();
		publicationRepository.save(pubs2);
	}

}

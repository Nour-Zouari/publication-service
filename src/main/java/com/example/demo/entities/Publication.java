package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
@Data @Builder
public class Publication {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	@NonNull
	private String type;

	@Temporal(TemporalType.DATE)
	@NonNull
	private Date dateApparition;
	@NonNull
	private String lien;
	@NonNull
	private String sourcePdf; }



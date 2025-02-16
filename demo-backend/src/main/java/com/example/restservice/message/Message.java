package com.example.restservice.message;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String name;
	public String message;
	@Column(name = "created_at")
    @CreationTimestamp
    public LocalDateTime createdAt;


	
}

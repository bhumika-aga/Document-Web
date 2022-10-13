package com.bhumika.document.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhumika.document.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
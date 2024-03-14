package com.bhumika.document.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhumika.document.entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

}
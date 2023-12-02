package br.com.ekan.repository;

import br.com.ekan.model.Beneficiary;
import br.com.ekan.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {


    Document findByDocumentTypeAndDesc(String documentType, String desc);
}

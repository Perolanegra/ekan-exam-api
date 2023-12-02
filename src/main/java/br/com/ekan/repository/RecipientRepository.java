package br.com.ekan.repository;

import br.com.ekan.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Beneficiary, Long> {

}

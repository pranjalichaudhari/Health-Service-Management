package com.cg.hsm.repository;
/**
 * This interface is to perform all the crud operations of a Finance table
 * @author kethu_greeshma
 */

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.hsm.domain.Finance;

@Repository
public interface FinanceRepository extends CrudRepository<Finance, Long>{
	
	Finance findByPatientIdentifier(String patientIdentifier);
	
}

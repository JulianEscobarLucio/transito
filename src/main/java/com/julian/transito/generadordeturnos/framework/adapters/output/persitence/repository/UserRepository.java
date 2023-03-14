package com.julian.transito.generadordeturnos.framework.adapters.output.persitence.repository;

import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.data.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData, Long> {

  UserData findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);

}

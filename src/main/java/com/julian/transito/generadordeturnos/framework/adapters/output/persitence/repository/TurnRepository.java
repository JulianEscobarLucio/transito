package com.julian.transito.generadordeturnos.framework.adapters.output.persitence.repository;

import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.data.TurnData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TurnRepository extends CrudRepository<TurnData, Long> {

  TurnData findById(String id);
}

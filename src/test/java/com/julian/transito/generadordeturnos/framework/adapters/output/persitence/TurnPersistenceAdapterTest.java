package com.julian.transito.generadordeturnos.framework.adapters.output.persitence;

import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.data.TurnData;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.repository.TurnRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TurnPersistenceAdapterTest {

  @Autowired
  TurnRepository turnRepository;

  @Test
  void saveTurn() {
    TurnData result = turnRepository.findById("id");
    assertNotNull(result);
  }

  @Test
  void findTurn() {
  }

  @Test
  void allTurns() {
  }
}
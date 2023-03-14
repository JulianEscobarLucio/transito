package com.julian.transito.generadordeturnos.application.ports.input;

import com.julian.transito.generadordeturnos.application.ports.ouput.TurnManagementOutputPort;
import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.domain.vo.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnManagementInputPortTest {

  @Autowired
  TurnManagementInputPort turnManagementInputPort;

   @MockBean
  TurnManagementOutputPort turnManagementOutputPort;

  @Test
  void generateTurn() {
  }

  @Test
  void findTurn() {
    User user = User.builder().build();
    Turn turn = Turn.builder().build();
    Mockito.doReturn(turn).when(turnManagementOutputPort).findTurn(user);

    Turn result = turnManagementInputPort.findTurn(user);

    assertNotNull(result);
    assertEquals(turn, result);
    Mockito.verify(turnManagementOutputPort, Mockito.times(1)).findTurn(Mockito.any());
  }

  @Test
  void availableTurns() {
  }
}
package com.julian.transito.generadordeturnos.application.ports.input;

import com.julian.transito.generadordeturnos.application.ports.ouput.TurnManagementOutputPort;
import com.julian.transito.generadordeturnos.application.usecases.TurnManagementUseCase;
import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.domain.vo.TurnStatus;
import com.julian.transito.generadordeturnos.domain.vo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TurnManagementInputPort implements TurnManagementUseCase {

  private TurnManagementOutputPort turnManagementOutputPort;

  public TurnManagementInputPort(TurnManagementOutputPort turnManagementOutputPort) {
    this.turnManagementOutputPort = turnManagementOutputPort;
  }

  @Override
  public Turn generateTurn(User user, String turnId) {
    return turnManagementOutputPort.saveTurn(user, turnId);
  }

  @Override
  public Turn findTurn(User user) {
    return turnManagementOutputPort.findTurn(user);
  }

  @Override
  public  List<Turn> availableTurns() {
    return turnManagementOutputPort.allTurns().stream()
      .filter(turn -> turn.getStatus() == TurnStatus.AVAILABLE ).toList();
  }

}

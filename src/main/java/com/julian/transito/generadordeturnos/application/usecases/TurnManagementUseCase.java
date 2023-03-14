package com.julian.transito.generadordeturnos.application.usecases;

import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.domain.vo.User;
import java.util.List;

public interface TurnManagementUseCase {

  Turn generateTurn(User user, String turnId);
  Turn findTurn(User user);
  List<Turn> availableTurns();
}

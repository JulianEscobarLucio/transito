package com.julian.transito.generadordeturnos.application.ports.ouput;

import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.domain.vo.User;

import java.util.List;

public interface TurnManagementOutputPort {

  Turn saveTurn(User user, String turnId);

  Turn findTurn(User user);

  List<Turn> allTurns();
}

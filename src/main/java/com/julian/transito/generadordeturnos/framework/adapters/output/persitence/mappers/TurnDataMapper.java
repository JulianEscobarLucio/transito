package com.julian.transito.generadordeturnos.framework.adapters.output.persitence.mappers;

import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.domain.vo.ProcessType;
import com.julian.transito.generadordeturnos.domain.vo.TurnStatus;
import com.julian.transito.generadordeturnos.domain.vo.User;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.data.TurnData;

public final class TurnDataMapper {

  public static Turn turnDataToTurn(TurnData turnData) {
    User user = turnData.getUser() == null ? null : UserDataMapper.userDataToUser(turnData.getUser());
    return Turn.builder().id(turnData.getId() == null ? null : turnData.getId().toString())
      .processType(turnData.getProcessType() == null ? null :  ProcessType.valueOf(turnData.getProcessType()))
      .user(user)
      .status(turnData.getStatus() == null ? null : TurnStatus.valueOf(turnData.getStatus()))
      .date(turnData.getFecha())
      .code(turnData.getCode()).build();
  }
}

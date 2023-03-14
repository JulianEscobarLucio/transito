package com.julian.transito.generadordeturnos.framework.adapters.input.rest.mapper;

import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.framework.adapters.input.rest.data.response.TurnResponse;

public final class TurnResponseMapper {

  public static TurnResponse turnToTurnResponse(Turn turn) {
    return TurnResponse.builder().id(turn.getId()).code(turn.getCode()).date(turn.getDate()).processType(turn.getProcessType()).build();
  }
}

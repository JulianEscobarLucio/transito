package com.julian.transito.generadordeturnos.framework.adapters.input.soap;

import com.julian.transito.generadordeturnos.application.usecases.TurnManagementUseCase;
import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.domain.vo.DocumentType;
import com.julian.transito.generadordeturnos.domain.vo.User;
import com.julian.transito.generadordeturnos.framework.adapters.input.soap.data.FindTurnRequest;
import com.julian.transito.generadordeturnos.framework.adapters.input.soap.data.ScheduleTurnRequest;
import com.julian.transito.generadordeturnos.framework.adapters.input.soap.data.TurnData;
import com.julian.transito.generadordeturnos.framework.adapters.input.soap.data.TurnResponse;
import com.julian.transito.generadordeturnos.framework.adapters.input.soap.mapper.TurnResponseMapper;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import java.util.List;

@Endpoint
public class TurnManagementEndpoint {

  private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

  private TurnManagementUseCase turnManagementUseCase;

  public TurnManagementEndpoint(TurnManagementUseCase turnManagementUseCase) {
    this.turnManagementUseCase = turnManagementUseCase;
  }

  @PayloadRoot(localPart = "GetListAvailableTurnsRequest", namespace = NAMESPACE_URI)
  @ResponsePayload
  public TurnResponse getListAvailableTurns() {
    List<TurnData> turnDataList = turnManagementUseCase.availableTurns().stream()
      .map(TurnResponseMapper::turnToTurnData).toList();
    TurnResponse turnResponse = new TurnResponse();
    turnResponse.getTurnResponse().addAll(turnDataList);
    return turnResponse;
  }

  @PayloadRoot(localPart = "ScheduleTurnRequest", namespace = NAMESPACE_URI)
  @ResponsePayload
  public TurnResponse scheduleTurn(@RequestPayload ScheduleTurnRequest request) {
    User user = User.builder().documentType(DocumentType.valueOf(request.getDocumentType()))
      .documentNumber(request.getDocumentNumber()).build();
    Turn turn = turnManagementUseCase.generateTurn(user, request.getTurnId());
    TurnResponse turnResponse = new TurnResponse();
    turnResponse.getTurnResponse().add(TurnResponseMapper.turnToTurnData(turn));
    return turnResponse;
  }

  @PayloadRoot(localPart = "FindTurnRequest", namespace = NAMESPACE_URI)
  @ResponsePayload
  public TurnResponse findTurn(@RequestPayload FindTurnRequest request) {
    Turn turn = turnManagementUseCase.findTurn(User.builder().documentType(DocumentType.valueOf(request.getDocumentType()))
      .documentNumber(request.getDocumentNumber()).build());
    TurnResponse turnResponse = new TurnResponse();
    turnResponse.getTurnResponse().add(TurnResponseMapper.turnToTurnData(turn));
    return turnResponse;
  }
}

package com.julian.transito.generadordeturnos.framework.adapters.output.persitence;

import com.julian.transito.generadordeturnos.application.ports.ouput.TurnManagementOutputPort;
import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.domain.vo.TurnStatus;
import com.julian.transito.generadordeturnos.domain.vo.User;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.data.TurnData;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.data.UserData;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.mappers.TurnDataMapper;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.repository.TurnRepository;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurnPersistenceAdapter implements TurnManagementOutputPort {

  private final TurnRepository turnRepository;
  private final UserRepository userRepository;

  public TurnPersistenceAdapter(TurnRepository turnRepository, UserRepository userRepository) {
    this.turnRepository = turnRepository;
    this.userRepository = userRepository;
  }

  @Override
  public Turn saveTurn(User user, String turnId) {
    UserData userData = userRepository.findByDocumentTypeAndDocumentNumber(user.getDocumentType().toString(),
      user.getDocumentNumber());
    TurnData turnData = turnRepository.findById(turnId);
    turnData.setStatus(TurnStatus.SCHEDULED.toString());
    turnData.setUser(userData);
    return TurnDataMapper.turnDataToTurn(turnRepository.save(turnData)) ;
  }

  @Override
  public Turn findTurn(User user) {
    Optional<TurnData> turnDataOptional = userRepository.findByDocumentTypeAndDocumentNumber(user.getDocumentType().toString(),
      user.getDocumentNumber()).getTurnDataList().stream().findFirst();
    return TurnDataMapper.turnDataToTurn(turnDataOptional.orElseGet(TurnData::new));
  }

  @Override
  public List<Turn> allTurns() {
    List<Turn> turnList = new ArrayList<>();
    turnRepository.findAll().forEach(turnData -> {
      turnList.add(TurnDataMapper.turnDataToTurn(turnData));
    });
    return turnList;
  }
}

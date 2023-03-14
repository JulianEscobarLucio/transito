package com.julian.transito.generadordeturnos.framework.adapters.output.persitence;

import com.julian.transito.generadordeturnos.application.ports.ouput.UserManagementOutputPort;
import com.julian.transito.generadordeturnos.domain.vo.User;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.data.UserData;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.mappers.UserDataMapper;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.repository.UserRepository;

public class UserPersistenceAdapter implements UserManagementOutputPort {

  private final UserRepository userRepository;

  public UserPersistenceAdapter(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User findUser(String documentType, String documentNumber) {
    UserData userData = this.userRepository.findByDocumentTypeAndDocumentNumber(documentType, documentNumber);
    return UserDataMapper.userDataToUser(userData);
  }
}

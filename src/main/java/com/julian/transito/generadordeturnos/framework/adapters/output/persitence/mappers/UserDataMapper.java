package com.julian.transito.generadordeturnos.framework.adapters.output.persitence.mappers;

import com.julian.transito.generadordeturnos.domain.vo.DocumentType;
import com.julian.transito.generadordeturnos.domain.vo.User;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.data.UserData;

public final class UserDataMapper {

  public static User userDataToUser(UserData userData) {
    return User.builder()
      .documentType(userData.getDocumentType() == null ? null : DocumentType.valueOf(userData.getDocumentType()))
      .documentNumber(userData.getDocumentNumber() == null ? null : userData.getDocumentNumber())
      .build();
  }
}

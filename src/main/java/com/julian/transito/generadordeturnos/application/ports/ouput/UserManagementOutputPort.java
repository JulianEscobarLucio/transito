package com.julian.transito.generadordeturnos.application.ports.ouput;

import com.julian.transito.generadordeturnos.domain.vo.User;

public interface UserManagementOutputPort {

  User findUser(String documentType, String documentNumber);
}

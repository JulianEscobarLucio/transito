package com.julian.transito.generadordeturnos.framework.configuration;

import com.julian.transito.generadordeturnos.Main;
import com.julian.transito.generadordeturnos.application.ports.input.TurnManagementInputPort;
import com.julian.transito.generadordeturnos.application.ports.ouput.TurnManagementOutputPort;
import com.julian.transito.generadordeturnos.application.ports.ouput.UserManagementOutputPort;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.UserPersistenceAdapter;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.repository.TurnRepository;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.TurnPersistenceAdapter;
import com.julian.transito.generadordeturnos.framework.adapters.output.persitence.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Main.class)
public class BeanConfiguration {

  @Bean
  TurnManagementOutputPort turnManagementOutputPort(TurnRepository turnRepository, UserRepository userRepository) {
    return new TurnPersistenceAdapter(turnRepository, userRepository);
  }

  @Bean
  UserManagementOutputPort userManagementOutputPort(UserRepository userRepository) {
    return new UserPersistenceAdapter(userRepository);
  }

  @Bean
  TurnManagementInputPort turnManagementUseCase(TurnManagementOutputPort turnManagementOutputPort) {
    return new TurnManagementInputPort(turnManagementOutputPort);
  }
}

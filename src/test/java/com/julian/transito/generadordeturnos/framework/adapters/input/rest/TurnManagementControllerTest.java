package com.julian.transito.generadordeturnos.framework.adapters.input.rest;

import com.julian.transito.generadordeturnos.application.usecases.TurnManagementUseCase;
import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.domain.vo.DocumentType;
import com.julian.transito.generadordeturnos.domain.vo.ProcessType;
import com.julian.transito.generadordeturnos.domain.vo.TurnStatus;
import com.julian.transito.generadordeturnos.domain.vo.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import java.time.Month;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(TurnManagementController.class)
class TurnManagementControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private TurnManagementUseCase turnManagementUseCase;

  @Test
  void findTurn() throws Exception {
    String documentNumber = "123";
    String documentType = "CC";
    Turn turn = Turn.builder().id("1").code("t2").processType(ProcessType.TRANSFERS)
      .date(LocalDateTime.of(2023,Month.JANUARY,26,8,0,0,0)).build();
    Mockito.doReturn(turn).when(turnManagementUseCase).findTurn(Mockito.any());

    mvc.perform(get("/transito/turn/"+documentType+"/"+documentNumber).contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id").value(turn.getId()))
      .andExpect(jsonPath("$.code").value(turn.getCode()))
      .andExpect(jsonPath("$.processType").value(turn.getProcessType().toString()))
      .andExpect(jsonPath("$.date").value("2023-01-26T08:00:00"));
  }

  @Test
  void scheduleTurn() {
  }

  @Test
  void getListAvailableTurns() {
  }
}
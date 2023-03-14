package com.julian.transito.generadordeturnos.framework.adapters.input.rest;

import com.julian.transito.generadordeturnos.application.usecases.TurnManagementUseCase;
import com.julian.transito.generadordeturnos.domain.entity.Turn;
import com.julian.transito.generadordeturnos.domain.vo.DocumentType;
import com.julian.transito.generadordeturnos.domain.vo.User;
import com.julian.transito.generadordeturnos.framework.adapters.input.rest.data.request.ScheduleTurnRequest;
import com.julian.transito.generadordeturnos.framework.adapters.input.rest.data.response.TurnResponse;
import com.julian.transito.generadordeturnos.framework.adapters.input.rest.mapper.TurnResponseMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/transito/turn")
public class TurnManagementController {

    private TurnManagementUseCase turnManagementUseCase;

    public TurnManagementController(TurnManagementUseCase turnManagementUseCase) {
        this.turnManagementUseCase = turnManagementUseCase;
    }

    @GetMapping(value = "/{documentType}/{documentNumber}")
    @ResponseStatus(OK)
    public TurnResponse findTurn(@PathVariable String documentType, @PathVariable String documentNumber) {
        Turn turn = turnManagementUseCase.findTurn(User.builder().documentType(DocumentType.valueOf(documentType))
          .documentNumber(documentNumber).build());
        return TurnResponseMapper.turnToTurnResponse(turn);
    }

    @PostMapping(value = "")
    @ResponseStatus(CREATED)
    public TurnResponse scheduleTurn(@RequestBody @Valid ScheduleTurnRequest scheduleTurnRequest) {
        User user = User.builder().documentType(scheduleTurnRequest.getDocumentType())
          .documentNumber(scheduleTurnRequest.getDocumentNumber()).build();
        Turn turn = turnManagementUseCase.generateTurn(user, scheduleTurnRequest.getTurnId());
        return TurnResponseMapper.turnToTurnResponse(turn);
    }

    @GetMapping(value = "/available/turns")
    @ResponseStatus(OK)
    public List<TurnResponse> getListAvailableTurns() {
        return turnManagementUseCase.availableTurns().stream().map(TurnResponseMapper::turnToTurnResponse).toList();
    }
}

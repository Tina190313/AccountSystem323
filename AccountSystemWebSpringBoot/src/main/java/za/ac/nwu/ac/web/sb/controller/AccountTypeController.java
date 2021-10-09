package za.ac.nwu.ac.web.sb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import za.ac.nwu.ac.logic.flow.impl.CreateAccountTypeFlowImpl;
import za.ac.nwu.ac.logic.flow.impl.FetchAccountTypeFlowImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;

@RestController
@RequestMapping("account-type")

public class AccountTypeController {

    private final FetchAccountTypeFlowImpl fetchAccountTypeFlow;
    private final CreateAccountTypeFlowImpl createAccountTypeFlow;


    @Autowired
    public AccountTypeController(FetchAccountTypeFlowImpl fetchAccountTypeFlow,/*Qualifier calls component name*/
                                 @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlowImpl createAccountTypeFlow) {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;

    }


    @GetMapping("/all")
    @ApiOperation(value = "Gets all configured Account Types.", notes = "Returns a list of Account types")
    @ApiResponses(value =
            {@ApiResponse(code = 200, message = "Returned", response = GeneralResponse.class),
                    @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                    @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
                    @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll() {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new Account type.", notes = "Creates a new Account type in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account Type Successfully Created", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new AccountType",
                    required = true)
            @RequestBody AccountTypeDto accountType) {
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}


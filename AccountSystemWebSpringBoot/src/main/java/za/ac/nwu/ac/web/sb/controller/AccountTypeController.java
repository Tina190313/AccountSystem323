package za.ac.nwu.ac.web.sb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("account-type")

public class AccountTypeController {
    @GetMapping("/all")
    @ApiOperation(value = "Gets all configured Account Types.", notes = "Returns a list of Account types")
    @ApiResponses(value =
            {@ApiResponse(code = 200, message = "Returned", response = GeneralResponse.class),
                    @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                    @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
                    @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<String>> getAll() {
        GeneralResponse<String> response = new GeneralResponse<>(true, "No types found");
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }
}

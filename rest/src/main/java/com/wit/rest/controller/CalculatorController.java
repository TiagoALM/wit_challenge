package com.wit.rest.controller;

import com.wit.rest.models.Operation;
import com.wit.rest.models.Results;
import com.wit.rest.services.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static com.wit.rest.utils.Constants.Operands.OPERAND_ONE;
import static com.wit.rest.utils.Constants.Operands.OPERAND_TWO;
import static com.wit.rest.utils.Constants.RestOperations.*;

@RestController
public class CalculatorController {

    public static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping(path = SUM_OP, method = RequestMethod.GET)
    public ResponseEntity<?> sumOperation(@RequestParam(name = OPERAND_ONE) BigDecimal a,
                             @RequestParam(name = OPERAND_TWO) BigDecimal b) {
        Operation operation = new Operation(a, b, SUM_OP);
        Results<?> results = calculatorService.calculate(operation);
        return new ResponseEntity<>(results, HttpStatus.OK);

    }

    @RequestMapping(path = SUB_OP, method = RequestMethod.GET)
    public ResponseEntity<?> subOperation(@RequestParam(name = OPERAND_ONE) BigDecimal a,
                             @RequestParam(name = OPERAND_TWO) BigDecimal b) {
        Operation operation = new Operation(a, b, SUB_OP);
        Results<?> results = calculatorService.calculate(operation);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @RequestMapping(path = DIV_OP, method = RequestMethod.GET)
    public ResponseEntity<?> divOperation(@RequestParam(name = OPERAND_ONE) BigDecimal a,
                             @RequestParam(name = OPERAND_TWO) BigDecimal b) {
        Operation operation = new Operation(a, b, DIV_OP);
        Results<?> results = calculatorService.calculate(operation);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @RequestMapping(path = MUL_OP, method = RequestMethod.GET)
    public ResponseEntity<?> mulOperation(@RequestParam(name = OPERAND_ONE) BigDecimal a,
                             @RequestParam(name = OPERAND_TWO) BigDecimal b) {
        Operation operation = new Operation(a, b, MUL_OP);
        Results<?> results = calculatorService.calculate(operation);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}

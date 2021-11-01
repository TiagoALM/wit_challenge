package com.wit.calculator.services;

import com.wit.calculator.models.Operation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.wit.calculator.utils.Constants.Operations.*;

@Service
public class Calculator {
    public static BigDecimal compute(Operation operation) {
        if (operation.getOperation().contains(SUM)) {
            System.out.println("sum");
            BigDecimal a = operation.getA();
            BigDecimal b = operation.getB();
            return a.add(b);

        }
        else if(operation.getOperation().contains(SUB)) {
            System.out.println("SUB");
            BigDecimal a = operation.getA();
            BigDecimal b = operation.getB();
            return a.subtract(b);
        }
        else if(operation.getOperation().contains(DIV)) {
            System.out.println("DIV");
            BigDecimal a = operation.getA();
            BigDecimal b = operation.getB();
            BigDecimal zero = new BigDecimal(0);
            if(b.equals(zero))
            {
                return new BigDecimal(-1);
            }
            return a.divide(b);
        }
        else if(operation.getOperation().contains(MUL)) {
            System.out.println("MUL");
            BigDecimal a = operation.getA();
            BigDecimal b = operation.getB();
            return a.multiply(b);
        }
        BigDecimal x = new BigDecimal("1.000");
        return x;
    }

}

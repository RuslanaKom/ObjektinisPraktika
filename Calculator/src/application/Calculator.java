/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    
    private List<Double> values = new ArrayList<>();
    private List<String> valuesInString = new ArrayList<>();
    private String sign;
    
    private double plus() {
        return values.get(0)+values.get(1);   
    }

    private double minus() {
        return values.get(0)-values.get(1);   
    }
    
    private double multiply() {
        return values.get(0)*values.get(1); 
    }

    private double divide() {
        return values.get(0)/values.get(1);     
    }

    public void inputValue(String value) {
        valuesInString.add(value);
    }
    
    public void inputSign(String inputSign) {
       sign=inputSign;
    }
    
    
    public boolean setValues() {
        if (valuesInString.size()>1) {
            values=valuesInString.stream().map(value->Double.parseDouble(value)).collect(Collectors.toList());
            return true;
        }
        return false;
    }


    public void erase() {
        valuesInString.clear();
        values.clear();
        sign = null;
    }
    
    public double calculate() {
        if (sign.equals("+")) {
            return plus();
        }
        else if (sign.equals("-")) {
            return minus();
        }
        else if (sign.equals("*")) {
            return multiply();
        }
        else if (sign.equals("/")) {
            return divide();
        }
        else return 0;
    }
    
    public double square() {
        if (!valuesInString.get(0).equals("")) {
            double x = Double.parseDouble(valuesInString.get(0));
            return x * x;
        }
        return 0.0;
    }

    public double root() {
        if (!valuesInString.get(0).equals("")) {
            double x = Double.parseDouble(valuesInString.get(0));
            return Math.sqrt(x);
        }
        return 0.0;
    }
}

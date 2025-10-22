/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arep.collatz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juan.mmendez
 */
@RestController
public class CollatzController {
    
    private static String collatzsecuence;
    
    @GetMapping("/collatz")
    public String collatzRespon(@RequestParam(value = "value", defaultValue = "13") String value){
        String ans = collatz(Integer.valueOf(value));
        return "{\"value\":\""+
                ans + 
                "\"}";
    }
    
    private String collatz(Integer value){
        if(value == 1){
            return collatzsecuence;
        }else if(value%2 == 0.0){
            value = value/2;
            collatzsecuence += value + " ->";
            collatz(value);
        }else if(value%2 == 1.0){
            value = (3*value)+1;
            collatzsecuence += value + " -> ";
            collatz(value);
        }
        return collatzsecuence;
    }
    
}

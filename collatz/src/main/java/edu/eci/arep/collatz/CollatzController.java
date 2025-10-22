/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.arep.collatz;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juan.mmendez
 */
@RestController
public class CollatzController {
    
    private static LinkedHashMap collatzsecuence = new LinkedHashMap<>();
    
    @GetMapping("/collatz")
    public ResponseEntity<String> collatzRespon(@RequestParam String value){
        LinkedHashMap ans = collatz(value);
        
        return ResposeEntity.ok(200).body(ans);
    }
    
    private static LinkedHashMap collatz(int value){
        if(value == 1){
            return collatzsecuence;
        }else if(value%2 == 0){
            value = value/2;
            collatzsecuence.put(value, value);
            return collatz(value);
        }else if(value%2 == 1){
            value = (3*value)+1;
            collatzsecuence.put(value, value);
            return collatz((3*value)+1);
        }
        return null;
    }
    
}

package com.webautomation.exploration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,5,9,10,5);
        List<Integer> result = new ArrayList<>();
        
        // perulangan tradisional
        for (int number : numbers) {
            if (number == 5) {
                result.add(number);
            }
        }
        System.out.println("hasil resultnya adalah" + result);

        // perulangan dengan stream 
        result = numbers.stream().filter(integer -> integer.equals(5)).collect(Collectors.toList());
        System.out.println("hasil resultmnya adalah " + result);
    }
}

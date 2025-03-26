package com.example.spring_framework.examples.b1;

import java.util.Arrays;
import org.springframework.stereotype.Service;

// @Component
@Service // Component 대체
public class BusinessCalculationService {

    private DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

}

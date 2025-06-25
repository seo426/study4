package groom4.study4.domain.coffee.controller;

import groom4.study4.domain.coffee.dto.CoffeeResDto;
import groom4.study4.domain.coffee.service.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CoffeeController {
    private final CoffeeService coffeeService;
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }
    @GetMapping("/coffee/{coffeeId}")
    public ResponseEntity<CoffeeResDto> getCoffee(@PathVariable Integer coffeeId) {
        CoffeeResDto coffeeResDto = coffeeService.showCoffee(coffeeId);

        return new ResponseEntity<>(coffeeResDto, HttpStatus.OK);
    }
}

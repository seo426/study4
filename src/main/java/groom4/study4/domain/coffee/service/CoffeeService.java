package groom4.study4.domain.coffee.service;

import groom4.study4.domain.coffee.Coffee;
import groom4.study4.domain.coffee.dto.CoffeeResDto;
import groom4.study4.domain.coffee.repository.CoffeeRepository;
import groom4.study4.exceptions.coffee.NotFoundCoffeeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeResDto showCoffee(Integer coffeeId) {
        Coffee coffee = coffeeRepository.findById(coffeeId).orElseThrow(()->
                new NotFoundCoffeeException("존재하지 않는 커피입니다."));
        return CoffeeResDto.fromCoffee(coffee);

    }
}

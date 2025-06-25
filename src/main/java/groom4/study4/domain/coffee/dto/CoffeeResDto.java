package groom4.study4.domain.coffee.dto;


import groom4.study4.domain.coffee.Coffee;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoffeeResDto {
    private String name;
    private Integer price;

    public CoffeeResDto(Coffee coffee){

    }

    public static CoffeeResDto fromCoffee(Coffee coffee) {
        CoffeeResDto coffeeResDto = new CoffeeResDto();
        coffeeResDto.name = coffee.getName();
        coffeeResDto.price = coffee.getPrice();
        return coffeeResDto;
    }
}

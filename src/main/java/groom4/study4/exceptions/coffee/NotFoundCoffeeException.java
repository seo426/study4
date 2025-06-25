package groom4.study4.exceptions.coffee;

public class NotFoundCoffeeException extends RuntimeException {
    public NotFoundCoffeeException(final String message) {super(message);}
    public NotFoundCoffeeException() { this("커피를 찾을 수 없습니다.");}

}

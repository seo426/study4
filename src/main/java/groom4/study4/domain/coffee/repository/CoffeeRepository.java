package groom4.study4.domain.coffee.repository;

import groom4.study4.domain.coffee.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
}

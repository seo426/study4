package groom4.study4.domain.coffee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Coffee {
    @Id
    @Column(name = "coffeeId", nullable = false)
    private Integer coffeeId;

    private String name;

    private Integer price;
}

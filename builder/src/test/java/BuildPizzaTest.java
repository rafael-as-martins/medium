import com.medium.builder.PizzaBuilder;
import com.medium.core.Pizza;
import com.medium.core.size.Size;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BuildPizzaTest {

    @Test
    public void buildPizzaWith2ItemsTest() {

        //Given
        PizzaBuilder builder = Pizza.builder();

        //When
        Pizza pizza = builder
                        .name("Avocato")
                        .creationDate(LocalDate.of(2020, 12, 12))
                        .size(Size.LARGE)
                        .withItems()
                            .addItem().name("Cheese").quantity(10).add()
                            .addItem().name("Ham").quantity(12).add()
                            .buildItems()
                        .build();

        //Then
        assertThat(pizza.getItems().size()).isEqualTo(2);
    }

}

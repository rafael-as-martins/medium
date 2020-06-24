import com.medium.builder.ItemBuilder;
import com.medium.builder.PizzaBuilder;
import com.medium.core.Item;
import com.medium.core.Pizza;
import com.medium.core.size.Size;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class BuildItemTest {

    @Test
    public void build1ItemTest() {

        //Given
        ItemBuilder builder = Item.builder();

        //When
        Item item = builder.name("Ham")
                            .quantity(10)
                            .build();

        //Then
        assertThat(item).isNotNull();
        assertThat(item.getQuantity()).isEqualTo(10);
    }
}

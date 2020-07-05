package builder;

import com.medium.builder.ItemBuilder;
import com.medium.builder.core.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuildItemTest {

    @Test
    public void build1ItemTest() {

        //Given
        ItemBuilder builder = Item.Builder();

        //When
        Item item = builder.name("Ham")
                            .quantity(10)
                            .build();

        //Then
        assertThat(item).isNotNull();
        assertThat(item.getQuantity()).isEqualTo(10);
    }
}

package factory;

import com.medium.factory.Order;
import com.medium.factory.OrderFactory;
import com.medium.factory.OrderSupplierFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PizzaFactoryTest {


    @Test
    public void createPizzaFromFactoryTest() {
        Order pizza = OrderFactory.getOrder("Pizza");
        assertThat(pizza.eat()).isEqualTo("Eating Pizza...");
    }

    @Test
    public void createUnkownOrder(){
        Order something = OrderFactory.getOrder("something");
        assertThat(something).isNull();
    }

    @Test
    public void createPizzaFromFactorySupplierTest() {
        Order pizza = OrderSupplierFactory.getOrder("Pizza");
        assertThat(pizza.eat()).isEqualTo("Eating Pizza...");
    }

}

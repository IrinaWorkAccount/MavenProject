import org.assertj.core.api.Assertions;
import org.example.dao.ProductRepository;
import org.example.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testAddNewProduct() {
        Product product1 = new Product();
        product1.setProductName("trousers");
        product1.setCategory("clothes");
        product1.setQuantityOnStock(15);
        Product savedProduct1=productRepository.save(product1);

        Product product2 = new Product();
        product1.setProductName("t-shirt");
        product1.setCategory("clothes");
        product1.setQuantityOnStock(30);
        Product savedProduct2=productRepository.save(product2);

        Product product3 = new Product();
        product1.setProductName("pens");
        product1.setCategory("stationery");
        product1.setQuantityOnStock(50);
        Product savedProduct3=productRepository.save(product3);

        Assertions.assertThat(savedProduct1).isNotNull();
        Assertions.assertThat(savedProduct1.getProductId()).isGreaterThan(0);
        Assertions.assertThat(savedProduct2).isNotNull();
        Assertions.assertThat(savedProduct2.getProductId()).isGreaterThan(0);
        Assertions.assertThat(savedProduct3).isNotNull();
        Assertions.assertThat(savedProduct3.getProductId()).isGreaterThan(0);
    }
}

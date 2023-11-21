import org.assertj.core.api.Assertions;
import org.checkerframework.checker.fenum.qual.SwingTextOrientation;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.example.dao.ProductRepository;
import org.example.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testAddNewProduct(){
        Product product = new Product();
        product.setProductName("Trousers");
        product.setQuantityOnStock(15);
        product.setCategory("Clothing");

        Product savedProduct = productRepository.save(product);

        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getProductId()).isGreaterThan(0);
        assertEquals(savedProduct.getProductName(),"Trousers");
        assertEquals(savedProduct.getCategory(),"Clothing");
        assertEquals(savedProduct.getQuantityOnStock(),15);
    }
}

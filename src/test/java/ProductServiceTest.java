import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private static final Product PRODUCT = new Product(13, "LaptopGaming", 8999);

    @Test
    void shouldAddProduct() {
        //setup
        when(productRepository.add(PRODUCT))
                .thenReturn(PRODUCT);

        // call for tested method
        Product resultedProduct = productService.addProduct(PRODUCT);

        //verify if result is OK
        assertThat(resultedProduct).isEqualTo(PRODUCT);
        verify(productRepository).add(PRODUCT);
    }

    @Test
    void shouldFindProductById() {
        //setup
        when(productRepository.findById(13))
                .thenReturn(Optional.of(PRODUCT));

        //call
       Product resultedProduct = productService.findProductById(13);

       //verify
       assertThat(resultedProduct).isEqualTo(PRODUCT);

    }

    @Test
    void  shouldThrowExceptionWhenProductNotFound() {
        when(productRepository.findById(13))
                .thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () ->{
            productService.findProductById(13);
        });

        String expectedMessage = "Product not found!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}

import java.util.Optional;

public class ProductService {

    private ProductRepository productRepository = new ProductRepository();

    public Product addProduct(Product product) {
        return productRepository.add(product);

    }

    public Product findProductById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found!");
        } else {
            return productOptional.get();
        }
    }
}

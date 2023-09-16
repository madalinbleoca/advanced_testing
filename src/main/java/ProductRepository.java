import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private  List<Product> productList = new ArrayList<>();

    public Product add(Product product) {
        productList.add(product);
        return product;
    }

    public Optional<Product> findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}

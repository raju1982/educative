package design.implementation.Amazon;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Catalog {
    Map<String, List<Product>> productNames;
    Map<String, List<Product>> productCategories;

    public List<Product> searchProductsByName(String name) {
        return productNames.get(name);
    }

    public List<Product> searchProductsByCategory(String category) {
        return productCategories.get(category);
    }
}

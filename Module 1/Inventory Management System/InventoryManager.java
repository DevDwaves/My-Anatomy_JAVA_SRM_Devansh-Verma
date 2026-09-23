import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    private List<Product> products;
    private List<Category> categories;

    public InventoryManager() {

        products = FileManager.loadProducts();
        categories = FileManager.loadCategories();
    }

    // =========================================================
    // PRODUCT OPERATIONS
    // =========================================================

    // Add Product
    public boolean addProduct(Product product) {

        if (findProductById(product.getId()) != null) {
            return false;
        }

        products.add(product);

        FileManager.saveProducts(products);

        return true;
    }

    // View All Products
    public void displayProducts() {

        if (products.isEmpty()) {

            System.out.println("\nNo products available.");

            return;
        }

        System.out.println("\n---------------- PRODUCT LIST ----------------");

        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("----------------------------------------------");
    }

    // Find Product
    public Product findProductById(int id) {

        for (Product product : products) {

            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    // Search Product by Name
    public void searchProduct(String name) {

        boolean found = false;

        for (Product product : products) {

            if (product.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                System.out.println(product);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    // Update Product
    public boolean updateProduct(
            int id,
            String name,
            String category,
            double price) {

        Product product = findProductById(id);

        if (product == null) {
            return false;
        }

        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);

        FileManager.saveProducts(products);

        return true;
    }

    // Delete Product
    public boolean deleteProduct(int id) {

        Product product = findProductById(id);

        if (product == null) {
            return false;
        }

        products.remove(product);

        FileManager.saveProducts(products);

        return true;
    }

    // =========================================================
    // STOCK OPERATIONS
    // =========================================================

    // Add Stock
    public boolean addStock(int productId, int quantity) {

        Product product = findProductById(productId);

        if (product == null || quantity <= 0) {
            return false;
        }

        product.setStock(product.getStock() + quantity);

        FileManager.saveProducts(products);

        return true;
    }

    // Remove Stock
    public boolean removeStock(int productId, int quantity) {

        Product product = findProductById(productId);

        if (product == null || quantity <= 0) {
            return false;
        }

        if (product.getStock() < quantity) {
            return false;
        }

        product.setStock(product.getStock() - quantity);

        FileManager.saveProducts(products);

        return true;
    }

    // Display Low Stock Products
    public void displayLowStock(int limit) {

        boolean found = false;

        System.out.println("\n------------- LOW STOCK PRODUCTS -------------");

        for (Product product : products) {

            if (product.getStock() <= limit) {

                System.out.println(product);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No low-stock products.");
        }

        System.out.println("----------------------------------------------");
    }

    // =========================================================
    // CATEGORY OPERATIONS
    // =========================================================

    // Add Category
    public boolean addCategory(Category category) {

        if (findCategoryById(category.getId()) != null) {
            return false;
        }

        categories.add(category);

        FileManager.saveCategories(categories);

        return true;
    }

    // View Categories
    public void displayCategories() {

        if (categories.isEmpty()) {

            System.out.println("\nNo categories available.");

            return;
        }

        System.out.println("\n-------------- CATEGORY LIST ---------------");

        for (Category category : categories) {
            System.out.println(category);
        }

        System.out.println("---------------------------------------------");
    }

    // Find Category
    public Category findCategoryById(int id) {

        for (Category category : categories) {

            if (category.getId() == id) {
                return category;
            }
        }

        return null;
    }

    // Update Category
    public boolean updateCategory(int id, String name) {

        Category category = findCategoryById(id);

        if (category == null) {
            return false;
        }

        category.setName(name);

        FileManager.saveCategories(categories);

        return true;
    }

    // Delete Category
    public boolean deleteCategory(int id) {

        Category category = findCategoryById(id);

        if (category == null) {
            return false;
        }

        // Check whether category is used by any product
        for (Product product : products) {

            if (product.getCategory()
                    .equalsIgnoreCase(category.getName())) {

                return false;
            }
        }

        categories.remove(category);

        FileManager.saveCategories(categories);

        return true;
    }

    // =========================================================
    // UTILITY METHODS
    // =========================================================

    public int getNextProductId() {

        int maxId = 0;

        for (Product product : products) {

            if (product.getId() > maxId) {
                maxId = product.getId();
            }
        }

        return maxId + 1;
    }

    public int getNextCategoryId() {

        int maxId = 0;

        for (Category category : categories) {

            if (category.getId() > maxId) {
                maxId = category.getId();
            }
        }

        return maxId + 1;
    }
}
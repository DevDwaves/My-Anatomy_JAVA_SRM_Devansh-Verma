import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String PRODUCT_FILE = "products.dat";
    private static final String CATEGORY_FILE = "categories.dat";

    // Save products
    public static void saveProducts(List<Product> products) {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(PRODUCT_FILE))) {

            output.writeObject(products);

        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    // Load products
    @SuppressWarnings("unchecked")
    public static List<Product> loadProducts() {

        File file = new File(PRODUCT_FILE);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(PRODUCT_FILE))) {

            return (List<Product>) input.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error loading products: " + e.getMessage());

            return new ArrayList<>();
        }
    }

    // Save categories
    public static void saveCategories(List<Category> categories) {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(CATEGORY_FILE))) {

            output.writeObject(categories);

        } catch (IOException e) {
            System.out.println("Error saving categories: " + e.getMessage());
        }
    }

    // Load categories
    @SuppressWarnings("unchecked")
    public static List<Category> loadCategories() {

        File file = new File(CATEGORY_FILE);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(CATEGORY_FILE))) {

            return (List<Category>) input.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error loading categories: " + e.getMessage());

            return new ArrayList<>();
        }
    }
}
package mk.ukim.finki.wpaud.bootstrap.dataHolder;

        import mk.ukim.finki.wpaud.model.*;
        import org.springframework.stereotype.Component;

        import javax.annotation.PostConstruct;
        import java.util.ArrayList;
        import java.util.List;

@Component
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();


    @PostConstruct
    public void init(){
        categories.add(new Category("Software","Software Category"));
        categories.add(new Category("Books", "Books Category"));

        users.add(new User("melisa.hani", "mh", "Melisa", "Hani"));
        users.add(new User("elsa.hani", "eh", "Elsa", "Hani"));

        Manufacturer manufacturer = new Manufacturer("Nike", "Ny Ny");
        manufacturers.add(manufacturer);
        Category category = new Category("Sport", "Sport category");
        categories.add(category);
        products.add(new Product("Ball 1", 235.8, 7, category, manufacturer));
        products.add(new Product("Ball 2", 235.8, 7, category, manufacturer));
        products.add(new Product("Ball 3", 235.8, 7, category, manufacturer));

    }

}
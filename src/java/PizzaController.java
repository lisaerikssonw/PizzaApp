import dao.PizzaManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Pizza;

@ManagedBean
@Named(value = "pizzaController")
@RequestScoped
public class PizzaController {

    @Inject
    PizzaManager pm;

    private String name;
    private double price;
    private String description;
    private List<Pizza> allPizzas;

    public PizzaController() {
    }
    
    public void submit() {
        Pizza p = new Pizza(name, price, description);
        pm.addPizza(p);
        allPizzas = pm.getAllPizzas();
    }
    
    @PostConstruct
    public void fillArray() {
        this.allPizzas = pm.getAllPizzas();
    }

    public PizzaManager getPm() {
        return pm;
    }

    public void setPm(PizzaManager pm) {
        this.pm = pm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Pizza> getAllPizzas() {
        return allPizzas;
    }

    public void setAllPizzas(List<Pizza> allPizzas) {
        this.allPizzas = allPizzas;
    }

}

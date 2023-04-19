package shop;
import java.util.HashMap;
import java.util.Map;






public abstract class Shop {
    protected Map<Object, Integer> warehouse;

    protected Shop() {
        warehouse = new HashMap<>();
    }
    protected void addProduct(Object object, Integer quantity){
        warehouse.put(object, quantity);
    }

}

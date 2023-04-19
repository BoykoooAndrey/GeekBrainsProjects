package controller;

import java.util.Set;
import shop.ToyShop;
import toy.CastToy;
import toy.Toy;

public class Controller {
    ToyShop toyShop;

    public Controller(ToyShop toyShop) {
        this.toyShop = toyShop;
    }
    
    public void showToys(){
        Set<Toy> keys = toyShop.getToysFromWarehouse();
        for (Toy object : keys) {
            System.out.printf("ID: %d; Name: %s; Quantity: %d\n", 
            object.getId(),object.getName(), 
            toyShop.warehouseToys.get(object));
    }
    }
    
    public void addToy(String name,Integer quantity){
        Integer ID = toyShop.findNeedIDToy();
        Toy tmpToy = new Toy(ID, name);
        toyShop.addToy(tmpToy, quantity);
    }

    public void delToy(Integer ID){
        toyShop.delToy(ID);
    }

/////////////Raffled
    public void showCastToys(){
        Set<CastToy> keys = toyShop.getCastToysFromWarehouseCastToys();
        for (CastToy object : keys) {
            System.out.printf("ID: %d; Name: %s; Quantity: %d; Chance: %.2f\n", 
            object.getId(),object.getName(), 
            toyShop.warehouseCastToys.get(object), object.getChance());
    }
    }

    public void addCastToy(Integer ID, double chance){
        Toy tmpToy = toyShop.getToyFromWarehouse(ID);
        if (tmpToy == null) {
            System.out.println("ID не найден!");
        }
        else{
            toyShop.addCastToyFromWarehouse(tmpToy, chance);
        }
    }

    public void castToy(Integer ID){
        toyShop.castToy(ID);
    }

    
}

package shop;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import recorder.Mapper;
import recorder.dataRecorder;
import toy.CastToy;
import toy.Toy;

public class ToyShop extends Shop {

    public Map<Toy, Integer> warehouseToys;
    public Map<CastToy, Integer> warehouseCastToys;
    private dataRecorder recorder;
    private Mapper mapper;

    public ToyShop(dataRecorder recorder, Mapper mapper) {
        this.recorder = recorder;
        this.mapper = mapper;
        warehouseToys = new TreeMap<>();
        warehouseToys = initToysWithFile(0);
        warehouseCastToys = new TreeMap<>();
        warehouseCastToys = initCastToysWithFile(1);
    }

    public Map<Toy, Integer> initToysWithFile(Integer fileNameIndex){
        return mapper.ToysInMap(recorder.readAllLines(0));
    }
    public Map<CastToy, Integer> initCastToysWithFile(Integer fileNameIndex){
        return mapper.CastToysInMap(recorder.readAllLines(1));
    }


    public void saveToysInFile(Map<Toy, Integer> warehouseToys){
        recorder.saveAllLines(mapper.ToysInString(warehouseToys), 0);
    }
    public void saveCastToysInFile(Map<CastToy, Integer> warehouseCastToys){
        recorder.saveAllLines(mapper.CastToysInString(warehouseCastToys), 1);
    }

//Toys
    public void addToy(Toy object, Integer quantity) {
        for (Toy toy : getToysFromWarehouse()) {
            if (object.equals(toy)){
                warehouseToys.replace(toy, warehouseToys.get(toy), warehouseToys.get(toy) + quantity);
                saveToysInFile(warehouseToys);
                return;
            }
        }
        warehouseToys.put(object, quantity);
        saveToysInFile(warehouseToys);
    }
    public void delToy(Integer ID){
        String name = getToyFromWarehouse(ID).name;
        warehouseToys.remove(getToyFromWarehouse(ID));
        System.out.printf("%s удален!\n", name);
        saveToysInFile(warehouseToys);

    }


    public Toy getToyFromWarehouse(Integer ID) {
        Set<Toy> keys = getToysFromWarehouse();
        for (Toy object : keys) {
            if (object.getId() == ID) {
                return object;
            }
        }
        return null;
    }

    public Set<Toy> getToysFromWarehouse() {
        return warehouseToys.keySet();
    }

    public Integer findNeedIDToy() {
        ArrayList<Integer> IDs = new ArrayList<>();
        Set<Toy> toys = getToysFromWarehouse();
        if (toys.size() > 0) {
            for (Toy toy : getToysFromWarehouse()) {
                IDs.add(toy.getId());
            }
            for (int i = 0; i < IDs.size(); i++) {
                if (i != IDs.get(i) - 1) {
                    return IDs.get(i) - 1;
                }
            }
            return IDs.get(IDs.size()-1) + 1;
        }
        else{
            return 1;
        }
    }



//CastToy
    public void addCastToyFromWarehouse(Toy toy, double chance) {
        CastToy castToy = new CastToy(toy.getId(), toy.getName(), chance);
        
        for (CastToy castToy2 : getCastToysFromWarehouseCastToys()) {
            if (castToy.equals(castToy2)){
                warehouseCastToys.replace(castToy2, warehouseCastToys.get(castToy2), warehouseCastToys.get(castToy2) + 1);
                if (warehouseToys.get(toy) > 1) {
                    warehouseToys.replace(toy, warehouseToys.get(toy), warehouseToys.get(toy) - 1);   
                }
                else{
                    warehouseToys.remove(toy);
                }
                System.out.println("Шанс остался прежним т.к подобная игрушка уже добавлена!");
                saveCastToysInFile(warehouseCastToys);
                saveToysInFile(warehouseToys);
                return;
            }
            
        }
        warehouseCastToys.put(castToy, 1);
        if (warehouseToys.get(toy) > 1) {
            warehouseToys.replace(toy, warehouseToys.get(toy), warehouseToys.get(toy) - 1);   
        }
        else{
            warehouseToys.remove(toy);
        }
        saveCastToysInFile(warehouseCastToys);
        saveToysInFile(warehouseToys);
    }

    public void castToy(Integer ID){

        CastToy castToy = getCastToyFromWarehouse(ID);
        Integer qauntity = warehouseCastToys.get(castToy);
        if (qauntity > 1) {
            warehouseCastToys.replace(castToy, qauntity, qauntity - 1);
        }
        else{
            warehouseCastToys.remove(castToy);
        }
        
        System.out.printf("%s разыгран!\n", castToy.getName());
        saveCastToysInFile(warehouseCastToys);
    }

    public Set<CastToy> getCastToysFromWarehouseCastToys() {
        return warehouseCastToys.keySet();
    }

    public CastToy getCastToyFromWarehouse(Integer ID) {
        Set<CastToy> keys = getCastToysFromWarehouseCastToys();
        for (CastToy object : keys) {
            if (object.getId() == ID) {
                return object;
            }
        }
        return null;
    }

    

    @Override
    public String toString() {
        return "toys=" + warehouseToys.toString() + "\n" + "Cast toys=" + warehouseCastToys.toString();
    }

}

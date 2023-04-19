package recorder;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import toy.CastToy;
import toy.Toy;

public class Mapper {


//Toy//
    public Map<Toy, Integer> ToysInMap (List<String> lines){
        
        Map<Toy, Integer> tmpMap = new TreeMap<>();
        for (String line : lines) {
            String[] args = line.split(";");
            tmpMap.put(new Toy(Integer.parseInt(args[0]), args[1]), Integer.parseInt(args[2]));
        }
        return tmpMap;
    }

    public String ToysInString(Map<Toy, Integer> warehouseToys){
        StringBuffer toys = new StringBuffer();
        Set<Toy> keys = warehouseToys.keySet();
        for (Toy toy : keys) {
            toys.append(String.format("%d;%s;%d\n", toy.getId(), toy.getName(), warehouseToys.get(toy)));
        }
        return toys.toString();
    }

//CastToy//
    public Map<CastToy, Integer> CastToysInMap (List<String> lines){
        Map<CastToy, Integer> tmpMap = new TreeMap<>();
        for (String line : lines) {
            String[] args = line.split(";");
            tmpMap.put(new CastToy(Integer.parseInt(args[0]), args[1], Double.parseDouble(args[2])), Integer.parseInt(args[3]));
        }
        return tmpMap;
    }

    public String CastToysInString(Map<CastToy, Integer> warehouseCastToys){
        StringBuffer toys = new StringBuffer();

        Set<CastToy> keys = warehouseCastToys.keySet();
        for (CastToy toy : keys) {
            Double chance = toy.getChance();
            toys.append(String.format("%d;%s;%s;%d\n", toy.getId(), toy.getName(), chance.toString(), warehouseCastToys.get(toy)));
        }
        return toys.toString();
    }
}
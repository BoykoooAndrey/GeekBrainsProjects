package toy;

public class CastToy extends Toy {
    double chance;

    public CastToy(Integer id, String name, double chance) {
        super(id, name);
        this.chance = chance;

    }

    

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public boolean equals(CastToy o){
        if(name.equalsIgnoreCase(o.getName())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cast Toy " + name;
    }




}

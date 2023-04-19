package toy;

public class Toy extends Object implements Comparable<Toy>{
    Integer id;
    public String name;


    public Toy(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


    public boolean equals(Toy o){
        if(name.equalsIgnoreCase(o.getName())){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Toy o) {
        if (id > o.getId()) {
            return 1;
        }
        else if (id < o.getId()) {
            return -1;
        }
        else{
            return 0;
        }
    }


}

import controller.Controller;
import recorder.Mapper;
import recorder.dataRecorderTXT;
import request.Requester;
import shop.ToyShop;


public class Main {
    public static void main(String[] args) {
        Mapper mapper = new Mapper();
        dataRecorderTXT recorder = new dataRecorderTXT(
        "ToysWarehouse.txt", 
        "CastToysWarehouse.txt");
        ToyShop shop1 = new ToyShop(recorder, mapper);
        Controller cont = new Controller(shop1);
        Requester req = new Requester(cont);
        req.run();
    }

}
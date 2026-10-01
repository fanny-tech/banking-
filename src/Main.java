import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args){
        Vehicle vehicle= new Vehicle("gx01",50,"AMBULANCE",true);
        Intersection intersection=new Intersection("001",6,"Green");
        //RuleFactory rule= new RuleFactory("Green");


        EmergencyOverride emergency = (v , i) -> (v.getType().equals("AMBULANCE") || v.getType().equals("POLICE")) && i.getCongestionlevel() > 7 ;

        System.out.println(emergency.shouldOverride(vehicle , intersection));

        Function<Intersection,Integer> SignalTiming=(i1)->i1.getCurrentLight().equals("GREEN")?i1.getCongestionlevel()-2:30;


        System.out.println(SignalTiming);
    }
}


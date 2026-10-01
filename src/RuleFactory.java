import java.util.function.Function;
import java.util.function.Predicate;

public class RuleFactory {
    String light;

    public RuleFactory(String light) {
        this.light = light;
    }

    public static Predicate<Vehicle>createSpeedLimitRule(int maxSpeed){
        Predicate<Vehicle>vehiclePredicate=(v1)->v1.getSpeedkmh()>90;
        return vehiclePredicate;
    }
    //public static Function<Intersection,Integer>calculateGreenLightDuration(){
//         Function<Intersection,Integer>SignalTiming=(i1)->i1.getCurrentLight().equals("GREEN")?i1.getCongestionlevel()-2:30;
    //return SignalTiming;
    // }

    @Override
    public String toString() {
        return "RuleFactory{" +
                "light='" + light + '\'' +
                '}';
    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMyTrainApp {
    public static void main(String[] args){
        TrainSystem system = new TrainSystem();

        //adding new station
        Station station1 = new Station("S00333","Ahmedabad");
        Station station2 = new Station("S00444","Ara");

        //adding new trains
        Train train1 = new Train("12408","Duranto Express","Express");
        Train train2 = new Train("12409","Intercity", "Passenger");

        Platform p1 = new Platform(1);
        Platform p2 = new Platform(2);

        p1.setTrain(train1);
        p2.setTrain(train2);

        List<Platform> platformList= new ArrayList<>();
        platformList.add(p1);
        platformList.add(p2);

        station1.setPlatformList(platformList);


        Schedule s1 = new Schedule(train1,station1,"9AM","9:05AM",p1);
        Schedule s2  = new Schedule(train1,station2,"10AM","10:10AM",p2);

        system.addStations(station1);
        system.addStations(station2);
        system.addTrain(train2);
        system.addSchedule(s1);
        system.addSchedule(s2);

        //let's find out train between stations
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sourse : ");
        String source = sc.nextLine();
        System.out.println("Enter the Destination : ");
        String destination = sc.nextLine();
//        for(Schedule schedule:system.findMyTrains(source,destination)){
//            System.out.println("You trains between "+source +"And"+destination);
//            System.out.println(source);
//        }
        List<Schedule> myTrains = system.findMyTrains(source, destination);
        System.out.println("You trains between "+source +"And"+destination);
//        Schedule schedule = myTrains.get(0);
//        Train train = schedule.getTrain();
//        System.out.println(train);
        for(Schedule schedule:myTrains){
            System.out.println(schedule);
        }
        //System.out.println(myTrains);

    }
}

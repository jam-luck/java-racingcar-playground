import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Cars {
    private List<Car> carList;
    public Cars(String carNames) throws customException {
        carList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(carNames,",");
        while(st.hasMoreTokens()){
            carList.add(new Car(st.nextToken()));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
    public String getCarNames(){
        StringBuffer names = new StringBuffer();
        for(Car car : carList){
            names.append(car.getName()).append(",");
        }
        return names.toString().substring(0,names.length()-1);
    }

    public void go(){
        for(Car car : carList){
            car.go();
        }
    }
}

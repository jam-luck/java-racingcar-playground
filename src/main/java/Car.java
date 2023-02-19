import java.util.Random;

public class Car {
    private String name;
    private int location;
    public Car(String name) throws customException {
        if(name.length() > 5 ) {
            throw new customException("자동차 이름은 5자를 초과할 수 없다.");
        }

        this.name = name;
        this.location = 1;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public int go(){
        Random random = new Random();
        if(random.nextBoolean()){
            return location++;
        }
        return location;
    }

    public int getLocation(){
        return location;
    }
}

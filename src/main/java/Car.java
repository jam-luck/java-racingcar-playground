
public class Car {
    private String name;
    public Car(String name) throws customException {
        if(name.length() > 5 ) {
            throw new customException("자동차 이름은 5자를 초과할 수 없다.");
        }

        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
}

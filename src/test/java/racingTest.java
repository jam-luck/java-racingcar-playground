import org.assertj.core.api.ThrowableAssert;
import org.graalvm.compiler.hotspot.stubs.OutOfBoundsExceptionStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class racingTest {
    private static Stream<Object[]> nameInputSample(){
        return Stream.of(
                new Object[]{"123", "123"},
                new Object[]{"12345", "12345"}
        );
    }
    @ParameterizedTest
    @MethodSource("nameInputSample")
    void 이름테스트(String input,Object expect) {
        Car car1 = new Car(input);
        assertThat(car1.getName()).isEqualTo(expect);
    }


    @Test
    void 이름길이테스트(){
        assertThatThrownBy(()->new Car("123456"))
                .isInstanceOf(customException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없다.");
    }

    @Test
    void 자동차입력테스트() {
        String carNames = "a,b,c,d";
        Cars cars = new Cars(carNames);
        assertThat(cars.getCarNames()).isEqualTo(carNames);
    }
    @Test
    void 경주() {
        String carNames = "a,b,c,d";
        Cars cars = new Cars(carNames);
        cars.go();
        List <Car> carList = cars.getCarList();
        assertThat(cars.getCarNames()).isEqualTo(carNames);
    }
}

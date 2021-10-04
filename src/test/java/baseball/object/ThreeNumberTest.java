package baseball.object;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ThreeNumberTest {


    @Test
    public void TEST_getter() throws Exception {
        // given
        ThreeNumber threeNumber = new ThreeNumber(7,3,2);
        //when

        //then
        assertThat(threeNumber.getFirst()).isEqualTo(7);
        assertThat(threeNumber.getSecond()).isEqualTo(3);
        assertThat(threeNumber.getThird()).isEqualTo(2);
    }

    @Test
    public void TEST_getNumberIndex() throws Exception {
        // given
        ThreeNumber threeNumber = new ThreeNumber(6,5,2);
        //when

        //then
        assertThat(threeNumber.getNumberIndex(threeNumber.getFirst())).isEqualTo(1);
        assertThat(threeNumber.getNumberIndex(threeNumber.getSecond())).isEqualTo(2);
        assertThat(threeNumber.getNumberIndex(threeNumber.getThird())).isEqualTo(3);
    }

}
package baseball.service;

import baseball.object.ThreeNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PickNumberServiceImplTest {

    PickNumberService pickNumberService = PickNumberServiceImpl.getInstance();

    @Test
    public void pickNumber() throws Exception {
        // given
        ThreeNumber threeNumber = pickNumberService.pickNumber();
        //when

        //then
        assertThat(threeNumber.getFirst()).isNotNull();
        assertThat(threeNumber.getSecond()).isNotNull();
        assertThat(threeNumber.getThird()).isNotNull();
    }

}
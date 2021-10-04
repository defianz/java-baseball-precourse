package baseball.service;

import baseball.object.ThreeNumber;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class PickNumberServiceImplTest{

    PickNumberService pickNumberService = PickNumberServiceImpl.getInstance();

    @Test
    public void pickNumber() throws Exception {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            ThreeNumber result = pickNumberService.pickNumber();
            assertThat(result.getFirst()).isEqualTo(1);
            assertThat(result.getSecond()).isEqualTo(3);
            assertThat(result.getThird()).isEqualTo(5);
        }
    }
}
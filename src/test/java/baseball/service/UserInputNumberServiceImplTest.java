package baseball.service;

import baseball.object.ThreeNumber;
import nextstep.test.NSTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputNumberServiceImplTest extends NSTest {

    UserInputNumberService userInputNumberService = UserInputNumberServiceImpl.getInstance();
    ThreeNumber result;

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    public void 정상() throws Exception {
        run("146");
        Assertions.assertThat(result.getFirst()).isEqualTo(1);
        Assertions.assertThat(result.getSecond()).isEqualTo(4);
        Assertions.assertThat(result.getThird()).isEqualTo(6);
    }

    @Test
    public void 세자리가아닌값입력() throws Exception {
       running("123123");
       verify("[ERROR] 1-9 로 이루어진 세자리 숫자를 입력해주세요.");
    }

    @Test
    public void 유효숫자가아닌수입력() throws Exception {
        running("023");
       verify("[ERROR] 1-9 로 이루어진 세자리의 올바른 수를 입력해주세요.");
    }

    @Override
    public void runMain() {
        result = userInputNumberService.userInputNumber();
    }
}
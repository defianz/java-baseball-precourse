package baseball.service;

import baseball.object.ThreeNumber;
import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


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
        assertThat(result.getFirst()).isEqualTo(1);
        assertThat(result.getSecond()).isEqualTo(4);
        assertThat(result.getThird()).isEqualTo(6);
    }

    @Test
    public void 세자리가아닌값입력() throws Exception {
       running("123123");
       verify("[ERROR] 1-9 로 이루어진 세자리 숫자를 입력해주세요.");
    }

    @Test
    public void 유효숫자가아닌수입력() throws Exception {
        running("107");
       verify("[ERROR] 1-9 로 이루어진 세자리의 올바른 수를 입력해주세요.");
    }

    @Override
    public void runMain() {
        result = userInputNumberService.inputUserNumber();
    }
}
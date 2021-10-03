package baseball.service;

import nextstep.test.NSTest;
import nextstep.utils.Console;
import nextstep.utils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class AfterGameServiceImplTest extends NSTest {

    AfterGameService afterGameService = AfterGameServiceImpl.getInstance();

    boolean result = false;

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    public void TRUE_1입력() throws Exception {
            run("1");
            assertThat(result).isTrue();
    }

    @Test
    public void FALSE_2입력() throws Exception {
        run("2");
        assertThat(result).isFalse();
    }

    @Test
    public void ERROR_1_2_아닌값_입력() throws Exception {
        running("12312");
        verify("[ERROR] 1 또는 2 를 입력해주세요.");
    }


    @Override
    public void runMain() {
        result = afterGameService.afterGame();
    }
}
package baseball.service;

import baseball.object.ThreeNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class CompareNumberServiceImplTest {

    CompareNumberService compareNumberService = CompareNumberServiceImpl.getInstance();

    private OutputStream captor;

    protected void setUp() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    public void 모두일치() throws Exception {
        // given
        ThreeNumber comNumber = new ThreeNumber(1,2,3);
        ThreeNumber userNumber = new ThreeNumber(1,2,3);
        //when
        boolean result = compareNumberService.compareNumber(comNumber, userNumber);

        //then
        assertThat(result).isTrue();
        assertThat("3스트라이크");
    }

    @Test
    public void 모두불일치() throws Exception {
        // given
        ThreeNumber comNumber = new ThreeNumber(1,2,3);
        ThreeNumber userNumber = new ThreeNumber(4,5,6);
        //when
        boolean result = compareNumberService.compareNumber(comNumber, userNumber);

        //then
        assertThat(result).isFalse();
        assertThat(output()).contains("낫싱");
    }

    @Test
    public void 투스트라이크() throws Exception {
        // given
        ThreeNumber comNumber = new ThreeNumber(4,5,7);
        ThreeNumber userNumber = new ThreeNumber(4,5,6);
        //when
        boolean result = compareNumberService.compareNumber(comNumber, userNumber);
        //then
        assertThat(result).isFalse();
        assertThat(output()).contains("2스트라이크");
    }

    @Test
    public void 원볼() throws Exception {
        // given
        ThreeNumber comNumber = new ThreeNumber(4,5,7);
        ThreeNumber userNumber = new ThreeNumber(1,2,5);
        //when
        boolean result = compareNumberService.compareNumber(comNumber, userNumber);
        //then
        assertThat(result).isFalse();
        assertThat(output()).contains("1볼");
    }

    @Test
    public void 원스트라이크원볼() throws Exception {
        // given
        ThreeNumber comNumber = new ThreeNumber(4,5,7);
        ThreeNumber userNumber = new ThreeNumber(4,7,2);
        //when
        boolean result = compareNumberService.compareNumber(comNumber, userNumber);
        //then
        assertThat(result).isFalse();
        assertThat(output()).contains("1스트라이크 1볼");
    }


    protected String output() {
        return captor.toString().trim();
    }

}
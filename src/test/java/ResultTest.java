import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ResultTest {

    @Test
    public void checkIsWinnerTrue(){
        Result result = new Result(4,0);
        assertThat(true, is(result.isWinner()));
    }

    @Test
    public void checkIsWinnerFalse(){
        Result result = new Result(2,2);
        assertThat(false, is(result.isWinner()));
    }


    @Test
    public void checkWrite(){
        Result result = new Result(2,2);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        result.write();
        assertThat( "2 blacks and 2 whites\n", is(outContent.toString()));
    }


}
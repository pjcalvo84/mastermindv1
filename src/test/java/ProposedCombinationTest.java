import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProposedCombinationTest {

    @Test
    public void checkWinnerTrue(){
        ProposedCombination pc = new ProposedCombination();
        Result result = new Result(4,0);
        pc.setResult(result);

        assertThat(true,is(pc.isWinner()));
    }

    @Test
    public void checkWinnerFalse(){
        ProposedCombination pc = new ProposedCombination();
        Result result = new Result(2,2);
        pc.setResult(result);

        assertThat(false,is(pc.isWinner()));
    }
}
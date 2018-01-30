import com.mcnulty.javaMillions.JavaMillions;
import com.mcnulty.javaMillions.JavaMillionsResult;
import com.mcnulty.javaMillions.JavaMillionsTicket;
import com.mcnulty.springLotto.SpringLotto;
import com.mcnulty.springLotto.SpringLottoResult;
import com.mcnulty.springLotto.SpringLottoTicket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class JavaMillionsTest {

    private JavaMillions lotto;

    @Before
    public void before() {
        lotto = new JavaMillions();
    }

    @Test
    public void Test1() {

        //arrange
        JavaMillionsTicket winningTicket = new JavaMillionsTicket(Arrays.asList(3, 7, 22, 34, 49, 4));
        JavaMillionsTicket usersTicket = new JavaMillionsTicket(Arrays.asList(3, 10, 22, 35, 49, 4));

        //act

        JavaMillionsResult result = lotto.calculate(winningTicket, usersTicket);

        //assert

        Assert.assertEquals(true, result.isWinner());
        Assert.assertEquals(5, result.getPrize().get().getPrizeClass());
        Assert.assertEquals(3, result.getMatchedPool1Values().size());
        Assert.assertEquals(1, result.getMatchesPool2Values().size());


    }

}

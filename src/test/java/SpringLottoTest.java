import com.mcnulty.springLotto.SpringLotto;
import com.mcnulty.springLotto.SpringLottoResult;
import com.mcnulty.springLotto.SpringLottoTicket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SpringLottoTest {

    private SpringLotto lotto;

    @Before
    public void before() {
        lotto = new SpringLotto();
    }

    @Test
    public void Test1() {

        //arrange
        SpringLottoTicket winningTicket = new SpringLottoTicket(Arrays.asList(7, 20, 4, 35, 1, 12));
        SpringLottoTicket usersTicket = new SpringLottoTicket(Arrays.asList(7, 4, 20, 35, 1, 12));

        //act

        SpringLottoResult result = lotto.calculate(winningTicket, usersTicket);

        //assert

        Assert.assertEquals(true, result.isWinner());
        Assert.assertEquals(3, result.getPrize().get().getPrizeClass());
        Assert.assertEquals(4, result.getMatchedValues().size());


    }

}

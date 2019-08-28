package job4j_fullstack;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculateText {
    @Test
    public void whenOnePlusOneThenTwo() {
        assertThat(
                new Calculate().add(1,1), is(2)
        );
    }
}

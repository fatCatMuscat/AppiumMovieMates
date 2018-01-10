package Utils;

import org.testng.annotations.Test;
import java.util.Random;

public class Hints {



    @Test
    public void getRandomInt() {
        Random random = new Random();
        System.out.println(random.nextInt(101));
    }

    public void getRandomInt100to200() {
        Random random = new Random();

        System.out.println(random.nextInt(101) + 100);
    }

    public void showSubstr(int fromWhich) {
        String str = "Hello World";
        String newString = str.substring(fromWhich);
    }

}

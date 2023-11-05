//Tal Ariel Ziv 326529138
//Submit user name: arielzt
/**
 * @author Tal Ariel Ziv < tal.arielziv@live.biu.ac.il >
 * @version assignment number 6
 * @since 7.6.2023
 */
import RunGame.GameFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Ass 6 game.
 */
public class Ass6Game {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            try {
                int num = Integer.parseInt(args[i]);
                if (num >= 1 && num <= 3) {
                    lst.add(num);
                }
            } catch (Exception ignored) {
            }
        }
        if (lst.size() == 0) {
            lst.add(1);
            lst.add(2);
            lst.add(3);
        }
        GameFlow gameFlow = new GameFlow();
        gameFlow.runLevels(lst);
    }
}

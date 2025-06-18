import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    @Test
    public void testWhenFirstPlayerWin() {
        Player artem = new Player(1, "Артем", 200);
        Player gena = new Player(2, "Гена", 100);

        game.register(artem);
        game.register(gena);

        int actual = game.round("Артем", "Гена");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player artem = new Player(1, "Артем", 100);
        Player gena = new Player(2, "Гена", 200);

        game.register(artem);
        game.register(gena);

        int actual = game.round("Артем", "Гена");
        int expected = 2;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenNotWinner() {
        Player artem = new Player(1, "Артем", 200);
        Player gena = new Player(2, "Гена", 200);

        game.register(artem);
        game.register(gena);

        int actual = game.round("Артем", "Гена");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testWhenFirstPlayerNotFound() {
        Player gena = new Player(2, "Гена", 100);


        game.register(gena);

        Assertions.assertThrows(
                NotRegisteredException.class, () -> game.round("Артем", "Гена")
        );
    }

    @Test
    public void testWhenSecondPlayerNotFound() {
        Player artem = new Player(1, "Артем", 100);


        game.register(artem);

        Assertions.assertThrows(
                NotRegisteredException.class, () -> game.round("Артем", "Гена")
        );

    }


}

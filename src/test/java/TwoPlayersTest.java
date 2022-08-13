import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TwoPlayersTest {
    ArrayList<Players> expected = new ArrayList<>();
    ArrayList<Players> actual = new ArrayList<>();

    Tournament game = new Tournament();

    Players player1 = new Players(1, "pl.1", 200);
    Players player2 = new Players(2, "pl.2", 200);

    @Test

    public void shouldRegisterPlayer() {

        expected.add(player1);

        game.register(player1);

        ArrayList<Players> actual = new ArrayList<>(game.players);

        Assertions.assertEquals(expected,actual);
    }

    @Test

    public void ifTheFirstPlayerIsNotRegistered() {

        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("pl.1", "pl.2");
        });
    }

    @Test

    public void ifTheSecondPlayerIsNotRegistered() {

        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("pl.1", "pl.2");
        });
    }

    @Test

    public void theFirstPlayerWin() {

        Tournament game = new Tournament();

        Players player1 = new Players(1, "pl.1", 300);
        Players player2 = new Players(2, "pl.2", 200);
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("pl.1", "pl.2");

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void theSecondPlayerWin() {

        Tournament game = new Tournament();

        Players player1 = new Players(1, "pl.1", 200);
        Players player2 = new Players(2, "pl.2", 300);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("pl.1", "pl.2");

        Assertions.assertEquals(expected, actual);

    }

    @Test

    public void draw() {

        Tournament game = new Tournament();

        Players player1 = new Players(1, "pl.1", 200);
        Players player2 = new Players(2, "pl.2", 200);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("pl.1", "pl.2");

        Assertions.assertEquals(expected, actual);

    }

}

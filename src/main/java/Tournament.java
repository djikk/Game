import java.util.ArrayList;

public class Tournament {

    protected ArrayList<Players> players = new ArrayList<>();

    public void register(Players player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Players player1 = null;
        Players player2 = null;


        for (Players player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }

            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);

        }

        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }

        return 2;

    }

}

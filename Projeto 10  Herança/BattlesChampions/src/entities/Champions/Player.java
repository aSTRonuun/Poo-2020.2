package entities.Champions;

import java.util.List;

public interface Player {
    String getName();
    boolean isAlive();
    int getHp();
    Player selectTarget(List<Player> lista);
    void attack(Player other);
    void takeDemage(int qtd, Player other);
    boolean ultimate(Player other);
}

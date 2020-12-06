package control.action;

import control.MonopolyGame;
import entity.Player;

public class MoveAction implements Action{

    private Player player;
    private int moveAmount;

    public MoveAction(Player player, int moveAmount) {
        this.player = player;
        this.moveAmount = moveAmount;
    }

    public MoveAction() {
    }

    @Override
    public void act() {
        if ( !player.isInJail() ) {
            boolean passedTheGoTile = player.move(moveAmount);
            MonopolyGame.getActionLog().addMessage(player.getName() + " moves " + moveAmount
                    + " squares (current position: " + player.getPosition() + ")\n");

            if (passedTheGoTile) {
                new PassAction(player).act();
            }
        }

    }
}

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    public Monster(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#01579B"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF3333"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public Position move() {
        return switch (new Random().nextInt(4)) {
            case 0 -> new Position(position.getX(), position.getY() - 1);
            case 1 -> new Position(position.getX() + 1, position.getY());
            case 2 -> new Position(position.getX(), position.getY() + 1);
            case 3 -> new Position(position.getX() - 1, position.getY());
            default -> new Position(position.getX(), position.getY());
        };
    }
}

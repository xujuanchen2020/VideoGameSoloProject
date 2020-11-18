package States;

import Gfx.Assets;
import Utils.ClickListener;
import TileGame.Handler;
import Utils.UIImageButton;
import Utils.UIManager;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
//        if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()) {
//            State.setState(handler.getGame().gameState);
//        }
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
//        g.setColor(Color.RED);
//        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
        uiManager.render(g);
    }

}

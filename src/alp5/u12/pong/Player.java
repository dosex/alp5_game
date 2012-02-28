package alp5.u12.pong;

import org.lwjgl.input.Keyboard;

public class Player extends Entity {

	protected boolean player1;
	private float speed = 4.0f;
	
	public Player(Game game, String ref, boolean player1) {
		super(game, game.getSprite(ref), true);
		this.player1 = player1;
		x = (this.player1) ? 0+16 : game.width-boxWidth-16;
		y = (game.height-boxHeight)/2;
		dx = 0;
		dy = 0;
	}

	public void move() {
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) 
			y = (y-speed > 0) ? y-speed : 0;
		if (Keyboard.isKeyDown(Keyboard.KEY_UP))
			y = (y+speed < height-boxHeight) ? y+speed : height-boxHeight;
	}
	
	public int collides(Ball ball) {
		int val = 0;
		//right player
		if (!player1) { 
			if ((ball.x+ball.boxWidth >= x) && (ball.y+ball.boxHeight >= y) && (ball.y <= y+boxHeight)) {
				ball.x = x-ball.boxWidth;
				if ((Keyboard.isKeyDown(Keyboard.KEY_DOWN) && ball.dy < 0) || (Keyboard.isKeyDown(Keyboard.KEY_UP) && ball.dy > 0)) {
					val = 4;
				} else if ((Keyboard.isKeyDown(Keyboard.KEY_DOWN) && ball.dy > 0) || (Keyboard.isKeyDown(Keyboard.KEY_UP) && ball.dy < 0)) {
					val = 16;
				} else val = 8;
				
			}
		//left player	
		} else {
			if((ball.x <= x+boxWidth) && (ball.y+ball.boxHeight >= y) && (ball.y <= y+boxHeight)) {
				ball.x = x+boxWidth;
				if ((Keyboard.isKeyDown(Keyboard.KEY_DOWN) && ball.dy < 0) || (Keyboard.isKeyDown(Keyboard.KEY_UP) && ball.dy > 0)) {
					val = 4;
				} else if ((Keyboard.isKeyDown(Keyboard.KEY_DOWN) && ball.dy > 0) || (Keyboard.isKeyDown(Keyboard.KEY_UP) && ball.dy < 0)) {
					val = 16;
				} else val = 8;
			}
		}
		return val;
	}
	
	public void setSpeed(float dx, float dy) {
		this.dx = dx;
		this.dy = dy;
	}

	@Override
	public void handleCollision(int val) {
		// TODO Auto-generated method stub
	}
}

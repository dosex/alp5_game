package alp5.u12.pong;

import java.util.Random;

public class Ball extends Entity {
	
	private Random random = new Random();
	private final int startDist = 48;
	private final int maxSpeed = 8;

	public Ball(Game game, String ref, float x, float y) {
		super(game, game.getSprite(ref), true);
		this.x = x;
		this.y = y;
		dx = 0;
		dy = 0;
	}

	// collisions:	none = 0	upper = lower = 1	left = right = 2
	public void handleCollision(int val) {
		if ((val & 1) == 1)
			dy = -dy;
		if ((val & 2) == 2)
			dx = -dx;
		if ((val & 4) == 4){ // ball hits player (both in same direction)
			dx = -dx*1.15f;
			if (Math.abs(dy) > 2.0f)
				dy = dy*0.8f;
			else {
				dx = dx*0.8f;
				dy = dy*1.5f;
			}
			System.out.println("same");
		}
		if ((val & 8) == 8){ // ball hits player without movement
			dx = -dx*1.01f;
			System.out.println("no move");
		}	
		if ((val & 16) == 16){ // ball hits player (both in different directions)
			if (Math.sqrt(dx*dx + dy*dy) < maxSpeed) {
				dx = -dx*1.1f;
				dy = dy*1.4f;
			}
			System.out.println("different");
		}
	}
	
	public void move() {
		float f = 1.0f;
		int spriteWidth = sprite.getWidth();
		int spriteHeight = sprite.getHeight();
		if (x+spriteWidth + dx > width)
			f = (width-(x+spriteWidth))/dx;
		else if (x + dx < 0)
			f = x/-dx;
		if (y+spriteHeight + dy > height)
			f = (height-(y+spriteHeight))/dy;
		else if (y + dy < 0)
			f = y/-dy;
		x += dx*f;
		y += dy*f;
	}
	
	public void setSpeed(float dx, float dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void serve(int player) {
		if (player == 1) {
			y = random.nextInt(height-boxHeight);
			x = startDist;
			dx = 3 + random.nextInt(2);
			dy = -2 + random.nextInt(2);
		} else {
			y = random.nextInt(height-boxHeight);
			x = width-startDist;
			dx = -5 + random.nextInt(2);
			dy = -2 + random.nextInt(2);
		}
	}
}

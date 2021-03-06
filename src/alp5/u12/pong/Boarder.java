package alp5.u12.pong;

import alp5.u12.pong.entitys.Entity;

public class Boarder {
	
	private int heigth,width;
	
	public Boarder(Game game) {
		heigth = game.height;
		width = game.width;
	}

	// collisions:	none = 0	upper = lower = 1	left = right = 2
	public int collides(Entity entity) {
		int val = 0;
		if (entity.x <= 0)
			val = 64;
		else if (entity.x+entity.boxWidth >= width)
			val = 32;
		if (entity.y <= 0)
			val += 1;
		else if (entity.y+entity.boxHeight >= heigth)
			val += 1;
		return val;
	}
}

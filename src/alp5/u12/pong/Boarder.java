package alp5.u12.pong;

public class Boarder {
	
	private int heigth,width;
	
	public Boarder(Game game) {
		heigth = game.height;
		width = game.width;
	}

	// collisions:	none = 0	upper = lower = 1	left = right = 2
	public int collides(Entity entity) {
		int val = 0;
		int entityWidth = entity.sprite.getWidth();
		int ballHeight = entity.sprite.getHeight();
		if (entity.x <= 0)
			val = 2;
		else if (entity.x+entityWidth >= width)
			val = 2;
		if (entity.y <= 0)
			val += 1;
		else if (entity.y+ballHeight >= heigth)
			val += 1;
		return val;
	}
}

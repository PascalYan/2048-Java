import java.awt.Color;
public class ColorOfGrid {
	private Color color;
	
	ColorOfGrid(int num){
		switch(num)
		{
			case 2:this.setColor(new Color(123,230,153));break;
			case 4:this.setColor(new Color(35,175,177));break;
			case 8:this.setColor(new Color(88,255,182));break;
			case 16:this.setColor(new Color(17,131,82));break;
			case 32:this.setColor(new Color(199,252,54));break;
			case 64:this.setColor(new Color(105,138,15));break;
			case 128:this.setColor(new Color(255,192,93));break;
			case 256:this.setColor(new Color(164,155,39));break;
			case 512:this.setColor(new Color(255,84,0));break;
			case 2048:this.setColor(new Color(192,54,17));break;
			case 4096:this.setColor(new Color(252,15,255));break;
			default: this.setColor(new Color(228,223,223));
		}
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	    
}

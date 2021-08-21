package chessBoard;
//Name: Harsh Rana
		
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Rectangle2D;


public class Box{
	private Rectangle2D.Double box;
  
       
	public Box(double x, double y, double width){
		box = new Rectangle2D.Double(x,y,width, width);
		
	}

	public void draw(Graphics2D g2){
		g2.draw(box);
	}

	public void fill(Graphics2D g2){
		g2.draw(box);
		g2.setColor(new Color(204,102,0));
		g2.fill(box);
	}
}
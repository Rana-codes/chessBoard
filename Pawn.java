package chessBoard;
//Name: Harsh Rana


import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Pawn extends Piece{
	
	private BufferedImage img;
	public Pawn( int color, int x, int y)  {
		
		super(color,x,y);
	 	try{
	 		if(color==Def.BLACK)
				img = ImageIO.read(new File(Def.PAWN_BLACK));
			else
				img = ImageIO.read(new File(Def.PAWN_WHITE));

		} catch  (IOException e) {
			// We will learn about this later
			// For now just use it as is.
    
		}
	}
	

	public int getType(){
		return Def.PAWN;
	}	
	
	public void draw(Graphics2D g2) {
		int offsetX = (Def.LENGTH-img.getWidth())/2;
		int offsetY = (Def.LENGTH-img.getHeight())/2;
		g2.drawImage(img, offsetX+Def.GAP+getX()*Def.LENGTH, offsetY+Def.GAP+getY()*Def.LENGTH, img.getWidth(), img.getHeight(), null);
	}
	
}

class King extends Piece{
	
	private BufferedImage img;
	public King( int color, int x, int y)  {
		
		super(color,x,y);
	 	try{
	 		if(color==Def.BLACK)
				img = ImageIO.read(new File(Def.KING_BLACK));
			else
				img = ImageIO.read(new File(Def.KING_WHITE));

		} catch  (IOException e) {
			// We will learn about this later
			// For now just use it as is.
    
		}
	}
	

	public int getType(){
		return Def.KING;
	}	
	
	public void draw(Graphics2D g2) {
		int offsetX = (Def.LENGTH-img.getWidth())/2;
		int offsetY = (Def.LENGTH-img.getHeight())/2;
		g2.drawImage(img, offsetX+Def.GAP+getX()*Def.LENGTH, offsetY+Def.GAP+getY()*Def.LENGTH, img.getWidth(), img.getHeight(), null);
	}
	
}


class Knight extends Piece{
	
	private BufferedImage img;
	public Knight( int color, int x, int y)  {
		
		super(color,x,y);
	 	try{
	 		if(color==Def.BLACK)
				img = ImageIO.read(new File(Def.KNIGHT_BLACK));
			else
				img = ImageIO.read(new File(Def.KNIGHT_WHITE));

		} catch  (IOException e) {
			// We will learn about this later
			// For now just use it as is.
    
		}
	}
	

	public int getType(){
		return Def.KNIGHT;
	}	
	
	public void draw(Graphics2D g2) {
		int offsetX = (Def.LENGTH-img.getWidth())/2;
		int offsetY = (Def.LENGTH-img.getHeight())/2;
		g2.drawImage(img, offsetX+Def.GAP+getX()*Def.LENGTH, offsetY+Def.GAP+getY()*Def.LENGTH, img.getWidth(), img.getHeight(), null);
	}
	
}


class Bishop extends Piece{
	
	private BufferedImage img;
	public Bishop( int color, int x, int y)  {
		
		super(color,x,y);
	 	try{
	 		if(color==Def.BLACK)
				img = ImageIO.read(new File(Def.BISHOP_BLACK));
			else
				img = ImageIO.read(new File(Def.BISHOP_WHITE));

		} catch  (IOException e) {
			// We will learn about this later
			// For now just use it as is.
    
		}
	}
	

	public int getType(){
		return Def.BISHOP;
	}	
	
	public void draw(Graphics2D g2) {
		int offsetX = (Def.LENGTH-img.getWidth())/2;
		int offsetY = (Def.LENGTH-img.getHeight())/2;
		g2.drawImage(img, offsetX+Def.GAP+getX()*Def.LENGTH, offsetY+Def.GAP+getY()*Def.LENGTH, img.getWidth(), img.getHeight(), null);
	}
	
}



class Queen extends Piece{
	
	private BufferedImage img;
	public Queen( int color, int x, int y)  {
		
		super(color,x,y);
	 	try{
	 		if(color==Def.BLACK)
				img = ImageIO.read(new File(Def.QUEEN_BLACK));
			else
				img = ImageIO.read(new File(Def.QUEEN_WHITE));

		} catch  (IOException e) {
			// We will learn about this later
			// For now just use it as is.
    
		}
	}
	

	public int getType(){
		return Def.QUEEN;
	}	
	
	public void draw(Graphics2D g2) {
		int offsetX = (Def.LENGTH-img.getWidth())/2;
		int offsetY = (Def.LENGTH-img.getHeight())/2;
		g2.drawImage(img, offsetX+Def.GAP+getX()*Def.LENGTH, offsetY+Def.GAP+getY()*Def.LENGTH, img.getWidth(), img.getHeight(), null);
	}
	
}

class Rook extends Piece{
	
	private BufferedImage img;
	public Rook( int color, int x, int y)  {
		
		super(color,x,y);
	 	try{
	 		if(color==Def.BLACK)
				img = ImageIO.read(new File(Def.ROOK_BLACK));
			else
				img = ImageIO.read(new File(Def.ROOK_WHITE));

		} catch  (IOException e) {
			// We will learn about this later
			// For now just use it as is.
    
		}
	}
	

	public int getType(){
		return Def.ROOK;
	}	
	
	public void draw(Graphics2D g2) {
		int offsetX = (Def.LENGTH-img.getWidth())/2;
		int offsetY = (Def.LENGTH-img.getHeight())/2;
		g2.drawImage(img, offsetX+Def.GAP+getX()*Def.LENGTH, offsetY+Def.GAP+getY()*Def.LENGTH, img.getWidth(), img.getHeight(), null);
	}
	
}

class Dummy extends Piece{

	public Dummy(int x, int y) {
		super(x, y);
	}
	
	public int getType(){
		return Def.DUMMY;
	}

	public void draw(Graphics2D g2) {
		
		
	}
	
}




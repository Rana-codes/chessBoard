package chessBoard;
//Name: Harsh Rana

import java.awt.Graphics2D;
public abstract class Piece{
	private int x;
	private int y;
	private int color;
	// Constructor used by Dummies 
	public Piece(int x, int y){
		this.x = x;
		this.y = y;
		this.color = Def.NO_COLOR;
	}
	// constructor used by chess pieces
	public Piece(int color, int x, int y){
		this.x=x;
		this.y=y;
		this.color=color;
	}

	public int getColor(){
		return color;
	}

	public void move(int x, int y){
		this.x=x;
		this.y=y;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	abstract public void draw(Graphics2D g2);
	abstract public int getType();

}



package chessBoard;
//Name: Harsh Rana

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
*/
public class ChessBoard{
	private int SIZE =8;
	private Box[][] board;
	private Piece [][] pieces;
	private BufferedImage sideimg;
	private BufferedImage topimg;

	public ChessBoard() throws IOException{
		
		board = new Box[SIZE][SIZE];
		pieces = new Piece[SIZE][SIZE];
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				board[i][j] = new Box(Def.GAP+j*Def.LENGTH, Def.GAP+i*Def.LENGTH, Def.LENGTH);
			}
		}
		
		sideimg = ImageIO.read(new File(Def.SIDE_LABEL));
		topimg = ImageIO.read(new File(Def.TOP_LABEL));

		
		populate();
	}

	public void draw(Graphics2D g2)
	{  
		
		g2.drawImage(sideimg, Def.GAP-20, Def.GAP, 20, Def.LENGTH*8, null, null);
		g2.drawImage(sideimg, Def.GAP+Def.LENGTH*8, Def.GAP, 20, Def.LENGTH*8, null, null);
		g2.drawImage(topimg, Def.GAP, Def.GAP-20, Def.LENGTH*8, 20, null, null);
		g2.drawImage(topimg, Def.GAP, Def.GAP+Def.LENGTH*8, Def.LENGTH*8, 20, null, null);
		
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				if((i+j)%2==0)
					board[i][j].draw(g2);
				else
					board[i][j].fill(g2);
			}
		}
		
		// nested loop has not been used as there are only 8 elements.
		// nested loop would simply increase the complexity.
		for(int i=0; i<8;i++) {
			pieces[i][0].draw(g2);
			pieces[i][1].draw(g2); 
			pieces[i][2].draw(g2);
			pieces[i][3].draw(g2);
			pieces[i][4].draw(g2);
			pieces[i][5].draw(g2); 
			pieces[i][6].draw(g2);
		    pieces[i][7].draw(g2);
		}
		
		
	}

	public void populate(){
	
		
		for(int i=0; i<8;i++) {
			pieces[i][1] = new Pawn(Def.BLACK, i,1);
			pieces[i][6] = new Pawn(Def.WHITE, i,6); 
		}
		
		//Nested loop has not been used as it wasn't saving a lot of work
		//but was just increasing complexity.
		
		pieces[0][0] = new Rook(Def.BLACK,0,0);
		pieces[7][0] = new Rook(Def.BLACK,7,0); 
		pieces[0][7] = new Rook(Def.WHITE,0,7);
		pieces[7][7] = new Rook(Def.WHITE,7,7); 
		                                     
		pieces[1][0] = new Knight(Def.BLACK,1,0);
		pieces[6][0] = new Knight(Def.BLACK,6,0); 
		pieces[1][7] = new Knight(Def.WHITE,1,7);
		pieces[6][7] = new Knight(Def.WHITE,6,7);
		         
		pieces[2][0] = new Bishop(Def.BLACK,2,0);
		pieces[5][0] = new Bishop(Def.BLACK,5,0); 
		pieces[2][7] = new Bishop(Def.WHITE,2,7);
		pieces[5][7] = new Bishop(Def.WHITE,5,7);
		         
		pieces[3][0] = new Queen(Def.BLACK ,3,0);
		pieces[4][0] = new King(Def.BLACK,4,0); 
		pieces[3][7] = new Queen(Def.WHITE ,3,7);
		pieces[4][7] = new King(Def.WHITE,4,7);
		
		for(int i = 0; i<8; i++) {
			pieces[i][2] = new Dummy(i,2);
			pieces[i][3] = new Dummy(i,3);
			pieces[i][4] = new Dummy(i,4);
			pieces[i][5] = new Dummy(i,5);
			
		}
		
	}
	
	public Piece getPiece(int x, int y) {
		return pieces[x][y];
	}

	public void swapPiece(int x1, int y1, int x2, int y2) {
		Piece temp = pieces[x1][y1];
		pieces[x1][y1] = pieces[x2][y2];
		pieces[x2][y2] = temp;
	}
	
	public void setDummy(int x1, int y1) {
		pieces[x1][y1] = new Dummy(x1,y1);
	}
}

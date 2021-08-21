package chessBoard;

//Name: Harsh Rana

import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
public class GameControllerComponent extends JComponent{
	private ChessBoard theBoard;
	private int clickCount = 0;
	Ellipse2D.Double gola = new Ellipse2D.Double(0,0,0,0);
	
	
	public GameControllerComponent() throws IOException{
		theBoard = new ChessBoard();
		theBoard.populate();
	}	

	public void start(){
		
		addMouseListener(new MouseAdapter() { 
			
			int x1 =0; int x2 = 0; int y1 = 0; int y2 = 0;
			 
			String Start = "0,0";
			String End = "0,0";
			boolean from = false;
			boolean to = false;
			int turn = 1;
			public void mouseClicked(MouseEvent event) {
				clickCount++;
				
				int x = event.getX() + Def.GAP;
				int y = event.getY() + Def.GAP;
				
				int column = (x / Def.LENGTH)-1;
				int row = (y / Def.LENGTH) -1 ;
				
				
				if(clickCount % 2 == 0) {
					x2 = column;
					y2 = row;
					End = column+","+row;
					to = true;
					repaint();
				}
				else {
					x1 = column;
					y1 = row;
					Start = column+","+row;
					from = true;
					gola = new Ellipse2D.Double(x1*Def.LENGTH+Def.GAP,y1*Def.LENGTH+Def.GAP,Def.LENGTH,Def.LENGTH);
					repaint();
				}
				
				if(from == true && to == true) {
					if(validInput(Start,End) == true) {
						theBoard.setDummy(x2, y2);
						theBoard.getPiece(x1, y1).move(x2, y2);
						
						theBoard.swapPiece(x1, y1, x2, y2);
						turn ++;
						repaint();
					}
					to = false;
					from = false;
				}
				
				
				
			}

			public void mousePressed(MouseEvent event) {}
			public void mouseReleased(MouseEvent event) {}
			public void mouseEntered(MouseEvent event) {}
			public void mouseExited(MouseEvent event) {}
		});
	}
	private boolean validInput(String start, String end){
		int x1 = Integer.parseInt(start.substring(0, start.indexOf(',')));
		int y1 = Integer.parseInt(start.substring(start.indexOf(',')+1,start.length()));
		int x2 = Integer.parseInt(end.substring(0, end.indexOf(',')));
		int y2 = Integer.parseInt(end.substring(end.indexOf(',')+1,end.length()));
		
		if(x1 < 0 || x1>7 || y1<0 || y1>7 ) {
			return false;
		}
		if(x2 < 0 || x2>7 || y2<0 || y2>7 ) {
			return false;
		}
		if(theBoard.getPiece(x2, y2).getColor() == theBoard.getPiece(x1, y1).getColor()) {
			return false;
		}
		if(((theBoard.getPiece(x1, y1).getColor() == Def.NO_COLOR)&(theBoard.getPiece(x2, y2).getColor() != Def.NO_COLOR))) {
			return false;
			
		}
		return true;
	}
	public void paintComponent(Graphics g)
	{  
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		theBoard.draw(g2);
		
		if(clickCount %2 != 0) {
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.black);
			g2.draw(gola);
		}
	}
}


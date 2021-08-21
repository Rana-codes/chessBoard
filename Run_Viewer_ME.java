package chessBoard;
//Name: Harsh Rana

import java.awt.BorderLayout;
import java.io.IOException;

//Student ID: 100351582

import javax.swing.JFrame;

public class Run_Viewer_ME {
	public static void main(String[] args) throws IOException {
		GameControllerComponent component = new GameControllerComponent();
		

		JFrame frame = new JFrame();
		
		frame.setLayout(new BorderLayout());

		frame.add(component,BorderLayout.CENTER);
		

		final int FRAME_WIDTH = 640;
		final int FRAME_HEIGHT = 640;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

		// Note that you should call after set frame to visible.
		component.start();
	}
}

/* Created by: Hanz Nathan Po
 * Date created: Sept 29, 2022
 * Last updated: Sept 29, 2022
 * Description: Simple program to test graphics in Java
 */

import java.awt.*;
import javax.swing.JFrame;

public class GraphicsAssignment extends Canvas {

	private static final long serialVersionUID = 5817297510347074747L;


	public GraphicsAssignment(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(512, 512);
		frame.setVisible(true);
		frame.add(this);
	}
	
	public void init() {
		
	}
	
	public static void main(String[] args) {
		new GraphicsAssignment("My program");
	}
	

	public void paint (Graphics g) {
		g.setFont(new Font("Times New Roman", Font.ITALIC, 36));
		g.drawRect(10, 10, 20, 20);
		g.drawString("Hello world\nNext line", 20, 50);
	}
}

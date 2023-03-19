import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

//Class Amir
public class DrawTriangle extends DrawingProgram {

	// Initialize variables
	private int clicks = 0; // to count number of user clicks
	private int[] Xcordi = new int[3]; // because have 3 vertex of x
	private int[] Ycordi = new int[3]; // because have 3 vertex of y

	DrawTriangle() {
		JBTriangle.setBackground(Color.LIGHT_GRAY);
	}

	public void paint(Graphics g) {
		super.paintComponents(g); // Clear canvas
		Draw(g); // call function draw
	} // end of function

	public void mouseClicked(MouseEvent me) {

		// Change label content using setText
		setLabelCounter(); // Call function setLabelCounter

		setCordi(me); // Call function setCordi
		clicks++; // Increment 1 user click 1 time

		if (clicks == 2) {
			clicks = 0; // Reset clicks variables to 0
			repaint(); // Automatically calls paint function
		}
	} // end of function
	
	public void setCordi(MouseEvent me) {
		Xcordi[clicks] = (int) me.getX();
		Ycordi[clicks] = (int) me.getY();
	}	

	public void setLabelCounter() {
		counter.setText("Current number of clicks : " + (clicks + 1)); // Change label content using setText
	}
	
	public void Draw(Graphics g) {

		// Initialize variables //90 degree of (X0,Y0) & (X1,Y1) = (x1,y0)
		Xcordi[2] = Xcordi[1];
		Ycordi[2] = Ycordi[0];

		// adjust the shape with the drawCoordinates
		Xcordi[0] = Xcordi[0] + 8;
		Xcordi[1] = Xcordi[1] + 8;
		Xcordi[2] = Xcordi[2] + 8;

		Ycordi[0] = Ycordi[0] + 47;
		Ycordi[1] = Ycordi[1] + 47;
		Ycordi[2] = Ycordi[2] + 47;

		// Draw Right angle triangle
		if (Xcordi[0] < Xcordi[1]) { // if on the right side
			drawCoordinates(g);
			g.drawPolygon(Xcordi, Ycordi, 3); // why 3 because of the 3 vertex of the triangle
		} else if (Xcordi[0] > Xcordi[1]) { // if on the left side
			drawCoordinates(g);
			g.drawPolygon(Xcordi, Ycordi, 3);
		}
	}

	public void drawCoordinates(Graphics g) {
		g.fillOval(Xcordi[0] - 2, Ycordi[0], 4, 4); // Create a small circle1
		g.fillOval(Xcordi[1] - 2, Ycordi[1], 4, 4); // create a small circle2
		g.drawString("Click 1 = (" + Integer.toString(Xcordi[0]) + "," + Integer.toString(Ycordi[0]) + ")", Xcordi[0],
				Ycordi[0]); // Label/Draw coordinates to canvas
		g.drawString("Click 2 = (" + Integer.toString(Xcordi[1]) + "," + Integer.toString(Ycordi[1]) + ")", Xcordi[1],
				Ycordi[1]);
	} // end of function

}

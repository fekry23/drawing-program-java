import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

//Class Engku
public class DrawRectangle extends DrawingProgram {

	// Initialize variables
	private int height = 0;
	private int width = 0;
	private int clicks = 0; // to count number of user clicks
	private int[] Xcordi = new int[2];
	private int[] Ycordi = new int[2];

	DrawRectangle() {
		JBRectangle.setBackground(Color.LIGHT_GRAY);
	}

	public void paint(Graphics g) {
		super.paintComponents(g); // Clear canvas

		// Initialize variables
		height = Math.abs((Ycordi[1] - Ycordi[0]));
		width = Math.abs((Xcordi[1] - Xcordi[0]));

		Draw(g);
	} // end of function

	public void mouseClicked(MouseEvent me) {
		setLabelCounter(); //Call function setLabelCounter to set the label counter
		setCordi(me); //Call function setCordi to get coordinates
		clicks++; // Increment 1 user click 1 time

		if (clicks == 2) {
			clicks = 0; // Reset clicks variables to 0
			repaint(); // Automatically calls paint function
		}
	} // end of function
	
	public void setCordi(MouseEvent me) {
		// Save coordinates into variables
		Xcordi[clicks] = (int) me.getX();
		Ycordi[clicks] = (int) me.getY();
	}

	public void setLabelCounter() {
		counter.setText("Current number of clicks : " + (clicks + 1)); // Change label content using setText
	}

	public void Draw(Graphics g) {
		// Draw Rectangle
		if (Xcordi[0] < Xcordi[1]) { // X1 is lesser than X2
			drawCoordinates(g);
			g.drawRect(Xcordi[0] + 5, Ycordi[0] + 45, width, height); // Use Click 1 coordinates as our pivot point
			if (Ycordi[0] > Ycordi[1]) { // Y1 is larger than Y2
				super.paintComponents(g);
				drawCoordinates(g);
				g.drawRect(Xcordi[0] + 5, Ycordi[1] + 45, width, height); // Use X1, Y2 as our pivot point
			}
		} else if (Xcordi[0] > Xcordi[1]) { // X1 is larger than X2
			drawCoordinates(g);
			g.drawRect(Xcordi[1] + 5, Ycordi[1] + 45, width, height); // Use Click 2 coordinates as our pivot point
			if (Ycordi[0] < Ycordi[1]) { // Y1 is lesser than Y2
				super.paintComponents(g);
				drawCoordinates(g);
				g.drawRect(Xcordi[1] + 5, Ycordi[0] + 45, width, height); // Use X2 , Y1 as our pivot points
			}
		}
	}

	public void drawCoordinates(Graphics g) {
		g.fillOval(Xcordi[0] + 4, Ycordi[0] + 45, 4, 4); // Create a small circle
		g.fillOval(Xcordi[1] + 4, Ycordi[1] + 45, 4, 4);
		g.drawString("Click 1 = (" + Integer.toString(Xcordi[0]) + "," + Integer.toString(Ycordi[0]) + ")",
				Xcordi[0] + 5, Ycordi[0] + 45); // Label/Draw coordinates to canvas
		g.drawString("Click 2 = (" + Integer.toString(Xcordi[1]) + "," + Integer.toString(Ycordi[1]) + ")",
				Xcordi[1] + 5, Ycordi[1] + 45);
	} // end of function

} // end of class
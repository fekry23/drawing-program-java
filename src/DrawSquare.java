import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

//Class Fekry
public class DrawSquare extends DrawingProgram { // inherits DrawingProgram
	
	// Initialize variables
	private int clicks = 0; // to count number of user clicks
	private int height = 0;
	private int width = 0;
	private int[] Xcordi = new int[2];
	private int[] Ycordi = new int[2];	
	
	DrawSquare(){
		JBSquare.setBackground(Color.LIGHT_GRAY);
	}


	public void paint(Graphics g) {
		super.paintComponents(g); // Clear canvas
		setHeight(); // Initialize variables
		setWidth();
		Draw(g); //Draw Square
	} // end of function

	public void mouseClicked(MouseEvent me) {

		setLabelCounter();

		// Save coordinates into variables
		setCordi(me);
		clicks++; // Increment 1 user click 1 time
		
		if (clicks == 2) {
			clicks = 0; // Reset clicks variables to 0
			repaint(); // Automatically calls paint function
		}
	} // end of function
	
	public void setHeight() {
		height = Math.abs((Xcordi[0] - Xcordi[1])); // X1 - X2 to get the height
	} // end of function
	
	public void setWidth() {
		width = Math.abs((Xcordi[0] - Xcordi[1])); // Square = Height and width are equivalent
	} // end of function
	
	public void setCordi(MouseEvent me) {
		Xcordi[clicks] = (int) me.getX();
		Ycordi[clicks] = (int) me.getY();
	} // end of function
	
	public void setLabelCounter() {
		counter.setText("Current number of clicks : " + (clicks + 1)); // Change label content using setText
	} // end of function
	
	// Draw Square
	public void Draw(Graphics g) {
		
		if (Xcordi[0] < Xcordi[1]) { // X1 is lesser than X2
			
			drawCoordinates(g);
			g.drawRect(Xcordi[0] + 5, Ycordi[0] + 45, width, height); // Use Click 1 coordinates as our pivot point
			
			if (Ycordi[0] > Ycordi[1]) { // Y1 is larger than Y2
				
				super.paintComponents(g);
				drawCoordinates(g);
				g.drawRect(Xcordi[0] + 5, Ycordi[1] + 45, width, height); // Use X1, Y2 as our pivot point
				
			} // end of if statement
		} else if (Xcordi[0] > Xcordi[1]) { // X1 is larger than X2
			
			drawCoordinates(g);
			g.drawRect(Xcordi[1] + 5, Ycordi[1] + 45, width, height); // Use Click 2 coordinates as our pivot point
			
			if (Ycordi[0] < Ycordi[1]) { // Y1 is lesser than Y2
				
				super.paintComponents(g);
				drawCoordinates(g);
				g.drawRect(Xcordi[1] + 5, Ycordi[0] + 45, width, height); // Use X2 , Y1 as our pivot points
				
			} // end of if statement
			
		} // end of if else statement
		
	} //end of function
	
	public void drawCoordinates(Graphics g) {
		
		g.fillOval(Xcordi[0] + 4, Ycordi[0] + 45, 4, 4); // Create a small circle
		g.fillOval(Xcordi[1] + 4, Ycordi[1] + 45, 4, 4);
		g.drawString("Click 1 = (" + Integer.toString(Xcordi[0]) + "," + Integer.toString(Ycordi[0]) + ")",
				Xcordi[0] + 5, Ycordi[0] + 45); // Label/Draw coordinates to canvas
		g.drawString("Click 2 = (" + Integer.toString(Xcordi[1]) + "," + Integer.toString(Ycordi[1]) + ")",
				Xcordi[1] + 5, Ycordi[1] + 45);
		
	} // end of function

} // end of class

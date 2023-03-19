import java.awt.*;
import java.awt.event.*;

//Class Daniel

public class DrawCircle extends DrawingProgram {

	public Point p1 = new Point();// to save 1st point click
	public Point p2 = new Point();// to save 2nd point click

	public int r = 0;// to save radius
	private int cnt = 0;// to count the clicks

	DrawCircle() {
		JBCircle.setBackground(Color.LIGHT_GRAY);
	}

	public void paint(Graphics g) {
		super.paintComponents(g);// to repaint so the canvas reset become empty
		if (p1 != null && p2 != null) {// got point 1 and point 2 then start drawing
			cRadius();// calls function to count radius
			Draw(g); // calls function to draw
			drawCoordinates(g);
		}
	}

	public void mouseClicked(MouseEvent me) {
		// Save coordinates into variables
		if (p1 != null && p2 != null) {// when something is drawn then to reset for the next shape to draw
			setPoint();// function to set point 1&2 or NULL
			cnt = 0;// RESET CLICK COUNT
			setLabelCounter(); // call function setLabelCounter
		} else if (p1 == null && p2 == null) { // to get 1ST CLICK
			p1 = me.getPoint();// to SET POINT 1 to POINT 1ST CLICK
			cnt++;// plus 1 at TOTAL CLICK
		} else {// to get 2ND CLICK
			p2 = me.getPoint();// to SET POINT 2 to POINT 2ND CLICK
			cnt++;// plus 1 at TOTAL CLICK
		}
		setLabelCounter(); // call function setLabelCounter
		repaint();
	} // end of function

	public void cRadius()// function to count radius
	{
		r = Math.round((int) p1.distance(p2));// FORMULA to get RADIUSDISTANCE from 1ST CLICK to 2ND CLICK
	}

	public int getD()// to get the diameter
	{
		return (2 * r);// RETURN VALUE DIAMETER
	}

	public void setPoint()// to reset value point so it can draw the next circle
	{
		p1 = null;// RESET POINT 1 to NULL
		p2 = null;// RESET POINT 2 to NULL
	}
	
	public void setLabelCounter() {
		counter.setText("Current number of clicks : " + (cnt));// REWRITE TOTAL CLICK
	}

	public void Draw(Graphics g) {
		g.drawOval(p1.x - r + 5/* to call coordinate X */, p1.y - r + 45/* to call coordinate Y */,
				getD()/* to call the diameter width */, getD()/* to call the diameter height */);// to draw circle
	}

	public void drawCoordinates(Graphics g) {
		g.fillOval(p1.x + 3, p1.y + 43, 4, 4); // Create a small circle
		g.fillOval(p2.x + 3, p2.y + 43, 4, 4);
		g.drawString("Click 1 = (" + Integer.toString(p1.x) + "," + Integer.toString(p1.y) + ")", p1.x + 5, p1.y + 45); // Label/Draw
																														// coordinates
																														// to
																														// canvas
		g.drawString("Click 2 = (" + Integer.toString(p2.x) + "," + Integer.toString(p2.y) + ")", p2.x + 5, p2.y + 45);
	}
}
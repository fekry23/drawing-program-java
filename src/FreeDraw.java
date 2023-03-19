import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class FreeDraw extends DrawingProgram {
	
	FreeDraw(){
		JBFreeDraw.setBackground(Color.LIGHT_GRAY);
	}
	
	public void paint(Graphics g) {

		// To activate all of the tool bar and button
		if (activate == 1) {
			super.paintComponents(g);
			activate = 0;
		}

		g.setColor(penColor); // change pen color
		g.fillOval(mousePnt.x + 5, mousePnt.y + 45, pen, pen); // fillOval(int x, int y, int width, int height)
	}	
	
	public void mouseDragged(MouseEvent me) { // Drawing happens when we press and drag the mouse
		mousePnt = me.getPoint(); // return the coordinates x and y
		repaint(); // predefined method to refresh the screen, it will also automatically call
					// function paint
	}

	public void stateChanged(ChangeEvent e) { // When interact with slider, it will fire ChangeEvent
		source = (JSlider) e.getSource(); // Get value from the slider when user interact with it
		if (!source.getValueIsAdjusting()) { // Check if the value keep on adjusting/moving or not
			pen = (int) source.getValue(); // get value from the slides, and change pen size value
		}
	}

	@SuppressWarnings("deprecation")
	public void mouseClicked(MouseEvent me) {
		if (me.getModifiers() == MouseEvent.BUTTON3_MASK) { // getModifiers tell us which button we clicked.
															// BUTTON3_MASK = RIGHT BUTTON
			penColor = JColorChooser.showDialog(null, "Change pen colour", penColor); // Popup a colour palet
		}
	}

}

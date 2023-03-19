import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DrawingProgram extends JFrame
		implements MouseMotionListener, MouseListener, ChangeListener, ActionListener {
	
	// Initialize variables
	public Point mousePnt = new Point();
	public static Color penColor = new Color(0, 0, 0); // Create color white
	public JSlider penSize = new JSlider(JSlider.HORIZONTAL, 1, 30, pen); // Create slider
	public JSlider source;
	public static int pen = 4; // Default pen size
	public int activate = 1; // Purpose to activate the tool bar and button

	// the icons are the array objects of ImageIcon
	ImageIcon[] icons = { new ImageIcon(getClass().getResource("img/rectangle2.png")),
			new ImageIcon(getClass().getResource("img/circle2.png")),
			new ImageIcon(getClass().getResource("img/square2.jpg")),
			new ImageIcon(getClass().getResource("img/triangle2.png")) };

	/* Creating Panel */
	JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Create a panel for tool bar
	JPanel jp = new JPanel(); // Create a panel for drawing purposes
	JPanel shapes = new JPanel(new GridLayout(1, 5)); // Create a panel for displaying shapes
	JButton JBRectangle = new JButton(icons[0]);
	JButton JBCircle = new JButton(icons[1]);
	JButton JBSquare = new JButton(icons[2]);
	JButton JBTriangle = new JButton(icons[3]);
	JButton JBFreeDraw = new JButton("Free Draw");
	JLabel counter = new JLabel("Current number of clicks : ");

	public DrawingProgram() {
		super("Painter"); // Call constructor from JFrame library, give the frame title "Painter"

		/* Adding objects into frame */
		this.add(toolbar, BorderLayout.SOUTH); // add toolbar to jframe, position south
		this.add(jp, BorderLayout.CENTER); // add jpanel for drawing to jframe, position center
		this.add(counter, BorderLayout.NORTH); // add click counter to jframe, poisition north

		/* Adding things to panel */
		toolbar.add(new Label("Drag mouse to draw")); // add label to toolbar panel
		toolbar.add(penSize); // add slider to toolbar panel
		shapes.add(JBRectangle);
		shapes.add(JBCircle);
		shapes.add(JBSquare);
		shapes.add(JBTriangle);
		shapes.add(JBFreeDraw);
		toolbar.add(shapes);

		/* Implements listener */
		jp.addMouseMotionListener(this); // register the listener to the canvas (Jpanel named jp). MouseMotionListener
											// handles the events when mouse is in motion.
		jp.addMouseListener(this); // register the listener to the canvas (JPanel named jp). MouseListener handles
									// the events when the mouse is not in motion.
		penSize.addChangeListener(this);
		JBFreeDraw.addActionListener(this);
		JBRectangle.addActionListener(this);
		JBCircle.addActionListener(this);
		JBSquare.addActionListener(this);
		JBTriangle.addActionListener(this);

		/* Properties of the frame */
		setSize(1030, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == JBFreeDraw) {
			dispose();
			FreeDraw n = new FreeDraw();
		} else if (e.getSource() == JBRectangle) { // Engku
			dispose();
			DrawRectangle n = new DrawRectangle();
		} else if (e.getSource() == JBCircle) { // Daniel
			dispose();
			DrawCircle n = new DrawCircle();
		} else if (e.getSource() == JBSquare) { // Fekry
			dispose();
			DrawSquare n = new DrawSquare();
		} else if (e.getSource() == JBTriangle) { // Amir
			dispose();
			DrawTriangle n = new DrawTriangle();
		}
	}
	
	public static void main(String[] a) {
		new DrawingProgram();
	}
	
	public void paint(Graphics g) {
		super.paintComponents(g);
	}	
	
	public void stateChanged(ChangeEvent e) { // When interact with slider, it will fire ChangeEvent
		source = (JSlider) e.getSource(); // Get value from the slider when user interact with it
		if (!source.getValueIsAdjusting()) { // Check if the value keep on adjusting/moving or not
			pen = (int) source.getValue(); // get value from the slides, and change pen size value
		}
	}	
	
	public void mouseDragged(MouseEvent me) {}

	public void mouseClicked(MouseEvent me) {}

	public void mousePressed(MouseEvent me) {}

	public void mouseReleased(MouseEvent me) {}

	public void mouseEntered(MouseEvent me) {}

	public void mouseExited(MouseEvent me) {}

	public void mouseMoved(MouseEvent me) {}

}

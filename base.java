import javax.swing.*;
import java.awt.*;
class base {
  public static void main(String args[]) {
    
    //Creating the Frame
    JFrame frame = new JFrame("test GUI");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(900, 480);

    //Creating the MenuBar and adding components
    JMenuBar mb = new JMenuBar();
      JMenu m1 = new JMenu("Start");
      JMenu m2 = new JMenu("Reset");
      mb.add(m1);
      mb.add(m2);

    JPanel panel = new JPanel();
      JLabel label = new JLabel("Enter coordinates");
      JTextField tf = new JTextField(5);
      JButton enter = new JButton("Enter");
      JButton reset = new JButton("Reset");
      panel.add(label); // Components Added using Flow Layout
      panel.add(tf);
      panel.add(enter);
      panel.add(reset);

    JMenuBar s = new JMenuBar();
  		JMenu b1 = new JMenu("0");
  		JMenu b2 = new JMenu("1");
  		JMenu b3 = new JMenu("2");
  		JMenu b4 = new JMenu("3");
  		s.add(b1);
  		s.add(b2);
  		s.add(b3);
  		s.add(b4);

    frame.getContentPane().add(BorderLayout.SOUTH, panel);
    frame.getContentPane().add(BorderLayout.NORTH, mb);
    frame.getContentPane().add(BorderLayout.CENTER, s);
    frame.setVisible(true);
    }
}

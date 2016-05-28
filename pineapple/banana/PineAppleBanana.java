package pineapple.banana;

import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author J-Mitko
 */
public class PineAppleBanana extends JPanel implements ActionListener{

    private JPanel panel;
    
    private JRadioButton pineapple;
    private JRadioButton banana;
    
    private JLabel picture;
    
    
    private PineAppleBanana() {
        super(new BorderLayout());
        
        pineapple = new JRadioButton("pineApple");
        pineapple.setMnemonic(KeyEvent.VK_B);
        pineapple.setActionCommand("img1.jpg");
        pineapple.setSelected(true);
        
        banana = new JRadioButton("Banana");
        banana.setMnemonic(KeyEvent.VK_C);
        banana.setActionCommand("img2.jpg");
        
        pineapple.addActionListener(this);
        banana.addActionListener(this);
        
        picture = new JLabel(createImageIcon("img1.jpg"));
        picture.setPreferredSize(new Dimension(300, 300));
        
        
        ButtonGroup group = new ButtonGroup();
        group.add(banana);
        group.add(pineapple);
        
        panel = new JPanel(new GridLayout(0, 1));
        panel.add(pineapple);
        panel.add(banana);
        
        add(panel, BorderLayout.LINE_START);
        add(picture, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
    
    
    private static void createAndShowGUI()
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Display image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         //Create and set up the content pane.
        JComponent newContentPane = new PineAppleBanana();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        //Display the window
        frame.pack();
        frame.setVisible(true);
    }
    
    private ImageIcon createImageIcon(String image) {
        java.net.URL imgURL = PineAppleBanana.class.getResource(image);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + image);
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        picture.setIcon(createImageIcon(""+e.getActionCommand()+""));
    }
    
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    
    
}

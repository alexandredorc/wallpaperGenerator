import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

class MaFenetre extends JFrame{
    JLabel label= new JLabel("seed: ");
    Panel panel1 = new Panel();
    Panel panel2 = new Panel();
    Button gen = new Button("Generer");
    Button quit = new Button("Quitter");
    Button save = new Button("sauvegarder");
    JScrollBar rbar = new JScrollBar(Adjustable.HORIZONTAL);
    JScrollBar gbar = new JScrollBar(Adjustable.HORIZONTAL);
    JScrollBar bbar = new JScrollBar(Adjustable.HORIZONTAL);
    int rValue, gValue, bValue;
    ImageGeneree img = new ImageGeneree();
    int width=1300;
    int height=800;

    MaFenetre(){
        super("TP de POO"); 
        setSize(width,height); 
        rbar.setPreferredSize(new Dimension(150,15));
        rbar.setBackground(new Color(255,0,0));
        rbar.setValue(0);
        gbar.setPreferredSize(new Dimension(150,15));
        gbar.setBackground(new Color(0,255,0));
        gbar.setValue(0);
        bbar.setPreferredSize(new Dimension(150,15));
        bbar.setBackground(new Color(0,0,255));
        bbar.setValue(0);
        save.setEnabled(false);
        panel1.add(label);
        panel1.add(rbar);
        panel1.add(gbar);
        panel1.add(bbar);
        panel2.add(save);
        panel2.add(gen);
        panel2.add(quit);
        Container c = this.getContentPane();
        c.add(panel1, BorderLayout.NORTH);
        c.add(img);
        c.add(panel2, BorderLayout.SOUTH);

        rbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent ae) {
            if (rbar.getValueIsAdjusting()) return;
                            rValue = (int)(ae.getValue()/9);
            }
        });
        gbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent ae) {
            if (gbar.getValueIsAdjusting()) return;
                            gValue = (int)(ae.getValue()/9);
            }
        });
        bbar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent ae) {
            if (bbar.getValueIsAdjusting()) return;
                            bValue = (int)(ae.getValue()/9);
            }
        });

        quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                
                System.exit(0);
            }
        });
        gen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                img.buildExpr(1920, 1080, rValue, gValue, bValue);
                save.setEnabled(true);
                img.repaint();
            }
        });

        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                img.saveImage();
            }
        });

        setVisible(true);
    }
}

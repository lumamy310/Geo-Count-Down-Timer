package project1_ver5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    private JMenuItem quitItem;

    public MainPanel(JMenuItem quitItem) {
        this.quitItem = quitItem;

        add(new GEOCDTPanelSwing());
        add(new GEOCDTPanelSwing());
        add(new GEOCDTPanelSwing());


        quitItem.addActionListener(new ButtonListener());


}




    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if(event.getSource() == quitItem){
                System.exit(0);

            }

        }
    }
}

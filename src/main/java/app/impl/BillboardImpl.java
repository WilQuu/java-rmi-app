package app.impl;

import bilboards.IBillboard;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.time.Duration;

public class BillboardImpl implements IBillboard {
    private JTextArea comercialTextUp;
    private JTextArea comercialTextDown;
    private Duration displayInterval;
    private final String nonComercialText = "HERE IS PLACE FOR YOUR COMMERCIAL";

    public BillboardImpl() {
        guiInit();
    }

    @Override
    public boolean addAdvertisement(String advertText, Duration displayPeriod, int orderId) throws RemoteException {
        if (displayPeriod.equals(0)) {
            return false;
        }
        if (!comercialTextUp.getText().equals(nonComercialText)) {
            comercialTextUp.setText(advertText);
        } else if (!comercialTextDown.getText().equals(nonComercialText)) {
            comercialTextDown.setText(advertText);
        } else {
            return false;
        }
        displayPeriod = displayPeriod.minus(displayInterval);


        return true;
    }

    @Override
    public boolean removeAdvertisement(int orderId) throws RemoteException {
        return false;
    }

    @Override
    public int[] getCapacity() throws RemoteException {
        int[] capacity = new int[2];
        capacity[0] = 2;
        if (comercialTextDown.getText().equals(nonComercialText)) {
            capacity[1] += 1;
        }
        if (comercialTextUp.getText().equals(nonComercialText)) {
            capacity[1] += 1;
        }
        return capacity;
    }

    @Override
    public void setDisplayInterval(Duration displayInterval) throws RemoteException {
        this.displayInterval = displayInterval;
    }

    @Override
    public boolean start() throws RemoteException {
        return false;
    }

    @Override
    public boolean stop() throws RemoteException {
        return false;
    }

    private void guiInit() {
        JFrame frame = new JFrame("Billboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setResizable(false);
        Border border = BorderFactory.createLineBorder(Color.GRAY, 5);
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        comercialTextUp = new JTextArea(4, 13);
        comercialTextUp.setText(nonComercialText);
        comercialTextUp.setEditable(false);
        comercialTextDown = new JTextArea(4, 13);
        comercialTextUp.setBorder(border);
        comercialTextDown.setText(nonComercialText);
        comercialTextDown.setBorder(border);
        comercialTextDown.setEditable(false);
        mainPanel.add(comercialTextUp);
        mainPanel.add(comercialTextDown);
        mainPanel.setBackground(Color.GRAY);
        frame.add(mainPanel);

        frame.setVisible(true);

    }
}

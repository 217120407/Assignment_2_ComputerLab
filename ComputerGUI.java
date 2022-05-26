package Main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import za.ac.wsu.s217120407.Computer;
import za.ac.wsu.s217120407.MyException;

/**
 *
 * @author Zonke Mavana 217120407
 */
public class ComputerGUI extends JFrame implements ActionListener {

    @SuppressWarnings("Convert2Diamond")

    private final ArrayList<Computer> list = new ArrayList<Computer>();
    private Computer objComputer = null;

    //JPanels for deviding the the JFrame
    private final JPanel pnlBody = new JPanel();
    private final JPanel pnlHeader = new JPanel();
    //JLabels 
    private final JLabel lblComputerLab = new JLabel("Computer Lab");
    private final JLabel lblIpAddress = new JLabel("IP Address");
    private final JLabel lblValue = new JLabel("Value");
    //JTexts fields for user inputs
    private final JTextField txtIpAddress = new JTextField(45);
    private final JTextField txtValue = new JTextField(45);
    //JButtons 
    JButton btnShowComputers = new JButton("Show Computers");
    JButton btnClear = new JButton("Clear");
    JButton btnExit = new JButton("Exit App");
    JButton btnInsert = new JButton("+");

    //Frame default constructor
    @SuppressWarnings("LeakingThisInConstructor")
    public ComputerGUI() {
        super("Lab App");
        setDefaultCloseOperation(3); //JFrame.EXIT_ON_CLOSE
        setBounds(500, 150, 500, 250);
        setLayout(null);

        pnlHeader.setBounds(0, 0, 500, 30);
        pnlHeader.setLayout(null);
        pnlHeader.add(lblComputerLab);
        lblComputerLab.setBounds(0, 0, 500, 30);
        pnlHeader.add(lblComputerLab);
        add(pnlHeader);

        pnlBody.setBounds(0, 30, 490, 185);
        pnlBody.setLayout(new GridLayout(5, 2, 4, 4));
        pnlBody.add(lblIpAddress);
        pnlBody.add(txtIpAddress);
        pnlBody.add(lblValue);
        pnlBody.add(txtValue);

        pnlBody.add(btnInsert);
        btnInsert.addActionListener(this);
        pnlBody.add(btnShowComputers);
        btnShowComputers.addActionListener(this);
        pnlBody.add(btnClear);
        btnClear.addActionListener(this);
        pnlBody.add(btnExit);
        btnExit.addActionListener(this);
        add(pnlBody);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnExit) {
            System.exit(0);
        } else if (source == btnShowComputers) {
            String computers = "";
            for (Computer comp : list) {
                computers += comp.toString();
            }
            JOptionPane.showMessageDialog(null, computers, "Computers", JOptionPane.INFORMATION_MESSAGE);
        } else if (source == btnClear) {
            clear();
        } else if (source == btnInsert) {
           
            try {
                
            String sIPAddress = txtIpAddress.getText();
            if (Float.parseFloat(txtValue.getText()) >= 0){
                
            float fValue = Float.parseFloat(txtValue.getText());
            objComputer = new Computer(sIPAddress, fValue);
            list.add(objComputer);

            JOptionPane.showMessageDialog(null, "Computer Inserted", "Info", 1);
            clear();
            }
            else{
                throw new MyException("Invalid input");
            }
            } catch (NumberFormatException | MyException nfe){
                JOptionPane.showMessageDialog(null, "Invalid format");
            }
                
        }
    }

    private void clear() {
        txtIpAddress.setText(null);
        txtValue.setText(null);
    }

    public static void main(String[] args) {
        new ComputerGUI();
    }

}

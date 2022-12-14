package org.sfsoft.carreracoches;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class Carrera {

    private JFrame frmCarrea;
    private JProgressBar pbCaballo1;
    private JProgressBar pbCaballo2;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JProgressBar pbCaballo3;
    private JLabel lblNewLabel_2;
    private JTextField tfDistancia;
    private JButton btCorrer;
    private JLabel lblDistancia;
    private JLabel lbMarcador;
    private JLabel progresoCaballo1;

    private void correr() {

        int distancia =
                Integer.parseInt(tfDistancia.getText());

        final Caballo caballo1 = new Caballo(5, distancia, lbMarcador, "Opel");
        final Caballo caballo2 = new Caballo(20, distancia, lbMarcador, "Ford");
        final Caballo caballo3 = new Caballo(30, distancia, lbMarcador, "Seat");


        caballo1.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    pbCaballo1.setValue((Integer) event.getNewValue());
                    progresoCaballo1.setText(
                            event.getNewValue() + " %");
                }
                if (event.getPropertyName().equals("ganador")) {
                    caballo2.cancel(true);
                    caballo3.cancel(true);
                }
            }
        });
        caballo2.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    pbCaballo2.setValue((Integer) event.getNewValue());
                }
                if (event.getPropertyName().equals("ganador")) {
                    caballo1.cancel(true);
                    caballo3.cancel(true);
                }
            }
        });
        caballo3.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getPropertyName().equals("progress")) {
                    pbCaballo3.setValue((Integer) event.getNewValue());
                }
                if (event.getPropertyName().equals("ganador")) {
                    caballo1.cancel(true);
                    caballo2.cancel(true);
                }
            }
        });

        caballo1.execute();
        caballo2.execute();
        caballo3.execute();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Carrera window = new Carrera();
                    window.frmCarrea.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Carrera() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmCarrea = new JFrame();
        frmCarrea.setTitle("Carrera");
        frmCarrea.setBounds(100, 100, 450, 300);
        frmCarrea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCarrea.getContentPane().setLayout(null);
        frmCarrea.getContentPane().add(getPbCaballo1());
        frmCarrea.getContentPane().add(getPbCaballo2());
        frmCarrea.getContentPane().add(getLblNewLabel());
        frmCarrea.getContentPane().add(getLblNewLabel_1());
        frmCarrea.getContentPane().add(getPbCaballo3());
        frmCarrea.getContentPane().add(getLblNewLabel_2());
        frmCarrea.getContentPane().add(getTfDistancia());
        frmCarrea.getContentPane().add(getBtCorrer());
        frmCarrea.getContentPane().add(getLblDistancia());
        frmCarrea.getContentPane().add(getLbMarcador());
        frmCarrea.getContentPane().add(getProgresoCoche1());
    }
    public JProgressBar getPbCaballo1() {
        if (pbCaballo1 == null) {
            pbCaballo1 = new JProgressBar();
            pbCaballo1.setBounds(10, 65, 422, 19);
        }
        return pbCaballo1;
    }
    public JProgressBar getPbCaballo2() {
        if (pbCaballo2 == null) {
            pbCaballo2 = new JProgressBar();
            pbCaballo2.setBounds(10, 137, 422, 19);
        }
        return pbCaballo2;
    }
    public JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel("Coche 1");
            lblNewLabel.setBounds(10, 43, 46, 14);
        }
        return lblNewLabel;
    }
    public JLabel getLblNewLabel_1() {
        if (lblNewLabel_1 == null) {
            lblNewLabel_1 = new JLabel("Coche 2");
            lblNewLabel_1.setBounds(10, 114, 46, 14);
        }
        return lblNewLabel_1;
    }
    public JProgressBar getPbCaballo3() {
        if (pbCaballo3 == null) {
            pbCaballo3 = new JProgressBar();
            pbCaballo3.setString("34");
            pbCaballo3.setBounds(10, 207, 422, 19);
        }
        return pbCaballo3;
    }


    public JLabel getLblNewLabel_2() {
        if (lblNewLabel_2 == null) {
            lblNewLabel_2 = new JLabel("Coche 3");
            lblNewLabel_2.setBounds(10, 182, 46, 14);
        }
        return lblNewLabel_2;
    }
    public JTextField getTfDistancia() {
        if (tfDistancia == null) {
            tfDistancia = new JTextField();
            tfDistancia.setBounds(247, 12, 86, 20);
            tfDistancia.setColumns(10);
        }
        return tfDistancia;
    }
    public JButton getBtCorrer() {
        if (btCorrer == null) {
            btCorrer = new JButton("Correr");
            btCorrer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    correr();
                }
            });
            btCorrer.setBounds(343, 11, 89, 23);
        }
        return btCorrer;
    }
    public JLabel getLblDistancia() {
        if (lblDistancia == null) {
            lblDistancia = new JLabel("Distancia");
            lblDistancia.setBounds(176, 15, 72, 14);
        }
        return lblDistancia;
    }
    public JLabel getLbMarcador() {
        if (lbMarcador == null) {
            lbMarcador = new JLabel("");
            lbMarcador.setBounds(147, 241, 144, 14);
        }
        return lbMarcador;
    }
    public JLabel getProgresoCoche1() {
        if (progresoCaballo1 == null) {
            progresoCaballo1 = new JLabel("");
            progresoCaballo1.setBounds(65, 40, 46, 14);
        }
        return progresoCaballo1;
    }
}
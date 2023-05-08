package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JButton btnplanel1;
    private JLabel etiquetaPanel1;
    private JPanel panel2;
    private JLabel etiquetaPanel2;
    private JPanel panel3;
    private JComboBox<String>comboBoxPanel3;
    private JPanel panel4;
    private GridLayout layout;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800,600);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        // Panel 1
        panel1 = new JPanel();
        panel1.setBackground(new Color(132,112,212));
        btnplanel1= new JButton("Presioname");
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.getContentPane().add(panel1,0);
        panel1.add(btnplanel1);
        etiquetaPanel1 = new JLabel("...");
        panel1.add(etiquetaPanel1);
        btnplanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                etiquetaPanel1.setText("Hola, Presionaste el boton del panel 1");
            }
        });
        // Panel 2
        String urlImg = "https://static.thenounproject.com/png/1133091-200.png";
        panel2.setLayout(new FlowLayout());
        // cargar imagen de internet

        try
        {URL url = new URL(urlImg);
            Image imagen= ImageIO.read(url);
            ImageIcon imagenIcon= new ImageIcon(imagen);
            etiquetaPanel2 = new JLabel(imagenIcon);
            panel2.add(etiquetaPanel2);
            this.getContentPane().add(panel2,1);
        }catch (MalformedURLException me){
            System.out.println("URL no valida");
        }catch (Exception e){
            System.out.println("Error al cargar la imagen");
        }




        panel2 = new JPanel();
        panel2.setBackground(new Color(137,144,235));

        // Panel 3
        panel3 = new JPanel();
        panel3.setBackground(new Color(112,145,212));

        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String[] elementos = {"Opcion1","Opcion2","Opcion3","Opcion4"};
        comboBoxPanel3= new JComboBox<>(elementos);
        comboBoxPanel3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource().toString());
                System.out.println(comboBoxPanel3.getSelectedIndex());

            }
        });
        panel3.add(comboBoxPanel3);
        this.getContentPane().add(panel3,2);
        // Panel 4
        panel4 = new JPanel();
        panel4.setBackground(new Color(130,199,246));
        this.getContentPane().add(panel4,3);

        this.setVisible(true);



        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

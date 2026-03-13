package main;
import java.awt.BasicStroke;
//11/3
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.GraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame {

    public Ventana() {
       
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(200, 200));
        this.setMaximumSize(new Dimension(1000, 900));
        this.setLocationRelativeTo(null);
        this.setTitle("Gestión Escolar - UABCS");
        this.setLayout(null);

        
        try {
            Image iconImage = ImageIO.read(getClass().getResource("/images/alumno.png"));
            this.setIconImage(iconImage);
        } catch (Exception e) {
            System.err.println("Error al cargar icono: " + e.getMessage());
        }

        
        JMenuBar barra = new JMenuBar();
        this.setJMenuBar(barra);

        
        JMenu menu1 = new JMenu("Archivo");
        barra.add(menu1);

        JMenuItem opt1_mi = new JMenuItem("Abrir");
        menu1.add(opt1_mi);

        JMenuItem opt2_mi = new JMenuItem("Nuevo");
        menu1.add(opt2_mi);

        JMenuItem opt3_mi = new JMenuItem("Cerrar");
        menu1.add(opt3_mi);

        menu1.addSeparator(); 

        
        JMenu menu2 = new JMenu("Guardar");
        menu1.add(menu2);

        JMenuItem opt4_mi = new JMenuItem("Guardar");
        menu2.add(opt4_mi);

        JMenuItem opt5_mi = new JMenuItem("Guardar como");
        menu2.add(opt5_mi);

        
        
        //this.login();      // Ejercicio 17
        //this.registro();   // Ejercicio 10
        //this.users();      // Tabla de alumnos
        //this.calculadora(); //calculadora
        //this.calculadoraInteres(); // calculadora interes

        this.pintar();
        
        this.setVisible(true);
        this.repaint();
    }

    
    public void login() {
        JPanel login_container = new JPanel();
        login_container.setSize(400, 500);
        login_container.setLocation(300, 50);
        login_container.setBackground(new Color(255, 255, 255, 200)); 
        login_container.setLayout(null);
        this.add(login_container);

        JLabel title = new JLabel("USER LOGIN");
        title.setBounds(0, 40, 400, 40);
        title.setFont(new Font("Impact", Font.BOLD, 32));
        title.setHorizontalAlignment(JLabel.CENTER);
        login_container.add(title);

        try {
            JLabel userIcon = new JLabel();
            ImageIcon imgUser = new ImageIcon(getClass().getResource("/images/user_icon.png"));
            userIcon.setIcon(new ImageIcon(imgUser.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
            userIcon.setBounds(40, 140, 30, 30);
            login_container.add(userIcon);
        } catch(Exception e) {}

        JTextField txtUser = new JTextField(" Nombre de usuario");
        txtUser.setBounds(80, 140, 260, 35);
        txtUser.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); 
        login_container.add(txtUser);

        try {
            JLabel passIcon = new JLabel();
            ImageIcon imgPass = new ImageIcon(getClass().getResource("/images/pass_icon.png"));
            passIcon.setIcon(new ImageIcon(imgPass.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
            passIcon.setBounds(40, 210, 30, 30);
            login_container.add(passIcon);
        } catch(Exception e) {}

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(80, 210, 260, 35);
        txtPass.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        login_container.add(txtPass);

        JButton btnAcceder = new JButton("Login");
        btnAcceder.setBounds(100, 320, 200, 45);
        btnAcceder.setBackground(new Color(41, 128, 185));
        btnAcceder.setForeground(Color.WHITE);
        btnAcceder.setFont(new Font("Arial", Font.BOLD, 18));
        btnAcceder.setBorder(BorderFactory.createRaisedBevelBorder());

        btnAcceder.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btnAcceder.setBackground(new Color(52, 152, 219));
                btnAcceder.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e) {
                btnAcceder.setBackground(new Color(41, 128, 185));
            }
        });
        login_container.add(btnAcceder);

        JLabel background = new JLabel();
        background.setBounds(0, 0, 1000, 750);
        try {
            ImageIcon imgBg = new ImageIcon(getClass().getResource("/images/login_bg.jpg"));
            background.setIcon(new ImageIcon(imgBg.getImage().getScaledInstance(1000, 750, Image.SCALE_SMOOTH)));
            this.add(background);
        } catch(Exception e) { this.getContentPane().setBackground(Color.BLACK); }
    }


    public void registro() {
        JPanel rgs_container = new JPanel();
      
        rgs_container.setBounds(300, 40, 420, 580); 
        rgs_container.setBackground(new Color(0, 191, 255)); 
        rgs_container.setLayout(null);
        rgs_container.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.BLACK), "NUEVO USUARIO", 
            TitledBorder.CENTER, TitledBorder.TOP));
        this.add(rgs_container);

       
        JLabel lblReg = new JLabel("REGISTRO", SwingConstants.CENTER);
        lblReg.setBounds(110, 20, 200, 50);
        lblReg.setOpaque(true);
        lblReg.setBackground(Color.BLACK);
        lblReg.setForeground(Color.WHITE);
        lblReg.setFont(new Font("Impact", Font.PLAIN, 30));
        rgs_container.add(lblReg);

        
        JLabel subNombre = crearEtiqueta("NOMBRE DE USUARIO", 85);
        rgs_container.add(subNombre);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(35, 115, 350, 30);
        rgs_container.add(txtNombre);

      
        JLabel subBio = crearEtiqueta("BIOGRAFÍA", 155);
        rgs_container.add(subBio);
        JTextArea bio_text = new JTextArea(); 
        bio_text.setBounds(35, 185, 350, 80);
        bio_text.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        rgs_container.add(bio_text);

  
        JLabel subPref = crearEtiqueta("PREFERENCIAS", 275);
        rgs_container.add(subPref);
        JCheckBox c1 = new JCheckBox("Dulce"); 
        c1.setBounds(40, 305, 80, 30); 
        c1.setOpaque(false);
        JCheckBox c2 = new JCheckBox("Salado"); 
        c2.setBounds(150, 305, 80, 30); 
        c2.setOpaque(false);
        rgs_container.add(c1); 
        rgs_container.add(c2);

    
        JLabel subTerminos = crearEtiqueta("TÉRMINOS Y CONDICIONES", 345);
        rgs_container.add(subTerminos);
        JRadioButton rb1 = new JRadioButton("Acepto"); 
        rb1.setBounds(40, 375, 100, 30); 
        rb1.setOpaque(false);
        JRadioButton rb2 = new JRadioButton("Rechazo"); 
        rb2.setBounds(150, 375, 100, 30); 
        rb2.setOpaque(false);
        
        ButtonGroup bg = new ButtonGroup(); 
        bg.add(rb1); 
        bg.add(rb2);
        rgs_container.add(rb1); 
        rgs_container.add(rb2);

        
        String[] col = {"Camino Real", "Arcoiris", "8 de Octubre"};
        JComboBox<String> combo = new JComboBox<>(col);
        combo.setBounds(35, 415, 350, 30);
        rgs_container.add(combo);

       
        JButton btnReg = new JButton("Crear cuenta");
        btnReg.setBounds(60, 470, 300, 50);
        btnReg.setBackground(Color.WHITE);
        btnReg.setFont(new Font("Arial", Font.BOLD, 16));
        btnReg.setBorder(BorderFactory.createRaisedBevelBorder());
        rgs_container.add(btnReg);
    }

    
    public void users() {
        JPanel panel_users = new JPanel();
        panel_users.setSize(900, 550);
        panel_users.setLocation(50, 50);
        panel_users.setBackground(Color.decode("#DDDEA6"));
        panel_users.setLayout(null);
        this.add(panel_users);

        String[] head = {"No. Control", "Nombre", "Apellidos", "Correo", "Semestre", "Carrera", "Acciones"};
        Object[][] body = {
            {"20231001", "Carlos", "Ramírez López", "carlos.ramirez@correo.com", "3", "ISC", "Editar"},
            {"20231002", "María", "González Pérez", "maria.gonzalez@correo.com", "5", "Industrial", "Editar"}
        };

        JTable table = new JTable(body, head); //
        JScrollPane scroll = new JScrollPane(table); //
        scroll.setSize(800, 250);
        scroll.setLocation(50, 100);
        panel_users.add(scroll);
    }

    private JLabel crearEtiqueta(String texto, int y) {
        JLabel l = new JLabel(texto, SwingConstants.CENTER);
        l.setBounds(35, y, 350, 25);
        l.setBackground(Color.YELLOW);
        l.setOpaque(true);
        l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return l;
    }
    
    
    public void calculadora() {
        JPanel panel_users = new JPanel();
        
        panel_users.setBounds(250, 50, 500, 600);
        panel_users.setBackground(Color.decode("#100f10"));

        BorderLayout mi_layout = new BorderLayout();
        mi_layout.setVgap(20);
        panel_users.setLayout(mi_layout);
        
       
        this.add(panel_users);

   
        JLabel field = new JLabel("180.00", SwingConstants.RIGHT);
        field.setOpaque(true);
        field.setBackground(Color.white);
        field.setFont(new Font("Arial", Font.BOLD, 30));
        field.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel_users.add(field, BorderLayout.NORTH);

   
        JPanel centro = new JPanel();
        centro.setBackground(Color.DARK_GRAY);
        centro.setLayout(new GridLayout(4, 3, 5, 5)); 
        panel_users.add(centro, BorderLayout.CENTER);

        String[] botones = {"9", "8", "7", "6", "5", "4", "3", "2", "1", "0", ".", "C"};

        for (int i = 0; i < botones.length; i++) {
            JButton btn = new JButton(botones[i]);
            btn.setFont(new Font("Arial", Font.BOLD, 22));
            centro.add(btn);
        }

      
        JPanel sidebar = new JPanel();
        sidebar.setBackground(Color.GRAY);
        sidebar.setLayout(new GridLayout(6, 1, 5, 5));
        panel_users.add(sidebar, BorderLayout.EAST);

        String[] botones2 = {"+", "-", "*", "/", "=", "CE"};

        for (int i = 0; i < botones2.length; i++) {
            JButton btn = new JButton(botones2[i]);
            btn.setFont(new Font("Arial", Font.BOLD, 22));
            sidebar.add(btn);
        }
    }
    
    
    public void calculadoraInteres() {
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBounds(250, 50, 500, 520);
        mainPanel.setBackground(new Color(33, 37, 41)); 
        this.add(mainPanel);

        
        JLabel title = new JLabel("Calculadora de Interes", JLabel.LEFT);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setForeground(new Color(0, 123, 255)); 
        mainPanel.add(title, BorderLayout.NORTH);

        
        JPanel pnlInput = new JPanel();
        pnlInput.setBackground(new Color(52, 58, 64)); 
        pnlInput.setLayout(new GridLayout(4, 1, 10, 10));
        pnlInput.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 123, 255)), "DATOS DE ENTRADA", 
                TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 12), Color.WHITE));
        
        
        pnlInput.add(crearFilaInput("Capital Social ($):", new JTextField("1500")));
        pnlInput.add(crearFilaInput("Tiempo (Años):", new JTextField("2")));
        pnlInput.add(crearFilaInput("Tasa de Interés (%):", new JTextField("0.1")));

        
        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        pnlButtons.setOpaque(false);
        
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBackground(new Color(40, 167, 69)); 
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFocusPainted(false);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(220, 53, 69)); 
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);

        pnlButtons.add(btnCalcular);
        pnlButtons.add(btnCancelar);
        pnlInput.add(pnlButtons);

        mainPanel.add(pnlInput, BorderLayout.CENTER);

       
        JPanel pnlResult = new JPanel();
        pnlResult.setBackground(new Color(73, 80, 87)); 
        pnlResult.setLayout(new GridLayout(2, 2, 10, 10));
        pnlResult.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel lblI = new JLabel("Interés Acumulado:", JLabel.RIGHT);
        lblI.setForeground(Color.WHITE);
        pnlResult.add(lblI);
        
        JTextField txtI = new JTextField("315.00");
        txtI.setEditable(false); 
        pnlResult.add(txtI);

        JLabel lblM = new JLabel("Monto Total Final:", JLabel.RIGHT);
        lblM.setForeground(Color.WHITE);
        pnlResult.add(lblM);
        
        JTextField txtM = new JTextField("1815.00");
        txtM.setEditable(false);
        pnlResult.add(txtM);

        mainPanel.add(pnlResult, BorderLayout.SOUTH);
    }

    
    public void pintar()
    {
    	 JPanel pane = new JPanel() {
             @Override
             protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 
                 Graphics2D g2d = (Graphics2D) g;
                 
                 g2d.drawLine(0, 0, 100, 100);
                 
                 g2d.setColor(Color.MAGENTA);
                 g2d.drawOval(100, 100, 150, 50);
                 
                 g2d.setColor(Color.GREEN);
                 g2d.setStroke(new BasicStroke(3));
                 
                 g2d.drawPolygon(new int[] {300,100,500}, new int[] {100,300,300},3);
                 
                 g2d.drawRect(250, 300, 100, 100);
                 
                 g2d.drawRoundRect(500, 150, 100, 100, 10, 10);
                 
                 g2d.drawArc(400, 100, 100, 110, 0, 90);
                 
                 g2d.setFont(new Font("Arial",Font.BOLD,22));
                 g2d.drawString("HOLA", 100, 100);
                 
                 g2d.fillOval(500, 50, 50, 50);
                 
                 g2d.fillPolygon(new int[] {500,300,700}, new int[] {300,500,500},3);
                 
                 g2d.fillRect(550, 500, 100, 100);
                 
                 g2d.setColor(Color.RED);
                 g2d.fillRoundRect(500, 500, 100, 100, 10, 10);
                 
                 g2d.fillArc(450, 150, 100, 100, 0, 300);
                 
                 
                 BufferedImage image;
				try {
					image = ImageIO.read(new File("src/images/pass_icon.png"));
					g2d.drawImage(image, 0, 0, null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
                 
                 
             }
         };
         pane.setSize(1000, 700);
         pane.setLocation(0,0);
         this.add(pane);

    	
    }
    
    private JPanel crearFilaInput(String texto, JTextField campo) {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 0));
        panel.setOpaque(false);
        JLabel lbl = new JLabel(texto, JLabel.RIGHT);
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(lbl);
        panel.add(campo);
        return panel;
    }
    
}
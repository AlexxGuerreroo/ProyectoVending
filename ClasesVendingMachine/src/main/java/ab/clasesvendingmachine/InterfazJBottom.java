package ab.clasesvendingmachine;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;

public class PruebaJBottom extends JFrame{

  JLabel display;
  JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton0, botonLimpiar, botonAceptar;

  public PruebaJBottom(){

    //Declaro métodos en el constructor para simplificar el código
    initDisplay();
    
    initBotones();
    initAcciones();
    initHovers();
    initPantalla(); //El JFrame lo último para que me pinte correctamente los botones

    }

    private void initPantalla(){

      setTitle("Ejemplo 3: Eventos");
      setSize(240,390);
      setResizable(false);
      setLayout(null);
      getContentPane().setBackground(Color.BLACK);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);

    }

    private void initDisplay(){

      //Propiedades y estilos del JLabel
      display = new JLabel("");
      display.setBounds(15, 15, 195, 60);
      display.setOpaque(true);
      display.setBackground(Color.BLACK);
      display.setForeground(Color.GREEN);
      display.setBorder(new LineBorder(Color.DARK_GRAY));
      display.setFont(new Font("MONOSPACED",PLAIN,24));
      display.setHorizontalAlignment(SwingConstants.RIGHT);
      display.setFocusable(true);
      add(display);

      //Eventos de entrada de teclado
      display.addKeyListener(new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
          String ch = String.valueOf(e.getKeyChar());
            display.setText(display.getText() + ch);
          if (key == KeyEvent.VK_BACK_SPACE){//Si le das al botón retroceder.
            display.setText(" ");
          }
          if (key == KeyEvent.VK_ENTER){//Si le das al intro.
              System.out.println(display.getText());
          }          
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

      });

    }

    //Propiedades y estilos de los JButton
    private void initBotones(){

      boton1 = new JButton("1");
      boton2 = new JButton("2");
      boton3 = new JButton("3");
      boton4 = new JButton("4");
      boton5 = new JButton("5");
      boton6 = new JButton("6");
      boton7 = new JButton("7");
      boton8 = new JButton("8");
      boton9 = new JButton("9");
      boton0 = new JButton("0");
      botonLimpiar = new JButton("Limpiar");
      botonAceptar = new JButton ("Aceptar");

      //Características de los botones: (Posición horizontal, posición vertical, tamaño horizontal, tamaño vertical).      
      boton1.setBounds(15,90,61,50);
      boton2.setBounds(81,90,61,50);
      boton3.setBounds(147,90,62,50); 
      boton4.setBounds(15,155,61,50);
      boton5.setBounds(81,155,61,50);
      boton6.setBounds(147,155,62,50);
      boton7.setBounds(15,220,61,50);
      boton8.setBounds(81,220,61,50);
      boton9.setBounds(147,220,62,50);            
      botonLimpiar.setBounds(15,285,61,50);
      boton0.setBounds(81,285,61,50);
      botonAceptar.setBounds(147,285,62,50);

      boton1.setFont(new Font("MONOSPACED",PLAIN,16));
      boton2.setFont(new Font("MONOSPACED",PLAIN,16));
      boton3.setFont(new Font("MONOSPACED",PLAIN,16));
      boton4.setFont(new Font("MONOSPACED",PLAIN,16));
      boton5.setFont(new Font("MONOSPACED",PLAIN,16));
      boton6.setFont(new Font("MONOSPACED",PLAIN,16));
      boton7.setFont(new Font("MONOSPACED",PLAIN,16));
      boton8.setFont(new Font("MONOSPACED",PLAIN,16));
      boton9.setFont(new Font("MONOSPACED",PLAIN,16));
      boton0.setFont(new Font("MONOSPACED",PLAIN,16));      
      botonLimpiar.setFont(new Font("MONOSPACED",PLAIN,12));
      botonAceptar.setFont(new Font("MONOSPACED",PLAIN,12));

      boton1.setOpaque(true);
      boton2.setOpaque(true);
      boton3.setOpaque(true);
      boton4.setOpaque(true);
      boton5.setOpaque(true);
      boton6.setOpaque(true);
      boton7.setOpaque(true);
      boton8.setOpaque(true);
      boton9.setOpaque(true);
      boton0.setOpaque(true);      
      botonLimpiar.setOpaque(true);
      botonAceptar.setOpaque(true);

      boton1.setFocusPainted(false);
      boton1.setBackground(Color.DARK_GRAY);
      boton1.setBorder(new LineBorder(Color.DARK_GRAY));
      boton1.setForeground(Color.WHITE);

      boton2.setFocusPainted(false);
      boton2.setBackground(Color.DARK_GRAY);
      boton2.setBorder(new LineBorder(Color.DARK_GRAY));
      boton2.setForeground(Color.WHITE);

      boton3.setFocusPainted(false);
      boton3.setBackground(Color.DARK_GRAY);
      boton3.setBorder(new LineBorder(Color.DARK_GRAY));
      boton3.setForeground(Color.WHITE);
      
      boton4.setFocusPainted(false);
      boton4.setBackground(Color.DARK_GRAY);
      boton4.setBorder(new LineBorder(Color.DARK_GRAY));
      boton4.setForeground(Color.WHITE);
      
      boton5.setFocusPainted(false);
      boton5.setBackground(Color.DARK_GRAY);
      boton5.setBorder(new LineBorder(Color.DARK_GRAY));
      boton5.setForeground(Color.WHITE);
      
      boton6.setFocusPainted(false);
      boton6.setBackground(Color.DARK_GRAY);
      boton6.setBorder(new LineBorder(Color.DARK_GRAY));
      boton6.setForeground(Color.WHITE);
      
      boton7.setFocusPainted(false);
      boton7.setBackground(Color.DARK_GRAY);
      boton7.setBorder(new LineBorder(Color.DARK_GRAY));
      boton7.setForeground(Color.WHITE);
      
      boton8.setFocusPainted(false);
      boton8.setBackground(Color.DARK_GRAY);
      boton8.setBorder(new LineBorder(Color.DARK_GRAY));
      boton8.setForeground(Color.WHITE);
      
      boton9.setFocusPainted(false);
      boton9.setBackground(Color.DARK_GRAY);
      boton9.setBorder(new LineBorder(Color.DARK_GRAY));
      boton9.setForeground(Color.WHITE);
      
      boton0.setFocusPainted(false);
      boton0.setBackground(Color.DARK_GRAY);
      boton0.setBorder(new LineBorder(Color.DARK_GRAY));
      boton0.setForeground(Color.WHITE);
      
      botonAceptar.setFocusPainted(false);
      botonAceptar.setBackground(Color.DARK_GRAY);
      botonAceptar.setBorder(new LineBorder(Color.DARK_GRAY));
      botonAceptar.setForeground(Color.WHITE);
      
      botonLimpiar.setFocusPainted(false);
      botonLimpiar.setBackground(Color.DARK_GRAY);
      botonLimpiar.setBorder(new LineBorder(Color.DARK_GRAY));
      botonLimpiar.setForeground(Color.WHITE);

      add(boton1);
      add(boton2);
      add(boton3);
      add(boton4);
      add(boton5);
      add(boton6);
      add(boton7);
      add(boton8);
      add(boton9);
      add(boton0);
      add(botonAceptar);
      add(botonLimpiar);

    }

    //Eventos de acción de botón
    private void initAcciones(){

      boton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText(display.getText() + "1");
          display.requestFocus(); //devuelvo foco a display para que funcione el KeyListener
        }
      });

      boton2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText(display.getText() + "2");
          display.requestFocus();
        }
      });

      boton3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText(display.getText() + "3");
          display.requestFocus();
      }
      });
      
      
      boton4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText(display.getText() + "4");
          display.requestFocus();
      }
      });
      
      
      boton5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText(display.getText() + "5");
          display.requestFocus();
      }
      });
      
      
      boton6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText(display.getText() + "6");
          display.requestFocus();
      }
      });
      
      
      boton7.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText(display.getText() + "7");
          display.requestFocus();
      }
      });
      
      
      boton8.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText(display.getText() + "8");
          display.requestFocus();
      }
      });
      
      
      boton9.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText(display.getText() + "9");
          display.requestFocus();
      }
      });
      
      
      boton0.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText(display.getText() + "0");
          display.requestFocus();
      }
      });

      botonLimpiar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          display.setText("delete key");
          display.requestFocus();
        }
      });
      
      botonAceptar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                     
          System.out.println(display.getText());
          display.requestFocus();
        }
      });

    }

    //Eventos de mouse
    private void initHovers(){

      boton1.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          boton1.setBackground(Color.GREEN);
          boton1.setBorder(new LineBorder(Color.GREEN));
          boton1.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          boton1.setBackground(Color.DARK_GRAY);
          boton1.setBorder(new LineBorder(Color.DARK_GRAY));
          boton1.setForeground(Color.WHITE);            
        }

      });

      boton2.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          boton2.setBackground(Color.GREEN);
          boton2.setBorder(new LineBorder(Color.GREEN));
          boton2.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          boton2.setBackground(Color.DARK_GRAY);
          boton2.setBorder(new LineBorder(Color.DARK_GRAY));
          boton2.setForeground(Color.WHITE);            
        }

      });

      boton3.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          boton3.setBackground(Color.GREEN);
          boton3.setBorder(new LineBorder(Color.GREEN));
          boton3.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          boton3.setBackground(Color.DARK_GRAY);
          boton3.setBorder(new LineBorder(Color.DARK_GRAY));
          boton3.setForeground(Color.WHITE);            
        }

    });

      boton4.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          boton4.setBackground(Color.GREEN);
          boton4.setBorder(new LineBorder(Color.GREEN));
          boton4.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          boton4.setBackground(Color.DARK_GRAY);
          boton4.setBorder(new LineBorder(Color.DARK_GRAY));
          boton4.setForeground(Color.WHITE);            
        }

    });
      
      boton5.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          boton5.setBackground(Color.GREEN);
          boton5.setBorder(new LineBorder(Color.GREEN));
          boton5.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          boton5.setBackground(Color.DARK_GRAY);
          boton5.setBorder(new LineBorder(Color.DARK_GRAY));
          boton5.setForeground(Color.WHITE);            
        }

    });
      
      boton6.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          boton6.setBackground(Color.GREEN);
          boton6.setBorder(new LineBorder(Color.GREEN));
          boton6.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          boton6.setBackground(Color.DARK_GRAY);
          boton6.setBorder(new LineBorder(Color.DARK_GRAY));
          boton6.setForeground(Color.WHITE);            
        }

    });
      
      boton7.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          boton7.setBackground(Color.GREEN);
          boton7.setBorder(new LineBorder(Color.GREEN));
          boton7.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          boton7.setBackground(Color.DARK_GRAY);
          boton7.setBorder(new LineBorder(Color.DARK_GRAY));
          boton7.setForeground(Color.WHITE);            
        }

    });
      
      boton8.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          boton8.setBackground(Color.GREEN);
          boton8.setBorder(new LineBorder(Color.GREEN));
          boton8.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          boton8.setBackground(Color.DARK_GRAY);
          boton8.setBorder(new LineBorder(Color.DARK_GRAY));
          boton8.setForeground(Color.WHITE);            
        }

    });
      
      boton9.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          boton9.setBackground(Color.GREEN);
          boton9.setBorder(new LineBorder(Color.GREEN));
          boton9.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          boton9.setBackground(Color.DARK_GRAY);
          boton9.setBorder(new LineBorder(Color.DARK_GRAY));
          boton9.setForeground(Color.WHITE);            
        }

    });
      
      boton0.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
          boton0.setBackground(Color.GREEN);
          boton0.setBorder(new LineBorder(Color.GREEN));
          boton0.setForeground(Color.DARK_GRAY);
        }

        @Override
        public void mouseExited(MouseEvent e) {
          boton0.setBackground(Color.DARK_GRAY);
          boton0.setBorder(new LineBorder(Color.DARK_GRAY));
          boton0.setForeground(Color.WHITE);            
        }

    });
      
    botonLimpiar.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
      }

      @Override
      public void mousePressed(MouseEvent e) {
      }

      @Override
      public void mouseReleased(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        botonLimpiar.setBackground(Color.GREEN);
        botonLimpiar.setBorder(new LineBorder(Color.GREEN));
        botonLimpiar.setForeground(Color.DARK_GRAY);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        botonLimpiar.setBackground(Color.DARK_GRAY);
        botonLimpiar.setBorder(new LineBorder(Color.DARK_GRAY));
        botonLimpiar.setForeground(Color.WHITE);            
      }
      
    });
    
    botonAceptar.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
      }

      @Override
      public void mousePressed(MouseEvent e) {
      }

      @Override
      public void mouseReleased(MouseEvent e) {
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        botonAceptar.setBackground(Color.GREEN);
        botonAceptar.setBorder(new LineBorder(Color.GREEN));
        botonAceptar.setForeground(Color.DARK_GRAY);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        botonAceptar.setBackground(Color.DARK_GRAY);
        botonAceptar.setBorder(new LineBorder(Color.DARK_GRAY));
        botonAceptar.setForeground(Color.WHITE);            
      }
      
    });
    
  }

  public static void main(String[] args) {
    
    new PruebaJBottom();

  }

}
package aula02.eventos.mouse;

// Fig. 22.11: DesktopFrame.java
// Demonstrando JDesktopPane
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class DesktopFrame extends JFrame 
{
   private JDesktopPane theDesktop;

   // configura a GUI
   public DesktopFrame()
   {
      super( "Using a JDesktopPane" );

      JMenuBar bar = new JMenuBar(); // cria a barra de menus
      JMenu addMenu = new JMenu( "Add" ); // cria o menu Add
      JMenuItem newFrame = new JMenuItem( "Internal Frame" );

      addMenu.add( newFrame ); // adiciona um novo item de quadro ao menu Add
      bar.add( addMenu ); // adiciona o menu Add � barra de menus
      setJMenuBar( bar ); // configura a barra de menus para esse aplicativo

      theDesktop = new JDesktopPane(); // cria o painel de �rea de trabalho
      add( theDesktop ); // adiciona painel de �rea de trabalho ao quadro        
    
      // configura o ouvinte para o item de menu newFrame
      newFrame.addActionListener(

         new ActionListener() // classe interna an�nima
         {  
            // exibe a nova janela interna
            public void actionPerformed( ActionEvent event ) 
            {
               // cria o quadro interno
               JInternalFrame frame = new JInternalFrame(    
                  "Internal Frame", true, true, true, true );

               MyJPanel panel = new MyJPanel(); // cria um novo painel
               frame.add( panel, BorderLayout.CENTER ); // adiciona o painel
               frame.pack(); // configura o quadro interno de acordo com o tamanho do conte�do

               theDesktop.add( frame ); // anexa o quadro interno
               frame.setVisible( true ); // mostra o quadro interno
            } // fim do m�todo actionPerformed
         } // fim da classe interna an�nima
      ); // fim da chamada para addActionListener
   } // fim do construtor DesktopFrame
} // fim da classe DesktopFrame

// classe para exibir um ImageIcon em um painel
class MyJPanel extends JPanel 
{
   private static Random generator = new Random();
   private ImageIcon picture; // imagem a ser exibida
   private String[] images = { "yellowflowers.png", "purpleflowers.png",
      "redflowers.png", "redflowers2.png", "lavenderflowers.png" };

   // carrega a imagem
   public MyJPanel()
   {
      int randomNumber = generator.nextInt( 5 );
      picture = new ImageIcon( images[ randomNumber ] ); // configura o �cone
   } // fim do construtor MyJPanel

   // exibe imageIcon no painel
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      picture.paintIcon( this, g, 0, 0 ); // exibe o �cone
   } // fim do m�todo paintComponent

   // retorna as dimens�es da imagem
   public Dimension getPreferredSize()
   {
      return new Dimension( picture.getIconWidth(),
         picture.getIconHeight() );                
   } // fim do m�todo getPreferredSize         
} // fim da classe MyJPanel

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

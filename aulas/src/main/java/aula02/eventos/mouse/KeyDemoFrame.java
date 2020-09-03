// Fig. 11.36: KeyDemoFrame.java
// Demonstrando os eventos de pressionamento de tecla.
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener
{
   private String line1 = ""; // primeira linha de textarea
   private String line2 = ""; // segunda linha de textarea
   private String line3 = ""; // terceira linha de textarea
   private JTextArea textArea; // textarea a exibir sa�da

   // construtor KeyDemoFrame
   public KeyDemoFrame()
   {
      super( "Demonstrating Keystroke Events" );

      textArea = new JTextArea( 10, 15 ); // configura JTextArea
      textArea.setText( "Press any key on the keyboard..." );
      textArea.setEnabled( false ); // desativa textarea
      textArea.setDisabledTextColor( Color.BLACK ); // configura cor de texto
      add( textArea ); // adiciona textarea ao JFrame

      addKeyListener( this ); // permite que o frame processe os eventos de teclado
   } // fim do construtor KeyDemoFrame

   // trata pressionamento de qualquer tecla
   public void keyPressed( KeyEvent event )
   {
      line1 = String.format( "Key pressed: %s", 
         event.getKeyText( event.getKeyCode() )); // gera sa�da de tecla pressionada
      setLines2and3( event ); // configura a sa�da das linhas dois e tr�s
   } // fim do m�todo keyPressed

   // trata libera��o de qualquer tecla
   public void keyReleased( KeyEvent event )
   {
      line1 = String.format( "Key released: %s",
         event.getKeyText( event.getKeyCode() )); // gera sa�da de tecla liberada
      setLines2and3( event ); // configura a sa�da das linhas dois e tr�s
   } // fim do m�todo keyReleased

   // trata pressionamento de uma tecla de a��o
   public void keyTyped( KeyEvent event )
   {
      line1 = String.format( "Key typed: %s", event.getKeyChar());
      setLines2and3( event ); // configura a sa�da das linhas dois e tr�s
   } // fim do m�todo keyTyped

   // configura segunda e terceira linhas de sa�da
   private void setLines2and3( KeyEvent event )
   {
      line2 = String.format( "This key is %san action key", 
         (event.isActionKey() ? "" : "not " ) );

      String temp = event.getKeyModifiersText( event.getModifiers() );

      line3 = String.format( "Modifier keys pressed: %s", 
         ( temp.equals( "" ) ? "none" : temp ) ); // modificadores de sa�da

      textArea.setText( String.format( "%s\n%s\n%s\n", 
         line1, line2, line3 ) ); // gera sa�da de tr�s linhas de texto
   } // fim do m�todo setLines2and3
} // fim da classe KeyDemoFrame


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
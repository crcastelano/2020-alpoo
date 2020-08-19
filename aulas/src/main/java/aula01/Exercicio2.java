package aula01;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author prof. Célio R. Castelano
 */
public class Exercicio2 extends JFrame {
    String firstNumber;
    String secondNumber;
    int number1;

    public Exercicio2() {
        firstNumber = JOptionPane.showInputDialog(this, "Entre com o Primeiro número:");
        secondNumber = JOptionPane.showInputDialog(this, "Entre com o Segundo Número:");

        int number1 = Integer.parseInt(firstNumber);
        int number2 = Integer.parseInt(secondNumber);

        int sum = number1 + number2;

        JOptionPane.showMessageDialog(this, "A soma dos número é: " + sum);

    }

    public static void main(String[] args) {
        Exercicio2 obj = new Exercicio2();
        System.out.println("Saiu do construtor");
    }
}

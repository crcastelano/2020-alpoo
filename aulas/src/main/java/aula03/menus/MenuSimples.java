package aula03.menus;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author prof. Célio R. Castelano
 * 
 * Fazer um menu com as opções:
 * 
 *          Cadastros    Relatórios
 *            Cliente       Clientes em débito
 *            Produto       Produtos em falta
 * 
 * 1) Extender JFrame
 * 2) Declarar os objetos de menu que serão usados
 *    2.1) JMenuBar
 *    2.2) JMenu
 *    2.3) JMenuItem (JRadioButtonMenuItem ou JCheckBoxMenuItem)
 * 3) Utilizar as 4 etapas para trabalhar com objetos Swing Java
 *    3.1) Declarar
 *    3.2) Instanciar
 *    3.3) Posicionar
 *    3.4) Adicionar
 * 4) Método construtor para executar as 4 etapas
 * 5) Método main para instanciar a classe
 */
public class MenuSimples extends JFrame {
   JMenuBar barraMenu;
   JMenu menuCadastros, menuRelatorios;
   JMenuItem itemMenuCadastroCliente, itemMenuCadastroProduto, itemMenuRelatorioCliente, itemMenuRelatorioProduto;
   
   public void instanciar() {
       barraMenu = new JMenuBar();
       
       menuCadastros = new JMenu("Cadastros");
       menuRelatorios = new JMenu("Relatórios");
       
       itemMenuCadastroCliente = new JMenuItem("Clientes");
       itemMenuCadastroProduto = new JMenuItem("Produtos");
       
       itemMenuRelatorioCliente = new JMenuItem("Clientes em débito");
       itemMenuRelatorioProduto = new JMenuItem("Produtos em falta");
   }
   
   public void posicionar() {
       
   }
   
   public void adicionar() {
       setJMenuBar(barraMenu); // adiciona a barra de menus no Frame
       
       barraMenu.add(menuCadastros); // adiciona o menu de cadastros na barra de menus
       barraMenu.add(menuRelatorios); // adiciona o menu de cadastros na barra de menus
       
       menuCadastros.add(itemMenuCadastroCliente);
       menuCadastros.add(itemMenuCadastroProduto);
       
       menuRelatorios.add(itemMenuRelatorioCliente);
       menuRelatorios.add(itemMenuRelatorioProduto);
   }
   
   public MenuSimples() {
       super("Trabalhando com menus no Java Swing");
       
       setPreferredSize(new Dimension(500, 400));
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       instanciar();
       posicionar();
       adicionar();
       
       setVisible(true);
       pack();
   }
   
    public static void main(String[] args) {
        MenuSimples menu = new MenuSimples();
    }
}

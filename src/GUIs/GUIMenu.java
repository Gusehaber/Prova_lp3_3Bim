/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import main.CaixaDeFerramentas;

/**
 *
 * @author Asus
 */
public class GUIMenu extends JFrame {

    Container cp;

    JPanel pnTotal = new JPanel();

    JMenuBar menubarMenu = new JMenuBar();
    JMenu menu = new JMenu("Cadastros");//aqui o que vai aparecer no nome do menu
    JMenuItem marca = new JMenuItem("Marca");//as partes do menu
    JMenuItem venda = new JMenuItem("Venda");
    JMenuItem fornecedor = new JMenuItem("Fornecedor");
    JMenuItem produto = new JMenuItem("Produto");

    CaixaDeFerramentas caixaDeFerramentas = new CaixaDeFerramentas();

    public GUIMenu() {
        setTitle("Estoque");
        setSize(500, 320);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();

        setJMenuBar(menubarMenu);
        menubarMenu.add(menu);
        menu.add(produto);
        menu.addSeparator();
        menu.add(marca);//só ta adicionando essas porra
        menu.addSeparator();
        menu.add(venda);
        menu.addSeparator();
        menu.add(fornecedor);
        
        produto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIProduto guiProduto = new GUIProduto();
            }
        });

        marca.addActionListener(new ActionListener() {//faz listener de todos os componentes do menu e só vai
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIMarca guiMarca = new GUIMarca();
            }
        });

        venda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIVenda guiVenda = new GUIVenda();
            }
        });

        fornecedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIFornecedor guiFornecedor = new GUIFornecedor();
            }
        });


        setVisible(true);
        setLocationRelativeTo(null);
    }
}

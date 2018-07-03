package GUIs;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import java.io.File;
import javax.swing.text.JTextComponent;
import Auxiliar.*;
import DAOs.*;
import Entidades.*;

public class GUIFornecedor extends JFrame {
    public static void main(String[] args) {
        new GUIFornecedor();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("ID Fornecedor: ");
    private JLabel lbIdFornecedor = new JLabel("ID Fornecedor");
    private JTextField fdIdFornecedor = new JTextField(15);

    private JLabel lbNomeFornecedor = new JLabel("Nome");
    private JTextField fdNomeFornecedor = new JTextField(45);

    private JLabel lbContatoFornecedor = new JLabel("Contato");
    private JTextField fdContatoFornecedor = new JTextField(45);


    private JPanel painelNortes = new JPanel(new GridLayout(2, 1));
    private JPanel painelNorteCima = new JPanel();
    private JPanel painelNorteBaixo = new JPanel();
    private JPanel painelCentralFora = new JPanel(new BorderLayout());
    private JPanel painelCentral = new JPanel();
    private JPanel painelSul = new JPanel();
    private JLabel labelBranco = new JLabel();

    JButton btInserir = new JButton(new ImageIcon(getClass().getResource("/icones/add.png")));
    JButton btSalvar = new JButton(new ImageIcon(getClass().getResource("/icones/confirmar.png")));
    JButton btRemover = new JButton(new ImageIcon(getClass().getResource("/icones/deletar.png")));
    JButton btAtualizar = new JButton(new ImageIcon(getClass().getResource("/icones/att.png")));
    JButton btBuscar = new JButton(new ImageIcon(getClass().getResource("/icones/search.png")));
    JButton btCancelar = new JButton(new ImageIcon(getClass().getResource("/icones/cancelar.png")));
    JButton btListar = new JButton(new ImageIcon(getClass().getResource("/icones/listar.png")));

    DAOFornecedor controle = new DAOFornecedor();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Fornecedor fornecedor = new Fornecedor();

    public GUIFornecedor(){
        setSize(725, 340);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Fornecedors");

        painelCentral.setLayout(new GridLayout(3, 2));
        painelCentral.add(lbNomeFornecedor);
        painelCentral.add(fdNomeFornecedor);
        painelCentral.add(lbContatoFornecedor);
        painelCentral.add(fdContatoFornecedor);

        fdNomeFornecedor.setEnabled(false);
        fdContatoFornecedor.setEnabled(false);

        List<String> combo = new ArrayList<>();


cp.setBackground(Color.white);
        cp.add(painelNortes, BorderLayout.NORTH);
        cp.add(painelCentralFora, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
        painelNortes.add(painelNorteCima);
        painelNortes.add(painelNorteBaixo);
        painelNorteCima.add(labelTitulo);
        painelNorteCima.add(fdIdFornecedor);
        painelNorteBaixo.add(btBuscar);
        painelNorteBaixo.add(btInserir);
        painelNorteBaixo.add(btAtualizar);
        painelNorteBaixo.add(btRemover);
        painelNorteBaixo.add(btSalvar);
        painelNorteBaixo.add(btCancelar);
        painelNorteBaixo.add(btListar);
        painelNorteCima.setBackground(Color.white);
        painelNorteBaixo.setBackground(Color.white);
        painelCentralFora.setBackground(Color.white);
        painelCentral.setBackground(Color.white);
        painelSul.setBackground(Color.white);
        btInserir.setBackground(Color.WHITE);
        btSalvar.setBackground(Color.WHITE);
        btRemover.setBackground(Color.WHITE);
        btAtualizar.setBackground(Color.WHITE);
        btBuscar.setBackground(Color.WHITE);
        btCancelar.setBackground(Color.WHITE);
        btListar.setBackground(Color.WHITE);

        labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
        fdIdFornecedor.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbIdFornecedor.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNomeFornecedor.setFont(new Font("Courier New", Font.BOLD, 17));
        lbContatoFornecedor.setFont(new Font("Courier New", Font.BOLD, 17));
        fdIdFornecedor.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdNomeFornecedor.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdContatoFornecedor.setFont(new Font("Courier New", Font.PLAIN, 17));
        labelAviso.setFont(new Font("Courier New", Font.BOLD, 20));
        btInserir.setVisible(false);
        btAtualizar.setVisible(false);
        btRemover.setVisible(false);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);

        painelSul.add(labelAviso);

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    fornecedor = new Fornecedor();
                    int idFornecedor = Integer.valueOf(fdIdFornecedor.getText());
                    fornecedor.setIdFornecedor(Integer.valueOf(fdIdFornecedor.getText()));
                    fornecedor = controle.obter(fornecedor.getIdFornecedor());
                    labelAviso.setBackground(Color.green);
                    if (fornecedor != null) {
                        fdIdFornecedor.setText(fornecedor.getIdFornecedor() + "");
                        fdNomeFornecedor.setText(fornecedor.getNomeFornecedor() + "");
                        fdContatoFornecedor.setText(fornecedor.getContatoFornecedor() + "");
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                    } else {
                        fdNomeFornecedor.setEnabled(false);
                        fdNomeFornecedor.setText(null);
                        fdContatoFornecedor.setEnabled(false);
                        fdContatoFornecedor.setText(null);
                        labelAviso.setText("Não encontrado!");
                        labelAviso.setBackground(Color.red);
                        btInserir.setVisible(true);
                        btAtualizar.setVisible(false);
                        btRemover.setVisible(false);
                        btListar.setVisible(false);
                    }
                } catch (Exception erro) {
                    labelAviso.setText("Preencha os campos corretamente!");
                    labelAviso.setBackground(Color.red);
                }
            }
        }
        );

        btInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = true;
                fdIdFornecedor.setEnabled(false);
                fdNomeFornecedor.setEnabled(true);
                fdContatoFornecedor.setEnabled(true);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btInserir.setVisible(false);
                btListar.setVisible(false);
            }
        }
        );

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acao){ //btInserir
                    try {
                    fornecedor = new Fornecedor();
                        fornecedor.setIdFornecedor(Integer.valueOf(fdIdFornecedor.getText()));
                        fornecedor.setNomeFornecedor(fdNomeFornecedor.getText());
                        fornecedor.setContatoFornecedor(fdContatoFornecedor.getText());
                        controle.inserir(fornecedor);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdIdFornecedor.setEnabled(true);
                        fdIdFornecedor.requestFocus();
                        fdNomeFornecedor.setEnabled(false);
                        fdContatoFornecedor.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        fornecedor = new Fornecedor();
                        fornecedor.setIdFornecedor(Integer.valueOf(fdIdFornecedor.getText()));
                        fornecedor.setNomeFornecedor(fdNomeFornecedor.getText());
                        fornecedor.setContatoFornecedor(fdContatoFornecedor.getText());
                        controle.atualizar(fornecedor);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdIdFornecedor.setEnabled(true);
                        fdIdFornecedor.requestFocus();
                        fdNomeFornecedor.setEnabled(false);
                        fdContatoFornecedor.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                }
            }
        }
    );

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelAviso.setText("Cancelado!");
                fdIdFornecedor.setEnabled(false);
                fdIdFornecedor.setText("");
                fdNomeFornecedor.setEnabled(false);
                fdNomeFornecedor.setText("");
                fdContatoFornecedor.setEnabled(false);
                fdContatoFornecedor.setText("");
                fdIdFornecedor.setEnabled(true);
                fdIdFornecedor.requestFocus();
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
            }
        }
        );

        btAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = false;
                fdNomeFornecedor.setEnabled(true);
                fdContatoFornecedor.setEnabled(true);
                fdNomeFornecedor.requestFocus();
                fdIdFornecedor.setEnabled(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btRemover.setVisible(false);
                btAtualizar.setVisible(false);
                btListar.setVisible(false);
            }
        }
        );

        btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btRemover.setVisible(false);
                btListar.setVisible(false);
                btAtualizar.setVisible(false);
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + fornecedor.getIdFornecedor() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(fornecedor);
                    labelAviso.setText("Removido!");
                    fdIdFornecedor.setText("");
                    fdNomeFornecedor.setText("");
                    fdNomeFornecedor.setEnabled(false);
                    fdContatoFornecedor.setText("");
                    fdContatoFornecedor.setEnabled(false);
                    btListar.setVisible(true);
                } else {
                    labelAviso.setText("Remoção cancelada!");
                    btAtualizar.setVisible(true);
                    btRemover.setVisible(true);
                }
            }
        }
        );


        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FornecedorGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
            }
        }
        );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        }
        );
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

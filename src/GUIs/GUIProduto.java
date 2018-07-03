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

public class GUIProduto extends JFrame {
    public static void main(String[] args) {
        new GUIProduto();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("ID: ");
    private JLabel lbIdProduto = new JLabel("ID");
    private JTextField fdIdProduto = new JTextField(15);

    private JLabel lbNomeProduto = new JLabel("Nome");
    private JTextField fdNomeProduto = new JTextField(45);

    private JLabel lbQuantidadeProduto = new JLabel("Quantidade");
    private JTextField fdQuantidadeProduto = new JTextField(15);

    private JLabel lbPrecoProduto = new JLabel("Preco");
    private JTextField fdPrecoProduto = new JTextField(0);

    private JLabel lbMarcaidMarca = new JLabel("IDMarca");
    private List<String> stringmarcaidMarca = new ArrayList<>();
    private JComboBox comboMarcaidMarca = new JComboBox();

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

    DAOProduto controle = new DAOProduto();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    JTextComponent editor = (JTextComponent) comboMarcaidMarca.getEditor().getEditorComponent();

    Produto produto = new Produto();

    public GUIProduto(){
        setSize(725, 420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Produtos");

        painelCentral.setLayout(new GridLayout(5, 2));
        painelCentral.add(lbNomeProduto);
        painelCentral.add(fdNomeProduto);
        painelCentral.add(lbQuantidadeProduto);
        painelCentral.add(fdQuantidadeProduto);
        painelCentral.add(lbPrecoProduto);
        painelCentral.add(fdPrecoProduto);

        fdNomeProduto.setEnabled(false);
        fdQuantidadeProduto.setEnabled(false);
        fdPrecoProduto.setEnabled(false);

        List<String> combo = new ArrayList<>();
        combo = new ManipulaArquivo().abrirArquivo("Produto");
        for(int x = 0; x < combo.size(); x++) {
            stringmarcaidMarca.add(combo.get(x).split(";")[0]);
        }
        comboMarcaidMarca = new JComboBox(stringmarcaidMarca.toArray());
        painelCentral.add(lbMarcaidMarca);
        painelCentral.add(comboMarcaidMarca);
        comboMarcaidMarca.setEnabled(false);
        editor.setDocument(new SearchableComboBox(comboMarcaidMarca));


cp.setBackground(Color.white);
        cp.add(painelNortes, BorderLayout.NORTH);
        cp.add(painelCentralFora, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
        painelNortes.add(painelNorteCima);
        painelNortes.add(painelNorteBaixo);
        painelNorteCima.add(labelTitulo);
        painelNorteCima.add(fdIdProduto);
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
        fdIdProduto.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbIdProduto.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNomeProduto.setFont(new Font("Courier New", Font.BOLD, 17));
        lbQuantidadeProduto.setFont(new Font("Courier New", Font.BOLD, 17));
        lbPrecoProduto.setFont(new Font("Courier New", Font.BOLD, 17));
        lbMarcaidMarca.setFont(new Font("Courier New", Font.BOLD, 17));
        fdIdProduto.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdNomeProduto.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdQuantidadeProduto.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdPrecoProduto.setFont(new Font("Courier New", Font.PLAIN, 17));
        comboMarcaidMarca.setFont(new Font("Courier New", Font.PLAIN, 17));
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
                btInserir.setVisible(true);
                try{
                    produto = new Produto();
                    int idProduto = Integer.valueOf(fdIdProduto.getText());
                    produto.setIdProduto(Integer.valueOf(fdIdProduto.getText()));
                    produto = controle.obter(produto.getIdProduto());
                    labelAviso.setBackground(Color.green);
                    if (produto != null) {
                        fdIdProduto.setText(produto.getIdProduto() + "");
                        fdNomeProduto.setText(produto.getNomeProduto() + "");
                        fdQuantidadeProduto.setText(produto.getQuantidadeProduto() + "");
                        fdPrecoProduto.setText(produto.getPrecoProduto() + "");
                        comboMarcaidMarca.setSelectedItem(produto.getMarcaIdMarca());
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                    } else {
                        fdNomeProduto.setEnabled(false);
                        fdNomeProduto.setText(null);
                        fdQuantidadeProduto.setEnabled(false);
                        fdQuantidadeProduto.setText(null);
                        fdPrecoProduto.setEnabled(false);
                        fdPrecoProduto.setText(null);
                        comboMarcaidMarca.setEnabled(true);
                        comboMarcaidMarca.setSelectedIndex(0);
                        labelAviso.setText("Não encontrado!");
                        labelAviso.setBackground(Color.red);
//                        btInserir.setVisible(true);
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
                fdIdProduto.setEnabled(false);
                fdNomeProduto.setEnabled(true);
                fdQuantidadeProduto.setEnabled(true);
                fdPrecoProduto.setEnabled(true);
                comboMarcaidMarca.setEnabled(true);
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
                    produto = new Produto();
                        produto.setIdProduto(Integer.valueOf(fdIdProduto.getText()));
                        produto.setNomeProduto(fdNomeProduto.getText());
                        produto.setQuantidadeProduto(Integer.valueOf(fdQuantidadeProduto.getText()));
                        produto.setPrecoProduto(Double.valueOf(fdPrecoProduto.getText()));
                        Marca marca = new DAOMarca().obter(1);
                        produto.setMarcaIdMarca(marca);
                        controle.inserir(produto);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdIdProduto.setEnabled(true);
                        fdIdProduto.requestFocus();
                        fdNomeProduto.setEnabled(false);
                        fdQuantidadeProduto.setEnabled(false);
                        fdPrecoProduto.setEnabled(false);
                        comboMarcaidMarca.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        produto = new Produto();
                        produto.setIdProduto(Integer.valueOf(fdIdProduto.getText()));
                        produto.setNomeProduto(fdNomeProduto.getText());
                        produto.setQuantidadeProduto(Integer.valueOf(fdQuantidadeProduto.getText()));
                        produto.setPrecoProduto(Double.valueOf(fdPrecoProduto.getText()));
                        Marca marca = new DAOMarca().obter(1);
                        produto.setMarcaIdMarca(marca);
                        controle.atualizar(produto);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdIdProduto.setEnabled(true);
                        fdIdProduto.requestFocus();
                        fdNomeProduto.setEnabled(false);
                        fdQuantidadeProduto.setEnabled(false);
                        fdPrecoProduto.setEnabled(false);
                        comboMarcaidMarca.setEnabled(false);
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
                fdIdProduto.setEnabled(false);
                fdIdProduto.setText("");
                fdNomeProduto.setEnabled(false);
                fdNomeProduto.setText("");
                fdQuantidadeProduto.setEnabled(false);
                fdQuantidadeProduto.setText("");
                fdPrecoProduto.setEnabled(false);
                fdPrecoProduto.setText("");
                comboMarcaidMarca.setEnabled(false);
                comboMarcaidMarca.setSelectedIndex(0);
                fdIdProduto.setEnabled(true);
                fdIdProduto.requestFocus();
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
                fdNomeProduto.setEnabled(true);
                fdQuantidadeProduto.setEnabled(true);
                fdPrecoProduto.setEnabled(true);
                comboMarcaidMarca.setEnabled(true);
                fdNomeProduto.requestFocus();
                fdIdProduto.setEnabled(false);
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
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + produto.getIdProduto() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(produto);
                    labelAviso.setText("Removido!");
                    fdIdProduto.setText("");
                    fdNomeProduto.setText("");
                    fdNomeProduto.setEnabled(false);
                    fdQuantidadeProduto.setText("");
                    fdQuantidadeProduto.setEnabled(false);
                    fdPrecoProduto.setText("");
                    fdPrecoProduto.setEnabled(false);
                comboMarcaidMarca.setEnabled(false);
                comboMarcaidMarca.setSelectedIndex(0);
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
                new ProdutoGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
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

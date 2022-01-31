package calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class CalculadoraForm extends JFrame { //classe abstrata / para utilizar java swing, precisa estender jframe

    private static final int TAMANHO_TXT = 13;
    protected JPanel pnlForm;
    protected JPanel pnlRodape;

    protected JButton btnCalcular;
    protected JButton btnLimpar;
    protected JButton btnFechar;

    // Capital
    protected JLabel lblCapital;
    protected JTextField txtCapital;
    // Taxa Juros
    protected JLabel lblJuros;
    protected JTextField txtJuros;
    // Periodo
    protected JLabel lblPeriodo;
    protected JTextField txtPeriodo;
    // Montante
    protected JLabel lblMontante;
    protected JTextField txtMontante;

    public CalculadoraForm(){ //construtor

        this.inicializar();
        this.eventos();

    }

    private void inicializar(){
        this.setTitle("Juros Compostos");
        //this.setSize(450, 150);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //encerrar a aplicação quando fechar a janela
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false); //impossibilita a redimencionalização da tela

        this.getContentPane().add(getPnlForm(), BorderLayout.CENTER);
        this.getContentPane().add(getPnlRodape(), BorderLayout.PAGE_END); //posicionando o rodapé
        this.pack(); //calcula o tamanho da tela com base nos elementos adicionados
    }

    protected abstract void btnCalcularClick(ActionEvent ev);
    protected abstract void btnLimparClick(ActionEvent ev);
    protected abstract void btnFecharClick(ActionEvent ev);

    private void eventos(){
        btnCalcular.addActionListener(this::btnCalcularClick);
        btnLimpar.addActionListener(this::btnLimparClick);
        btnFechar.addActionListener(this::btnFecharClick);
    }

    public JPanel getPnlForm() {
        if(pnlForm == null){
            pnlForm = new JPanel(new GridLayout(4, 2));

            lblCapital = new JLabel("Capital (R$)");
            txtCapital = new JTextField(TAMANHO_TXT);

            lblJuros = new JLabel("Taxa Juros (%)");
            txtJuros = new JTextField(TAMANHO_TXT);

            lblPeriodo = new JLabel("Periodo (anos)");
            txtPeriodo = new JTextField(TAMANHO_TXT);

            lblMontante= new JLabel("Montante (R$)");
            txtMontante = new JTextField(TAMANHO_TXT);
            txtMontante.setEditable(false); //torna impossível de editar

            pnlForm.add(lblCapital);
            pnlForm.add(txtCapital);

            pnlForm.add(lblJuros);
            pnlForm.add(txtJuros);

            pnlForm.add(lblPeriodo);
            pnlForm.add(txtPeriodo);

            pnlForm.add(lblMontante);
            pnlForm.add(txtMontante);

        }
        return pnlForm;
    }

    public JPanel getPnlRodape() {
        if(pnlRodape == null) {
            pnlRodape = new JPanel(new FlowLayout(FlowLayout.CENTER));

            btnCalcular = new JButton("Calcular");
            btnLimpar = new JButton("Limpar");
            btnFechar = new JButton("Fechar");

            pnlRodape.add(btnCalcular);
            pnlRodape.add(btnLimpar);
            pnlRodape.add(btnFechar);
        }
        return pnlRodape;
    }
}

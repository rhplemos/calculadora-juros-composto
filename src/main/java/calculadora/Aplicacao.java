package calculadora;

import javax.swing.*;

public class Aplicacao {

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> { //metodo responsavel por não travar a aplicação
            Calculadora calc = new Calculadora();
            calc.setVisible(true);
        });
    }
}

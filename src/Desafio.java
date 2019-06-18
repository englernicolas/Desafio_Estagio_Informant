import javax.swing.JOptionPane;

public class Desafio {
    public static void main(String[] args) {
        while (true) {
            String msg = JOptionPane.showInputDialog(null, "Digite uma palavra ou uma frase: ", "Verificador de palíndromos", JOptionPane.QUESTION_MESSAGE);

            String msgFinal = tirarEspacos(msg);
            msgFinal = msgFinal.toLowerCase();

            msgFinal = tirarAcentos(msgFinal);

            StringBuffer msgInvertida = InverterMsgFinal(msgFinal);
            String msgFinalInvertida = msgInvertida.toString();

            verificadorPalindromo(msg, msgFinal, msgFinalInvertida);

            int continuar = JOptionPane.showConfirmDialog(null, "Deseja verificar outra palavra?", "Verificador de palíndromos", JOptionPane.YES_NO_OPTION);
            if (continuar != JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    // método para tirar os espaços da String
    private static String tirarEspacos(String msg) {
        String msgSemEspaco = "";
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) != ' ') {
                msgSemEspaco += msg.charAt(i);
            }
        }
        return msgSemEspaco;
    }

    // método para tirar os acentos da String já sem os espaços
    private static String tirarAcentos(String msgSemEspacos) {
        String msgSemAcentos = "";
        for (int i = 0; i < msgSemEspacos.length(); i++) {
            char c = msgSemEspacos.charAt(i);
            switch (c) {
                case 'á':
                case 'à':
                case 'ã':
                    c = 'a';
                    break;
                case 'é':
                case 'ê':
                    c = 'e';
                    break;
                case 'í':
                case 'ì':
                    c = 'i';
                    break;
                case 'ó':
                case 'õ':
                case 'ô':
                    c = 'o';
                    break;
                case 'ú':
                    c = 'u';
                    break;
                case 'ç':
                    c = 'c';
                    break;
            }
            msgSemAcentos += c;
        }
        return msgSemAcentos;
    }

    // método para inverter a String já sem acentos ou espaços
    private static StringBuffer InverterMsgFinal(String msgSemAcentosEspacos) {
        StringBuffer msgFinalS = new StringBuffer(msgSemAcentosEspacos);
        msgFinalS.reverse();
        return msgFinalS;
    }

    // método para verificar se a String final é ou não um palíndromo
    private static void verificadorPalindromo(String msg, String msgSemAcentosEspacos, String msgFinalInvertida) {
        if (msgSemAcentosEspacos.equals(msgFinalInvertida)) {
            JOptionPane.showMessageDialog(null, "'" + msg + "' é palíndromo!", "Verificador de palíndromos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "'" + msg + "' não é palíndromo!", "Verificador de palíndromos", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}

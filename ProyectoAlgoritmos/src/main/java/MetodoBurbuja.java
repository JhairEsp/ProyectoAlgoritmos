import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MetodoBurbuja extends JFrame implements ActionListener {
    private JButton ordenarButton;
    private JComboBox<String> seleccionComboBox;
    private JTextArea resultadoTextArea;

    private int[] numeros = {1, 9, 23, 4, 55, 100, 1, 1, 23};
    private String[] nombres = {"Leon", "Chris", "Jill", "Wesker", "Ada"};

    public MetodoBurbuja() {
        setTitle("Ordenar con Método Burbuja");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        seleccionComboBox = new JComboBox<>(new String[]{"Numeros", "Apellidos"});
        panel.add(seleccionComboBox);

        ordenarButton = new JButton("Ordenar");
        ordenarButton.addActionListener(this);
        panel.add(ordenarButton);

        resultadoTextArea = new JTextArea();
        panel.add(new JScrollPane(resultadoTextArea));

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ordenarButton) {
            String seleccion = (String) seleccionComboBox.getSelectedItem();
            if (seleccion.equals("Numeros")) {
                burbuja(numeros);
                resultadoTextArea.setText("Numeros ordenados: " + Arrays.toString(numeros));
            } else if (seleccion.equals("Apellidos")) {
                burbuja(nombres);
                resultadoTextArea.setText("Apellidos ordenados: " + Arrays.toString(nombres));
            }
        }
    }

    private static void burbuja(int[] arreglo) {
        for (int x = 0; x < arreglo.length; x++) {
            for (int y = 0; y < arreglo.length - 1; y++) {
                int elementoActual = arreglo[y];
                int elementoSiguiente = arreglo[y + 1];
                if (elementoActual > elementoSiguiente) {
                    arreglo[y] = elementoSiguiente;
                    arreglo[y + 1] = elementoActual;
                }
            }
        }
    }

    private static void burbuja(String[] arreglo) {
        for (int x = 0; x < arreglo.length; x++) {
            for (int y = 0; y < arreglo.length - 1; y++) {
                String elementoActual = arreglo[y];
                String elementoSiguiente = arreglo[y + 1];
                if (elementoActual.compareTo(elementoSiguiente) > 0) {
                    arreglo[y] = elementoSiguiente;
                    arreglo[y + 1] = elementoActual;
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MetodoBurbuja gui = new MetodoBurbuja();
            gui.setVisible(true);
        });
    }
}

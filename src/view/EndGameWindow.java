
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author tokyo
 */
public class EndGameWindow extends JFrame {
    private Container paneFinish;
    private JLabel titleLabel,attemptsLabel,successesLabel,failuresLabel;
    private JButton getOutL1;
        
    public EndGameWindow(int totalAttempts, int totalSuccesses, int totalFailures){
        super("Geometric - Estadisticas de la partida : ");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Establecer el panel de contenido de la ventana
        paneFinish = getContentPane();
        paneFinish.setLayout(new BorderLayout());

        // Crear un panel para centrar el contenido
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        // Configurar márgenes en el panel interno
        int margin = 20;
        centerPanel.setBorder(BorderFactory.createEmptyBorder(margin, margin, margin, margin));

        // Etiqueta de título
        titleLabel = new JLabel("Fin del Juego");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        centerPanel.add(titleLabel, createGridBagConstraints(0, 0, 2, 1, GridBagConstraints.CENTER));

        // Etiqueta de Intentos
        attemptsLabel = new JLabel("Intentos: " + totalAttempts);
        centerPanel.add(attemptsLabel, createGridBagConstraints(0, 1, 2, 1, GridBagConstraints.CENTER));

        // Etiqueta de Aciertos
        successesLabel = new JLabel("Aciertos: " + totalSuccesses + " (" + ((totalSuccesses * 100) / totalAttempts) + "%)");
        centerPanel.add(successesLabel, createGridBagConstraints(0, 2, 2, 1, GridBagConstraints.CENTER));

        // Etiqueta de Fallos
        failuresLabel = new JLabel("Fallos: " + totalFailures + " (" + ((totalFailures * 100) / totalAttempts) + "%)");
        centerPanel.add(failuresLabel, createGridBagConstraints(0, 3, 2, 1, GridBagConstraints.CENTER));

        paneFinish.add(centerPanel, BorderLayout.CENTER);
    // Botón de Salir
    getOutL1 = new JButton("Cerrar");
    getOutL1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Cierra el programa
            System.exit(0);
        }
    });
    paneFinish.add(getOutL1, BorderLayout.SOUTH);
    }

    private GridBagConstraints createGridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.anchor = anchor;
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes
        return gbc;
    }
}

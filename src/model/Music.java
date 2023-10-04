package model;

import javax.sound.sampled.*;
import java.io.*;

/**
 * Clase para traer un archivo .wav y reproducirlo.
 */

public class Music {
    

    /**
     * Método encargado de buscar y reproducir el audio.
     * @param
     * @return
     */
    public void soundtrackstart(float volume) {
        try {
            // Carga el archivo de audio
            File audioFile = new File("src/audio.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
    
            // Obtiene un Clip para reproducir el audio
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            
            
            // Ajusta el volumen de reproducción
            if (audioClip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                FloatControl gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
                // Establece el valor de ganancia para reducir el volumen
                gainControl.setValue(volume);
            }
    
            // Reproduce el audio
            audioClip.start();

    
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}

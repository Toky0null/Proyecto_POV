/**
 *
 * @author tokyo - Juna Sebastian Hurtado Batioja 2179288
 * @author kevin David Londoño Valencia-2224551
 */


package model;

import javax.sound.sampled.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
   
      /**
     * Método para reproducir un sonido de error.
     */
    
    public void playErrorSound() {
        try {
            // Carga el archivo de audio de error
            File errorAudioFile = new File("src/error.wav");
            AudioInputStream errorAudioStream = AudioSystem.getAudioInputStream(errorAudioFile);

            // Obtiene un Clip para reproducir el audio de error
            Clip errorAudioClip = AudioSystem.getClip();
            errorAudioClip.open(errorAudioStream);
            // Reproduce el audio de error en un hilo separado
            Thread errorThread = new Thread(() -> {
                errorAudioClip.start();
                errorAudioClip.drain(); // Espera hasta que la reproducción esté completa
                errorAudioClip.close();
            });
            // Reproduce el audio de error
            errorAudioClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
     /**
     * Método para reproducir un sonido de correcto.
     */
    public void playCorrectSound() {
        try {
            // Carga el archivo de audio de correcto
            File correctAudioFile = new File("src/correct.wav");
            AudioInputStream correctAudioStream = AudioSystem.getAudioInputStream(correctAudioFile);

            // Obtiene un Clip para reproducir el audio de correcto
            Clip correctAudioClip = AudioSystem.getClip();
            correctAudioClip.open(correctAudioStream);
            Thread correctThread = new Thread(() -> {
                correctAudioClip.start();
                correctAudioClip.drain();
                correctAudioClip.close();
            });
            correctThread.start();
            // Reproduce el audio de correcto
            correctAudioClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_form;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Barubalz
 * Using webcam library implemented by user sarxos
 */
public class ImageCapture extends JFrame{
    private class SnapMeAction extends AbstractAction {

		public SnapMeAction() {
			super("Snapshot");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				File file = new File(String.format(picType + ".jpg"));
                                file.deleteOnExit();
                                if(file.exists()){
                                    file.delete();}
                                ImageIO.write(webcam.getImage(), "JPG", file);
                                
				System.out.println("Image saved in " + file.getAbsolutePath());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
                        panel.stop();
                        webcam.close();
                        executor.shutdownNow();
                        dispose();
		}
	}

	private class StartAction extends AbstractAction implements Runnable {

		public StartAction() {
			super("Start");
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			btStart.setEnabled(false);
			btSnapMe.setEnabled(true);

			// remember to start panel asynchronously - otherwise GUI will be
			// blocked while OS is opening webcam HW (will have to wait for
			// webcam to be ready) and this causes GUI to hang, stop responding
			// and repainting

			executor.execute(this);
		}

		@Override
		public void run() {
			panel.start();
                        
		}
	}

    	private ExecutorService executor = Executors.newSingleThreadExecutor();

	private Dimension captureSize = WebcamResolution.VGA.getSize();
	private Dimension displaySize = WebcamResolution.QQVGA.getSize();

	private Webcam webcam = Webcam.getDefault();
        
	private WebcamPanel panel;
        
	private JButton btSnapMe = new JButton(new SnapMeAction());
	private JButton btStart = new JButton(new StartAction());
        
        private String picType; 

	public ImageCapture(String type, int webcamno) {

		super("Image Capture");

		webcam = Webcam.getWebcams().get(webcamno);
                webcam.setViewSize(captureSize);
                
                panel = new WebcamPanel(webcam, displaySize, false);
		picType = type;
		panel.setFillArea(true);
                System.out.println(picType);
		// start application with disable snapshot button - we enable it when
		// webcam is started
                
		btSnapMe.setEnabled(false);

		setLayout(new FlowLayout());
		add(panel);
		add(btSnapMe);
		add(btStart);
                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
                int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
                this.setLocation(x,y);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                this.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent evt) {
                        onExit();
                    }
                });

	}
        
        public void onExit() {
            this.webcam.close();
            this.dispose();
        }   

	public static void main(String[] args) {

	}
}

import java.awt.EventQueue;
import java.awt.Image;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;


public class Main {

	private JLabel gifBackground = new JLabel("");
	private JFrame frmHackermanPoljakExclusive;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmHackermanPoljakExclusive.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Main() throws UnsupportedAudioFileException, Exception {
		initialize();
		
		//Update GIF background
			try{
				ImageIcon image = new ImageIcon(new ImageIcon( (getClass().getResource("hackerman.gif")) ).getImage().getScaledInstance(800, 560, Image.SCALE_DEFAULT));
			    gifBackground.setIcon(image);
			} 
			catch (Exception x){ 
			    	System.out.println("Image could not be loaded ERROR:" +x); 
			    }
		//Play music
			try{
			    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream( getClass().getResource("lostyears.wav") );
			    Clip clip = AudioSystem.getClip();
			    clip.open(audioInputStream);
			    clip.start();
			} 
			catch(Exception x){
				System.out.println("Music could not be loaded ERROR:"+x); 
			}
			
		//Switch to other window after 2.8sec (time needed for GIF to end)	
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	frmHackermanPoljakExclusive.dispose();
							 Main_Decypher.newScreen();
			            }
			        }, 2800
			);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Set up the window
			frmHackermanPoljakExclusive = new JFrame();
			frmHackermanPoljakExclusive.getContentPane().setBackground(Color.DARK_GRAY);
			frmHackermanPoljakExclusive.setBackground(Color.DARK_GRAY);
			frmHackermanPoljakExclusive.setResizable(false);
			frmHackermanPoljakExclusive.setTitle("Hackerman Poljak Exclusive");
			frmHackermanPoljakExclusive.setBounds(100, 100, 780, 580);
			frmHackermanPoljakExclusive.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmHackermanPoljakExclusive.getContentPane().setLayout(null);
		//Add GIF to JLabel
			gifBackground.setBounds(0, 0, 774, 562);
			frmHackermanPoljakExclusive.getContentPane().add(gifBackground);
	}
}
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Aula {
	public static void main(String[] args) throws IOException {
		
		
		
			File f = new File("C:\\Users\\allis\\Documents\\mel.png");
			BufferedImage image = ImageIO.read(f);
			System.out.println("Leitura completa");
			ImageIO.write(image, "jpg", new File("C:\\Users\\allis\\Documents\\mel2.jpg"));
			System.out.println("Saída completa.");
			
			int largura = image.getWidth();
			int altura = image.getHeight();
			System.out.println("w: " + largura + "	h: " + altura);
	
			JLabel meulabel = new JLabel(new ImageIcon(image));
			JPanel meupanel = new JPanel();
			meupanel.add(meulabel);
			JFrame meuframe = new JFrame();
			meuframe.setSize(new Dimension(largura,altura));
			meuframe.add(meupanel);
			meuframe.setVisible(true);
			
			
	}
} 

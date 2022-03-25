//pintar o primeiro pixel da imagem de azul
//pintar o pixel central de verde
//pintar o ultimo pioxel de vermelho
//percorrer a imagem pixel a pixel
//exibir o rgb de cada pixel
import java.awt.Color;
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
			int largura = image.getWidth();
			int altura = image.getHeight();
			System.out.println("w: " + largura + "	h: " + altura);
			Color azul = new Color(0,0,255);
			Color verde = new Color(0,255,0);
			Color vermelho = new Color(255,0,0);
			image.setRGB(0,0,azul.getRGB());
			image.setRGB(largura/ 2,altura/ 2, verde.getRGB());
			image.setRGB(largura - 1, altura - 1, vermelho.getRGB());
			
			for(int linha = 0; linha < altura; linha++) {
				for(int coluna = 0; coluna < largura; coluna++) {
					Color c =  new Color(image.getRGB(coluna, linha));
					int verm = c.getRed();
					int verd = c.getGreen();
					int azu = c.getBlue();
					System.out.println("LINHA: "+linha+" | COLUNA: "+coluna+" | Vermelho = " + verm + " Verde = " + verd + " Azul = "+azu);
				}
			}
			
			ImageIO.write(image, "jpg", new File("C:\\Users\\allis\\Documents\\mel3.jpg"));
			System.out.println("Saída completa.");
			
			
			
	
			JLabel meulabel = new JLabel(new ImageIcon(image));
			JPanel meupanel = new JPanel();
			meupanel.add(meulabel);
			JFrame meuframe = new JFrame();
			meuframe.setSize(new Dimension(largura,altura));
			meuframe.add(meupanel);
			meuframe.setVisible(true);
			
	}
} 

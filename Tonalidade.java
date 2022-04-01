import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
		System.out.println("Digite um valor para aumentar o tom: ");
		Scanner teclado = new Scanner(System.in);
		int aumento = teclado.nextInt();
		System.out.println("Selecione a banda para aumentar o tom: 1 - R  | 2 - G  | 3 - B");
		Scanner miojo = new Scanner(System.in);
		int banda = miojo.nextInt();		
		BufferedImage saidaR = bandaR(image, aumento);
		BufferedImage saidaG = bandaG(image, aumento);
		BufferedImage saidaB = bandaB(image, aumento);
		
		if (banda == 1) {
			JLabel meulabel2 = new JLabel(new ImageIcon(saidaR));
			JPanel meupanel2 = new JPanel();
			meupanel2.add(meulabel2);
			JFrame meuframe2 = new JFrame();
			meuframe2.setSize(new Dimension(largura,altura));
			meuframe2.add(meupanel2);
			meuframe2.setVisible(true);
		}
		else if (banda == 2) {
			JLabel meulabel3 = new JLabel(new ImageIcon(saidaG));
			JPanel meupanel3 = new JPanel();
			meupanel3.add(meulabel3);
			JFrame meuframe3 = new JFrame();
			meuframe3.setSize(new Dimension(largura,altura));
			meuframe3.add(meupanel3);
			meuframe3.setVisible(true);
		}
		else if (banda ==3) {
			JLabel meulabel4 = new JLabel(new ImageIcon(saidaB));
			JPanel meupanel4 = new JPanel();
			meupanel4.add(meulabel4);
			JFrame meuframe4 = new JFrame();
			meuframe4.setSize(new Dimension(largura,altura));
			meuframe4.add(meupanel4);
			meuframe4.setVisible(true);
		}
		teclado.close();
		miojo.close();
	}
		public static BufferedImage bandaR (BufferedImage image, int aumento) {
			int altura = image.getHeight();
			int largura = image.getWidth();
			
			BufferedImage saidaR = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			for(int linha = 0; linha < altura; linha++) {
				for(int coluna = 0; coluna < largura; coluna++) {
					int rgb = image.getRGB(coluna,linha);
					Color c = new Color(rgb);
					int red = c.getRed();
					Color bandaunicaR = new Color(red,0,0);
					
					saidaR.setRGB(coluna,linha,bandaunicaR.getRGB());
					
				}
			}
			
			return saidaR;
		
		
	}
		public static BufferedImage bandaG (BufferedImage image, int aumento) {
			int altura = image.getHeight();
			int largura = image.getWidth();
			
			BufferedImage saidaG = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			for(int linha = 0; linha < altura; linha++) {
				for(int coluna = 0; coluna < largura; coluna++) {
					int rgb = image.getRGB(coluna,linha);
					Color c = new Color(rgb);
					int green = c.getGreen();
					int aumentoTon = tonalidade(aumento, green);
					Color bandaunicaG = new Color(0,aumentoTon,0);
					saidaG.setRGB(coluna,linha,bandaunicaG.getRGB());
					
				}
			}
			
			return saidaG;
		
		
	}
		public static BufferedImage bandaB (BufferedImage image, int aumento) {
			int altura = image.getHeight();
			int largura = image.getWidth();
			
			BufferedImage saidaB = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			
			for(int linha = 0; linha < altura; linha++) {
				for(int coluna = 0; coluna < largura; coluna++) {
					int rgb = image.getRGB(coluna,linha);
					Color c = new Color(rgb);
					int blue = c.getBlue();
					int aumentoTon = tonalidade(aumento,blue);
					Color bandaunicaB = new Color(0,0,aumentoTon);
					saidaB.setRGB(coluna,linha,bandaunicaB.getRGB());
					
				}
			}
			
			return saidaB;
		
		
	}
		public static int tonalidade (int aumento, int pixel) {
			if (aumento + pixel < 0) {aumento = 0;}
			else if (aumento + pixel > 255) {aumento = 255;}
			else {aumento = aumento + pixel;}
			return aumento;
			
		};
} 

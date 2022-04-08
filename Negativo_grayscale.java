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
		BufferedImage saidaR = bandaR(image);
		BufferedImage saidaG = bandaG(image);
		BufferedImage saidaB = bandaB(image);
		BufferedImage saidaGray = bandaGray(image);
		BufferedImage neg = negativo(image);
		System.out.println("Digite o filtro: 1| Negativo      2| GrayScale");
		Scanner filtro = new Scanner(System.in);
		int fil = filtro.nextInt();
		if(fil == 2) {
		
			System.out.println("Digite o método: 1 | Banda      2 | Média");
			Scanner teclado = new Scanner(System.in);
			int metodo = teclado.nextInt();
			if (metodo == 1) {
				System.out.println("Selecione a banda: 1 - R  | 2 - G  | 3 - B");
				Scanner miojo = new Scanner(System.in);
				int banda = miojo.nextInt();		
				
				
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
			else {
				JLabel meulabel2 = new JLabel(new ImageIcon(saidaGray));
				JPanel meupanel2 = new JPanel();
				meupanel2.add(meulabel2);
				JFrame meuframe2 = new JFrame();
				meuframe2.setSize(new Dimension(largura,altura));
				meuframe2.add(meupanel2);
				meuframe2.setVisible(true);
			}
				
			}
		else {
			JLabel meulabel2 = new JLabel(new ImageIcon(neg));
			JPanel meupanel2 = new JPanel();
			meupanel2.add(meulabel2);
			JFrame meuframe2 = new JFrame();
			meuframe2.setSize(new Dimension(largura,altura));
			meuframe2.add(meupanel2);
			meuframe2.setVisible(true);
		}
		filtro.close();
		}
		
		public static BufferedImage bandaR (BufferedImage image) {
			int altura = image.getHeight();
			int largura = image.getWidth();
			
			BufferedImage saidaR = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			for(int linha = 0; linha < altura; linha++) {
				for(int coluna = 0; coluna < largura; coluna++) {
					int rgb = image.getRGB(coluna,linha);
					Color c = new Color(rgb);
					int red = c.getRed();
					Color bandaunicaR = new Color(red,red,red);
					
					saidaR.setRGB(coluna,linha,bandaunicaR.getRGB());
					
				}
			}
			
			return saidaR;
		
		
	}
		public static BufferedImage bandaG (BufferedImage image) {
			int altura = image.getHeight();
			int largura = image.getWidth();
			
			BufferedImage saidaG = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			for(int linha = 0; linha < altura; linha++) {
				for(int coluna = 0; coluna < largura; coluna++) {
					int rgb = image.getRGB(coluna,linha);
					Color c = new Color(rgb);
					int green = c.getGreen();
					Color bandaunicaG = new Color(green,green,green);
					saidaG.setRGB(coluna,linha,bandaunicaG.getRGB());
					
				}
			}
			
			return saidaG;
		
		
	}
		public static BufferedImage negativo (BufferedImage image) {
			int altura = image.getHeight();
			int largura = image.getWidth();
			
			BufferedImage neg = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			
			for(int linha = 0; linha < altura; linha++) {
				for(int coluna = 0; coluna < largura; coluna++) {
					int rgb = image.getRGB(coluna,linha);
					Color c = new Color(rgb);
					int red = c.getRed();
					int green = c.getGreen();
					int blue = c.getBlue();
					Color bandaunicaB = new Color((255 - red),(255 - green),(255 - blue));
					neg.setRGB(coluna,linha,bandaunicaB.getRGB());
					
				}
			}
			
			return neg;
		
		
	}
		public static BufferedImage bandaGray (BufferedImage image) {
			int altura = image.getHeight();
			int largura = image.getWidth();
			
			BufferedImage saidaGray = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			
			for(int linha = 0; linha < altura; linha++) {
				for(int coluna = 0; coluna < largura; coluna++) {
					int rgb = image.getRGB(coluna,linha);
					Color c = new Color(rgb);
					int red = c.getRed();
					int green = c.getGreen();
					int blue = c.getBlue();
					int gray = (red + green + blue) / 3;
					Color bandaunicaB = new Color(gray,gray,gray);
					saidaGray.setRGB(coluna,linha,bandaunicaB.getRGB());
					
				}
			}
			
			return saidaGray;
		
		
	}

		public static BufferedImage bandaB (BufferedImage image) {
			int altura = image.getHeight();
			int largura = image.getWidth();
			
			BufferedImage saidaB = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
			
			for(int linha = 0; linha < altura; linha++) {
				for(int coluna = 0; coluna < largura; coluna++) {
					int rgb = image.getRGB(coluna,linha);
					Color c = new Color(rgb);
					int blue = c.getBlue();
					Color bandaunicaB = new Color(blue,blue,blue);
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

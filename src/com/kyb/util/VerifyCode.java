package com.kyb.util;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;

//import org.apache.jasper.tagplugins.jstl.core.ForEach;

//import com.sun.prism.paint.Color;

public class VerifyCode {
	
	public static final char [ ]CHARS = {'2','3','4','5','6','7','8','9',
			'A','B','C','D','E','F','G','H','J','K', 'L', 'M','N', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	public static Random random = new Random();
	
	public String getRandomString() {
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<4;i++) {
		buffer.append(CHARS[random.nextInt(CHARS.length)]);
		}
		return buffer.toString();
	}
	
	public Color getRandomColor() {
		return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255),255);
				}
	public Color getRsverseColor(Color c) {
		return new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue(),255);
		
	}
	String text = getRandomString();
	public String getText() {
		return text;
	}
	
	public BufferedImage getImage(int width,int height) {
		Color color = getRandomColor();
		Color reserve = getRsverseColor(color);
		
		BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bImage.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reserve);
		g.drawString(text, 10, 22);
		for (int i =0,n=random.nextInt(80);i<n;i++) {
			g.drawRect(random.nextInt(width),random.nextInt(height), 1, 1);
		}
		return bImage;
		
	}

	public static void output(BufferedImage image,OutputStream out) throws IOException
	{
		ImageIO.write(image, "JPEG", out);
	}
}

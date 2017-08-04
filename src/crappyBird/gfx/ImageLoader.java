package crappyBird.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
public static BufferedImage LoadImage(String path)
{
	try {
		return ImageIO.read(ImageLoader.class.getResource(path));//return buffer loaded image of our image 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.exit(1);
	}
	return null;
	
}
}

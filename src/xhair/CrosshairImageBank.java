package xhair;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * The Class CrosshairImageBank.
 *
 * @author Doga Oruc
 * @version 1.0
 * @since 1.0
 */
public final class CrosshairImageBank {

	/**
	 * Private constructor
	 */
	private CrosshairImageBank() {}

	/**
	 * Gets the image.
	 *
	 * @param index the index to be accessed
	 * @return the image retrieved from the file system
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static BufferedImage getImage(final String index) throws IOException {
		return ImageIO.read(CrosshairImageBank.class.getResourceAsStream("/crosshair" + index + ".png"));
	}

	/**
	 * Gets the image.
	 *
	 * @param index the index to be accessed
	 * @return the image retrieved from the file system
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static BufferedImage getImage(final int index) throws IOException {
		final String s = String.valueOf(index);
		if (s.length() == 3) {
			return CrosshairImageBank.getImage(s);
		} else if (s.length() == 2) {
			return CrosshairImageBank.getImage("0" + s);
		} else if (s.length() == 1) {
			return CrosshairImageBank.getImage("00" + s);
		} else {
			return null;
		}
	}

	/**
	 * Supply all images as icons. Used for Crosshair Selection ComboBox.
	 *
	 * @return the image icon array
	 */
	@SuppressWarnings("unused")
	public static ImageIcon[] supplyAllImagesAsIcons() {
		final List<ImageIcon> bf = new ArrayList<>();
		int i = 1;
		try {
			for (; true; i++) {
				bf.add(new ImageIcon(CrosshairImageBank.getImage(i)));
			}
		} catch (IOException | IllegalArgumentException ex) {
			System.out.println("STOPPING...");
			System.out.println("Found " + (i - 1) + " images.");
		}
		return bf.toArray(new ImageIcon[bf.size()]);
	}
}

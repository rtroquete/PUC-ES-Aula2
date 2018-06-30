package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class ScaledImageAcquirer implements ScannerImageAcquirer {
	
	private ScannerImageAcquirer imageAcquirer;
	
	private int width = 640;
	private int height = 480;
	
	public ScaledImageAcquirer(ScannerImageAcquirer imageAcquirer, int width, int height) {
		this.imageAcquirer = imageAcquirer;
		this.width = width;
		this.height = height;
	}

	@Override
	public ImageData getImagesFromScanner() {
		ImageData image = this.imageAcquirer.getImagesFromScanner();
		return image.scale(width, height);
	}

	@Override
	public boolean isScannerPresent() {
		return this.imageAcquirer.isScannerPresent();
	}

}

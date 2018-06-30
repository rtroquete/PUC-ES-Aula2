package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class GrayImageAcquirer implements ScannerImageAcquirer {
	
	private ScannerImageAcquirer imageAcquirer;
	
	public GrayImageAcquirer(ScannerImageAcquirer imageAcquirer) {
		this.imageAcquirer = imageAcquirer;
	}

	@Override
	public ImageData getImagesFromScanner() {
		ImageData image = this.imageAcquirer.getImagesFromScanner();
		return image.toGrayScale();
	}

	@Override
	public boolean isScannerPresent() {
		return this.imageAcquirer.isScannerPresent();
	}

}

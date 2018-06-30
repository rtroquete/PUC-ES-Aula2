package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ImageData;
import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class PersistImageAcquirer implements ScannerImageAcquirer {
	
	private ScannerImageAcquirer imageAcquirer;
	private String filename;
	
	public PersistImageAcquirer(ScannerImageAcquirer imageAcquirer, String filename) {
		this.imageAcquirer = imageAcquirer;
		this.filename = filename;
	}

	@Override
	public ImageData getImagesFromScanner() {
		ImageData image = this.imageAcquirer.getImagesFromScanner();
		return image.saveToFile(this.filename);
	}

	@Override
	public boolean isScannerPresent() {
		return this.imageAcquirer.isScannerPresent();
	}

}

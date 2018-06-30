package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;

public class ScannerImageAcquirerBuilder {
	
	private ScannerImageAcquirer imageAcquirer;
	
	public ScannerImageAcquirerBuilder() {
		imageAcquirer = ScannerImageAcquirerFactory.get();
	}
	
	public ScannerImageAcquirerBuilder withGrayScale() {
		this.imageAcquirer = new GrayImageAcquirer(this.imageAcquirer);
		return this;
	}
	
	public ScannerImageAcquirerBuilder withScale(int width, int height) {
		this.imageAcquirer = new ScaledImageAcquirer(this.imageAcquirer, width, height);
		return this;
	}
	
	public ScannerImageAcquirerBuilder withPNGConverter() {
		this.imageAcquirer = new PNGImageAcquirer(this.imageAcquirer);
		return this;
	}
	
	public ScannerImageAcquirerBuilder saveToFile(String filename) {
		this.imageAcquirer = new PersistImageAcquirer(imageAcquirer, filename);
		return this;
	}
	
	public ScannerImageAcquirer build() {
		return this.imageAcquirer;
	}

}

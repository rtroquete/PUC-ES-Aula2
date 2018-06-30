package br.puc.se.designPatterns.structural.nativelibrary;

import br.puc.se.designPatterns.structural.nativelibrary.drivers.ScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.linux.LinuxCannonScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.linux.LinuxKodakScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.mac.MacCannonScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.mac.MacKodakScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.windows.WindowsCannonScannerImageAcquirer;
import br.puc.se.designPatterns.structural.nativelibrary.windows.WindowsKodakScannerImageAcquirer;

public class ScannerImageAcquirerFactory {

	public static ScannerImageAcquirer get() {
		String so = System.getProperty("imageAcquirer.so", "linux");

		ScannerImageAcquirer imageAcquirer = null;

		if (so.equalsIgnoreCase("linux")) {
			imageAcquirer = new LinuxKodakScannerImageAcquirer();
			if (!imageAcquirer.isScannerPresent()) {
				imageAcquirer = new LinuxCannonScannerImageAcquirer();
			}
		}
		if (so.equalsIgnoreCase("windows")) {
			imageAcquirer = new WindowsKodakScannerImageAcquirer();
			if (!imageAcquirer.isScannerPresent()) {
				imageAcquirer = new WindowsCannonScannerImageAcquirer();
			}
		}
		if (so.equalsIgnoreCase("mac")) {
			imageAcquirer = new MacKodakScannerImageAcquirer();
			if (!imageAcquirer.isScannerPresent()) {
				imageAcquirer = new MacCannonScannerImageAcquirer();
			}
		}

		return imageAcquirer;
	}

}

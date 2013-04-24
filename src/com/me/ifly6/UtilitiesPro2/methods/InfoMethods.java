package com.me.ifly6.UtilitiesPro2.methods;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.me.ifly6.UtilitiesPro2.ConsoleIf;
import com.me.ifly6.UtilitiesPro2.Parametres;
import com.me.ifly6.UtilitiesPro2.TextProc;

/**
 * @since 2.2_01
 * @deprecated
 */
@Deprecated
public class InfoMethods extends TextProc {
	// Name: Methods for Providing Information About Utilities Pro
	private static final long serialVersionUID = 1L;

	public static void about() {
		append("== About Utilities Pro " + Parametres.version + " ==");
		out(Parametres.copyright);
		out("Version " + Parametres.version + " '" + Parametres.keyword + "'");
	}

	public static void acknowledgements() throws IOException {
		mkdir();
		String[] url = { "curl", "-o",
				UtilitiesPro_DIR + "/acknowledgements.txt",
				"http://ifly6.no-ip.org/Utilities Pro/acknowledgements.txt" };
		rt.exec(url);
		fstream = new FileReader(
				"/Users/"
						+ userName
						+ "/Library/Application Support/Utilities Pro/acknowledgements.txt");
		Scanner scan = new Scanner(fstream);
		while (scan.hasNextLine()) {
			ConsoleIf.append(scan.nextLine());
		}
		log("Acknowledgements Processing Trigger Completed");
	}

	public static void changelog() throws IOException {
		mkdir();
		String[] url = { "curl", "-o", UtilitiesPro_DIR + "/changelog.txt",
				"http://ifly6.no-ip.org/iUtilities/changelog.txt" };
		rt.exec(url);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		fstream = new FileReader(UtilitiesPro_DIR + "/changelog.txt");
		Scanner scan = new Scanner(fstream);
		while (scan.hasNextLine()) {
			ConsoleIf.append(scan.nextLine());
		}
		log("Changelog Processing Trigger Completed");
	}

	public static void info() throws InterruptedException, IOException {
		log("System Readout Invoked.");
		setText(null);
		append("Generated By: " + Parametres.version + " '"
				+ Parametres.keyword + "' \n");
		append(" -- Current Running Processes -- ");
		String[] com = { "ps", "ax" };
		String[] com1 = { "ifconfig" };
		String[] com2 = { "lsof", "-i" };
		Process proc = rt.exec(com);
		Process proc1 = rt.exec(com1);
		Process proc2 = rt.exec(com2);

		InputStream stderr = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(stderr);
		Scanner scan = new Scanner(isr);
		while (scan.hasNextLine()) {
			out(scan.nextLine());
		}

		InputStream stderr1 = proc1.getInputStream();
		InputStreamReader isr1 = new InputStreamReader(stderr1);
		scan = new Scanner(isr1);
		append(" -- Internet Interface Information -- ");
		while (scan.hasNextLine()) {
			out(scan.nextLine());
		}

		InputStream stderr2 = proc2.getInputStream();
		InputStreamReader isr2 = new InputStreamReader(stderr2);
		scan = new Scanner(isr2);
		append(" -- Processes Information -- ");
		while (scan.hasNextLine()) {
			out(scan.nextLine());
		}

		// Hardware
		out("");
		out("Note: Due to the nature of Java, there may be errors in the memory readout.");
		out("Available cores: " + rt.availableProcessors());
		out("Free memory (kilobytes): " + (rt.freeMemory() / 1024));
		long maxMemory = rt.maxMemory();
		out("Max. memory (Kilobytes): " + (maxMemory / 1024));
		out("Total memory (Kilobytes): " + (rt.totalMemory() / 1024));
		File[] roots = File.listRoots();
		out("");
		for (File root : roots) {
			out("File System root: " + root.getAbsolutePath());
			out("File System Capacity (bytes): " + root.getTotalSpace());
			out("File System Free (bytes): " + root.getFreeSpace());
			out("File System Usable (bytes): " + root.getUsableSpace());
		}
		out("");
		out(System.getProperty("java.runtime.name") + " version "
				+ System.getProperty("java.runtime.version")
				+ System.getProperty("java.vm.version") + " by "
				+ System.getProperty("java.vm.vendor"));
		out("Execution Directory: " + System.getProperty("user.dir"));
		out("");
		String nameOS = "os.name";
		String versionOS = "os.version";
		out("Operating System: " + System.getProperty(nameOS) + " "
				+ System.getProperty(versionOS));
		out("User: " + System.getProperty("user.name") + " ... with Home at: "
				+ System.getProperty("user.home"));
	}

	public static void licence() {
		append("Utilities Pro Licence");
		out("* You accept all responsibility for anything caused by this programme.");
		out("* You will not change this programme to preform malicious work.");
		out("* You will credit the authors of this programme for anything based heavily upon it.");
		out("* You will not use this programme to accomplish anything illegal.");
		out("* You will not claim warranty or mandate assistance from anyone on this programme.");
		out("* You will not distribute any modified copies under the author's name.");
		out("* Any distribution of a modified version of this programme must be accompanied by public source.");
		out("* Any distribution of a modified version of this programme will be following this same licence.");
		out("By the way, if you actually read this, we are highly surprised.");
	}
}
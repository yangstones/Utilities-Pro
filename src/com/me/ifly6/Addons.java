package com.me.ifly6;

import java.io.*;

public class Addons {

	static Runtime rt = Runtime.getRuntime();
	static String userName = System.getProperty("user.name");

	public static void save(String[] args) throws IOException {
		Console.log.append("\nOutput Saving System Invoked.");
		String report = Console.output.getText();
		long time = System.currentTimeMillis();
		File f = new File("/Users/" + userName + "/Library/Application Support/iUtilities");
		f.mkdirs();
		Writer output = null;
		File file = new File("/Users/" + userName + "/Library/Application Support/iUtilities/report" + time + ".txt");
		output = new BufferedWriter(new FileWriter(file));
		output.write(report);
		output.close();
		Console.output.append("Contents Exported.");
	}
	public static void script() {
		Console.output.append("\n** Checking ~/Library/Application Support/iUtilities/script/check.txt");
		// Some stuff.
	}
	public static void mindterm() throws IOException {
		File folder = new File("/Users/" + userName + "/Library/Application Support/iUtilities/");
		folder.mkdirs();
		String[] url = { "curl", "-o", "/Users/" + userName + 
				"/Library/Application Support/iUtilities/mindterm.jar", "http://ifly6server.no-ip.org/Public/mindterm.jar" };
		rt.exec(url);
		Console.log.append("\nMindterm Download Invoked.");
		Console.output.append("\nMindterm Downloaded to: " + "/Users/" + userName + "/Library/Application Support/iUtilities");
	}

	public static void purge(String[] args) throws IOException {
		Console.log.append("\nInactive Memory Purged");
		Console.output.append("\n" + Console.computername + "~ $ purge");
		Console.log.append("\nMindterm Download Invoked.");
		Console.output.append("\nMindterm Downloaded to: " + "/Users/" + userName + "/Library/Application Support/iUtilities" +
				"\nThis is a full Java Based SSH/Telnet Client, capable of using SSH -D.");
	}
	public static void debug(String[] args) throws IOException {
		Console.log.append("\niUtilities Debug Readout Command Executed");
		String debug = Console.log.getText();
		long time = System.currentTimeMillis();
		File f = new File("/Users/" + userName + "/Library/Application Support/iUtilities");
		f.mkdirs();
		Writer output = null;
		File file = new File("/Users/" + userName + "/Library/Application Support/iUtilities/report" + time + ".txt");
		output = new BufferedWriter(new FileWriter(file));
		output.write(debug);
		output.close();
		Console.output.append("\nDebug Contents Exported to File: ~/Library/Application Support/iUtilities");
	}
	public static void info(String[] args) throws InterruptedException, IOException{
		Console.log.append("\nSystem Readout Invoked.");
		Console.output.setText(null);
		Console.output.append("Generated By: " + Info.version + " '" + Info.password + "' \n");
		Console.output.append(" -- Current Running Processes -- \n");
		String[] com = { "ps", "ax" };
		String[] com1 = { "ifconfig" };
		Process proc = rt.exec(com);
		Process proc1 = rt.exec(com1);

		InputStream stderr = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(stderr);
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		while ((line = br.readLine()) != null) {
			Console.output.append(line + "\n"); }

		InputStream stderr1 = proc1.getInputStream();
		InputStreamReader isr1 = new InputStreamReader(stderr1);
		BufferedReader br1 = new BufferedReader(isr1);
		String line1 = null;
		Console.output.append("\n -- Internet Information -- \n");
		while ((line1 = br1.readLine()) != null) {
			Console.output.append(" " + line1 + "\n");
		}
		
		// Hardware
		Console.output.append("\nAvailable cores: " + 
				Runtime.getRuntime().availableProcessors());
		Console.output.append("\nFree memory (bytes): " + 
				Runtime.getRuntime().freeMemory());
		long maxMemory = Runtime.getRuntime().maxMemory();
		Console.output.append("\nMax. memory (bytes): " + (Long.valueOf(maxMemory)));
		Console.output.append("\nTotal memory (bytes): " + 
				Runtime.getRuntime().totalMemory());
		File[] roots = File.listRoots();
		Console.output.append("\n");
		for (File root : roots) {
			Console.output.append("\nFile system root: " + root.getAbsolutePath());
			Console.output.append("\nFS Capacity (bytes): " + root.getTotalSpace());
			Console.output.append("\nFS Free (bytes): " + root.getFreeSpace());
			Console.output.append("\nFS Usable (bytes): " + root.getUsableSpace());
		}
		Console.output.append("\n");
		Console.output.append("\n" + System.getProperty("java.runtime.name") + " version " + System.getProperty("java.runtime.version") + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor"));
		Console.output.append("\nExecution Directory: " + System.getProperty("user.dir"));
		Console.output.append("\n");
		String nameOS = "os.name";
		String versionOS = "os.version";
		Console.output.append("\nOperating System: " + System.getProperty(nameOS) + " " + System.getProperty(versionOS));
		Console.output.append("\nUser: " + System.getProperty("user.name") + " ... with Home at: " + System.getProperty("user.home"));
		Console.output.append("\nDesktop: " + System.getProperty("sun.desktop"));
	}
	public static void delete(String[] args) throws IOException {
		Console.log.append("\niUtilities Folder Deletion Commencing.");
		String[] delete = {"rm","-rf","'~/Library/Application Support/iUtilities'"};
		ProcessBuilder builder = new ProcessBuilder(delete);
		builder.start();
	}
}

package ch23.ex03;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class CommandExecutor {

	private static final String FINISH_INDICATOR = "ping";

	public static void main(String[] args) throws IOException {

		for (String cmd : args)
			userProg(cmd);
	}

	public static Process userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	private static void plugTogether(PrintStream out, InputStream inputStream) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					LineNumberReader reader = new LineNumberReader(new InputStreamReader(inputStream, "SHIFT-JIS"));
					// InputStreamReader reader = new InputStreamReader(inputStream);
					String input;
					while ((input = reader.readLine()) != null) {

						if (input.contains(FINISH_INDICATOR))
							break;
						out.println(reader.getLineNumber() + " > " + input);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}).start();
	}

	private static void plugTogether(InputStream in, OutputStream outputStream) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					int input = 0;
					InputStreamReader reader = new InputStreamReader(in);
					OutputStreamWriter out = new OutputStreamWriter(outputStream, "SHIFT-JIS");
					// OutputStreamWriter out = new OutputStreamWriter(outputStream);
					while ((input = reader.read()) != -1) {
						out.write(input);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}).start();
	}
}

/* Copyright (c) 2015 ifly6
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. */

package ifly6.UtilitiesPro3;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * This is the implementation of the API defined in apiDefinitions. It should be a single class file. Follow all the
 * necessary definitions in apiDefinitions for that each class.
 *
 * Implementation should work by creating a new apiImplementation based around a certain file. From there, it should use
 * that apiImplementation to do certain things. Note that the first implementation of a plugin system should run on a
 * load-a-single-class basis.
 *
 * @since 3.3_dev04
 */
public class apiImplementation extends ClassLoader {

	private File plugin_dir = new File(Utilities_Pro.UtilitiesPro_DIR + "/plugins/");
	Class<?> cls = null;

	private void out(String input) {
		Utilities_Pro.out(input);
	}

	private void log(String input, int type) {
		TextCommands.log(input, type);
	}

	private void error(Exception e) {
		log(e.toString(), 1);
	}

	/**
	 * This is the constructor. An apiImplementation is created for the plugin system to use.
	 *
	 * @param classPath
	 * @since 3.3_dev05
	 */
	apiImplementation(File classPath) {
		try {
			URL[] urls = { classPath.toURI().toURL() };

			String className = classPath.getAbsolutePath().substring(0, classPath.getAbsolutePath().length() - 6);
			className = className.replace('/', '.');
			URLClassLoader cl = new URLClassLoader(urls);
			cls = cl.loadClass(className);
			cl.close();
		} catch (MalformedURLException e) {
			out("Plugin Load failed.");
			log("URL creation error occurred. Report error.", 1);
		} catch (ClassNotFoundException e) {
			out("Plugin not found. Make sure you have specified the correct plugin.");
			log("Plugin not found.", 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void methods() {
		Method[] methList = cls.getMethods();
		out("Which method?");
		for (Method elements : methList) {
			out(" * " + elements.getName());
		}
	}

	public Object methodInvoke(String methodName, Object arguments) {
		try {
			Method m = cls.getMethod("getPluginName", (Class<?>[]) null);
			String name = (String) m.invoke((Object[]) null, (Object[]) null);
			return name;
		} catch (IllegalArgumentException e) {
			error(e);
		} catch (IllegalAccessException e) {
			error(e);
		} catch (InvocationTargetException e) {
			error(e);
		} catch (SecurityException e) {
			error(e);
		} catch (NoSuchMethodException e) {
			error(e);
		}
		return "Attempt to execute plugin failed.";
	}

	public String getPluginName() {
		try {
			Method m = cls.getMethod("getPluginName", (Class<?>[]) null);
			String name = (String) m.invoke((Object[]) null, (Object[]) null);

			return name;
		} catch (IllegalArgumentException e) {
			error(e);
		} catch (IllegalAccessException e) {
			error(e);
		} catch (InvocationTargetException e) {
			error(e);
		} catch (SecurityException e) {
			error(e);
		} catch (NoSuchMethodException e) {
			error(e);
		}
		return "Attempt to getPluginName failed.";
	}

	public void setInput(String input) {
		try {
			Method m = cls.getMethod("setInput", String.class);
			m.invoke(null, input);
		} catch (IllegalArgumentException e) {
			error(e);
		} catch (IllegalAccessException e) {
			error(e);
		} catch (InvocationTargetException e) {
			error(e);
		} catch (SecurityException e) {
			error(e);
		} catch (NoSuchMethodException e) {
			error(e);
		}
	}

	public String getOutput() {
		try {
			Method m = cls.getMethod("getOutput", (Class<?>[]) null);
			String output = (String) m.invoke((Object[]) null, (Object[]) null);
			return output;
		} catch (IllegalArgumentException e) {
			error(e);
		} catch (IllegalAccessException e) {
			error(e);
		} catch (InvocationTargetException e) {
			error(e);
		} catch (SecurityException e) {
			error(e);
		} catch (NoSuchMethodException e) {
			error(e);
		}
		return "Attempt to getOutput failed.";
	}

	public String getLog() {
		try {
			Method m = cls.getMethod("getLog", (Class<?>[]) null);
			String log = (String) m.invoke((Object[]) null, (Object[]) null);
			return log;
		} catch (IllegalArgumentException e) {
			error(e);
		} catch (IllegalAccessException e) {
			error(e);
		} catch (InvocationTargetException e) {
			error(e);
		} catch (SecurityException e) {
			error(e);
		} catch (NoSuchMethodException e) {
			error(e);
		}
		return "Attempt to getLog failed.";
	}

	public boolean hasError() {
		try {
			Method m = cls.getMethod("hasError", (Class<?>[]) null);
			boolean errorPresence = ((Boolean) m.invoke((Object[]) null, (Object[]) null)).booleanValue();
			return errorPresence;
		} catch (IllegalArgumentException e) {
			error(e);
		} catch (IllegalAccessException e) {
			error(e);
		} catch (InvocationTargetException e) {
			error(e);
		} catch (SecurityException e) {
			error(e);
		} catch (NoSuchMethodException e) {
			error(e);
		}
		return false;
	}

	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */

	/**
	 * Loads all classes inside the plugins folder. This unified plugin system is currently under development and is
	 * slated for completion in version 3.4.
	 *
	 * @since 3.3_dev05
	 */
	@SuppressWarnings("unused")
	public void pluginsLoader() {
		try {
			File[] fileList = plugin_dir.listFiles();
			URL[] urls = {};

			ArrayList<URL> urlList = new ArrayList<URL>();

			for (File file : fileList) {
				try {
					urlList.add(file.toURI().toURL());
				} catch (MalformedURLException e) {
					out("Error in Loading Plugins");
					log("Malformed URL Error. Report to GitHub", 1);
				}
			}

			urls = urlList.toArray(urls);
			ClassLoader cl = new URLClassLoader(urls);

			for (URL url : urls) {
				String className = url.toString().substring(0, url.toString().length() - 6);
				className = className.replace('/', '.');
				Class<?> cls = cl.loadClass(className);
			}

			((URLClassLoader) cl).close();

		} catch (ClassNotFoundException e) {
			log("The specified class was not found.", 1);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

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

import com.apple.eawt.ApplicationAdapter;
import com.apple.eawt.ApplicationEvent;

/**
 * Note: Please do not change anything with this class. It needs to stay Static. This class here is filled with
 * deprecated references, as the the methods of the Java implementation for OSX are gradually being faded out, to my
 * chagrin. Anyway, the application is given a handler for the ToolBar Menu under its name. We are going to handle the
 * About, Preferences, and Quit dialogues. Unfortunately, as the non-deprecated classes are not used by anyone
 * (apparently) and there is less documentation on them than on THIS project, it is generally useless. However, because
 * of our handling of the three buttons, they are to function. Anyway... the About dialogue should open a small dialogue
 * telling the world of the version and a short description. The preferences dialogue should open the preferences page
 * in UtilitiesPro_DIR. The quit system should immediately System.exit(0) the programme.
 *
 * @since 3.0_dev05
 * @see com.apple.eawt
 */

@SuppressWarnings("deprecation")
public class MacHandler extends ApplicationAdapter {

	/**
	 * Handles the Quit menu by System.exit(0).
	 *
	 * @since 3.0_dev05
	 * @param e
	 *            is not used
	 */
	@Override
	public void handleQuit(ApplicationEvent e) {
		TextCommands.quitHandler();
	}

	/**
	 * Handles the About argument by calling the helpCommands command, about.
	 *
	 * @since 3.0_dev05
	 * @param e
	 *            is not used
	 * @see ifly6.UtilitiesPro3.HelpCommands
	 */
	@Override
	public void handleAbout(ApplicationEvent e) {
		e.setHandled(true);
		HelpCommands.about();
	}

	/**
	 * Handles the Preferences argument by opening the configuration file.
	 *
	 * @since 3.0_dev05
	 * @param e
	 *            is not used
	 * @see ifly6.UtilitiesPro3.FileCommands
	 */
	@Override
	public void handlePreferences(ApplicationEvent e) {
		String[] input = { "open", Utilities_Pro.UtilitiesPro_DIR + "/config.txt" };
		ExecEngine.exec(input);
	}
}
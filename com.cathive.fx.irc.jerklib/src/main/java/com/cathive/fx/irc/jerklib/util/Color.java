package com.cathive.fx.irc.jerklib.util;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * To use:
 * channel.say(Colors.BLUE + "HELLLLO");
 * <br>
 * Will say hello in blue
 *
 * @author mohadib
 */
public final class Color
{


    /**
     * Removes all applied color and formatting
     */
    public static final String NORMAL = "\u000f";

    /**
     * Bold text.
     */
    public static final String BOLD = "\u0002";

    /**
     * Underlined text
     */
    public static final String UNDERLINE = "\u001f";

    /**
     * Reversed text
     */
    public static final String REVERSE = "\u0016";

    /**
     * White colored text.
     */
    public static final String WHITE = "\u000300";

    /**
     * Black colored text.
     */
    public static final String BLACK = "\u000301";

    /**
     * Dark blue colored text.
     */
    public static final String DARK_BLUE = "\u000302";

    /**
     * Dark green colored text.
     */
    public static final String DARK_GREEN = "\u000303";

    /**
     * Red colored text.
     */
    public static final String RED = "\u000304";

    /**
     * Brown colored text.
     */
    public static final String BROWN = "\u000305";

    /**
     * Purple colored text.
     */
    public static final String PURPLE = "\u000306";

    /**
     * Olive colored text.
     */
    public static final String OLIVE = "\u000307";

    /**
     * Yellow colored text.
     */
    public static final String YELLOW = "\u000308";

    /**
     * Green colored text.
     */
    public static final String GREEN = "\u000309";

    /**
     * Teal colored text.
     */
    public static final String TEAL = "\u000310";

    /**
     * Cyan colored text.
     */
    public static final String CYAN = "\u000311";

    /**
     * Blue colored text.
     */
    public static final String BLUE = "\u000312";

    /**
     * Magenta colored text.
     */
    public static final String MAGENTA = "\u000313";

    /**
     * Dark gray colored text.
     */
    public static final String DARK_GRAY = "\u000314";

    /**
     * Light gray colored text.
     */
    public static final String LIGHT_GRAY = "\u000315";


    private static final List<String> colorList = new ArrayList<String>();

    /*
     * Do not allow instantiation.
     */
    private Color() {
    }

    static
    {
        colorList.add(Color.BLACK);
        colorList.add(Color.BLUE);
        colorList.add(Color.BOLD);
        colorList.add(Color.BROWN);
        colorList.add(Color.CYAN);
        colorList.add(Color.DARK_BLUE);
        colorList.add(Color.DARK_GRAY);
        colorList.add(Color.DARK_GREEN);
        colorList.add(Color.GREEN);
        colorList.add(Color.LIGHT_GRAY);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.NORMAL);
        colorList.add(Color.OLIVE);
        colorList.add(Color.PURPLE);
        colorList.add(Color.RED);
        colorList.add(Color.TEAL);
        colorList.add(Color.UNDERLINE);
        colorList.add(Color.WHITE);
        colorList.add(Color.YELLOW);
    }

    /**
     * Returns the list of all available colors.
     *
     * @return a list of all colors available
     */
    public static List<String> getColorsList()
    {
        return Collections.unmodifiableList(colorList);
    }
}

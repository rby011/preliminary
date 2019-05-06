package com.samsung.tcm.core.loc;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class handles compiler directives. It keeps track of the compiler
 * directives and stores them in a list.
 *
 * @author Integrity Applications Incorporated
 */
public class CompilerDirectiveHandler {
    /**
     * Array list containing compiler directive characters
     */
    ArrayList<String> CompilerDirChars = null;

    /**
     * Array list containing compiler directive keywords
     */
    ArrayList<String> CompilerDirKeywords = null;

    /**
     * Array list containing compiler directive line continuations
     */
    ArrayList<String> LineContChars = null;

    /**
     * PSLOC count - compiler directives
     */
    int NumCompilerDirectives = 0;

    /**
     * Number of compiler continuations
     */
    int NumCompilerContinuations = 0;

    /**
     * To store compiler directives
     */
    String compilerDirectives = "";
    // State variable
    private boolean inCompilerDirective = false;

    /**
     * Default constructor to initializo Java quote handler
     *
     * @param languageProperties An object containing language properties
     */
    public CompilerDirectiveHandler(LanguageProperties languageProperties) {
        CompilerDirChars = languageProperties.GetCompilerDirChars();
        CompilerDirKeywords = languageProperties.GetCompilerDirKeywords();
        LineContChars = languageProperties.GetLineContChars();
    }

    /**
     * This method returns the total number of compiler directives counted at the moment this function is called.
     *
     * @return total number of compiler directives counted at the moment this function is called
     */
    public int GetNumCompilerDirectives() {
        return NumCompilerDirectives;
    }

    /**
     * This method returns the total number of compiler directive line continuations counted at the moment this
     * function is called.
     *
     * @return total number of compiler directive line continuations counted at the moment this function is called
     */
    public int GetNumCompilerContinuations() {
        return NumCompilerContinuations;
    }

    /**
     * This method returns the compiler directives found in list format.
     *
     * @return list of compiler directives as a String
     */
    public String GetCompilerDirectives() {
        return compilerDirectives;
    }

    /**
     * Default constructor to initializo Java quote handler
     */

    /**
     * This method handles saving a compiler directive that is
     * handled independently from the compiler directive handler.
     *
     * @param compilerDirective - (String)
     */
    public void AddCompilerDirective(String compilerDirective) {
        compilerDirectives += compilerDirective + "\n";
    }

    /**
     * Main function for handling compiler directives from incoming line
     *
     * @param line input
     * @return input line with compiler directives removed
     */
    public String HandleCompilerDirectives(String line) {
        // If we're in a compiler directive, check if it is continued
        if (inCompilerDirective == true) {
            line = IsCompilerDirectiveContinued(line);
        } else // Otherwise check if the line is a compiler directive
        {
            line = IsCompilerDirective(line);
        }

        return line;
    }

    /**
     * Function for checking whether the line in question is a compiler directive.
     *
     * @param line input
     * @return input line with compiler directives removed
     */
    protected String IsCompilerDirective(String line) {
        String regex = "";
        Matcher matcher;

        // If the language uses compiler characters, this will catch incorrect and correct uses (#define and # define)
        if (CompilerDirChars.size() > 0) {
            for (int cc = 0; cc < CompilerDirChars.size() && !line.trim().isEmpty(); cc++) {
                // The line must start with a compiler character
                if (line.trim().startsWith(CompilerDirChars.get(cc))) {
                    // Check if the compiler directive is continued
                    line = IsCompilerDirectiveContinued(line);
                }
            }
        } else // If the language does not use compiler characters, we only look for the keywords
        {
            for (int cd = 0; cd < CompilerDirKeywords.size() && !line.trim().isEmpty(); cd++) {
                regex = "\\b" + CompilerDirKeywords.get(cd) + "\\b.*";
                matcher = Pattern.compile(regex).matcher(line.trim());

                // This ensures that we find whole word only and that it starts at the beginning of the line
                if (matcher.find() && matcher.start() == 0) {
                    // Check if the compiler directive is continued
                    line = IsCompilerDirectiveContinued(line);
                }
            }
        }

        return line;
    }

    /**
     * Function for checking whether the line in question is a compiler directive and if it is a continued
     * compiler directive.
     *
     * @param line input
     * @return input line with compiler directives removed
     */
    protected String IsCompilerDirectiveContinued(String line) {
        // If the language has line continuation characters
        if (LineContChars.size() > 0) {
            for (int lcc = 0; lcc < LineContChars.size(); lcc++) {
                // If the line ends with a line continuation, we're in a continued compiler directive
                if (line.trim().endsWith(LineContChars.get(lcc))) {
                    inCompilerDirective = true;
                    NumCompilerContinuations++;
                } else // Otherwise, increment the number of compiler directives and move on
                {
                    inCompilerDirective = false;
                    NumCompilerDirectives++;
                }
            }
        } else {
            // If the language does not have line continuation characters,
            // increment the number of compiler directives and move on
            inCompilerDirective = false;
            NumCompilerDirectives++;
        }

        // Since we know that we're either have a single or continued compiler directive when this
        // function is called, we send it to this function for processing
        line = GatherCompilerDirectives(line);

        return line;
    }

    /**
     * Function for building a string containing all of the compiler directives with undone line continuations
     *
     * @param line input
     * @return input line with compiler directives removed
     */
    public String GatherCompilerDirectives(String line) {
        // if we're dealing with a continued compiler directive, undo the line continuation
        if (inCompilerDirective == true) {
            compilerDirectives += line.trim() + " ";
        } else // Otherwise, append the string with a line break
        {
            compilerDirectives += line.trim() + "\n";
        }

        // Wipe the line
        line = "";

        return line;
    }

    /**
     * This method resets the state of the comment handler, such that it can be
     * used more generally instead of needing to instantiate one per file.
     */
    public void ResetState() {
        // Reset State
        inCompilerDirective = false;
    }

    /**
     * This method resets the external data of the comment handler, such that it
     * can be used more generally instead of needing to instantiate one per file.
     */
    public void ResetExternalData() {
        // Reset External Data
        NumCompilerDirectives = 0;
        NumCompilerContinuations = 0;
        compilerDirectives = "";
    }

    /**
     * This method resets the state and data of the comment handler, such that it
     * can be used more generally instead of need to instantiate one per file.
     */
    public void Reset() {
        ResetState();
        ResetExternalData();
    }
}

package com.samsung.tcm.core.loc;

/**
 * DataTypes class provides data types that are used across the baseline
 *
 * @author Integrity Applications Incorporated
 */
public class DataTypes {
    private static int fileIndex = 0;

    /**
     * Enumerated type to identify programming language associated with a file
     */
    public enum LanguagePropertiesType {
        // Complete list
        /**
         * IIdentifier for source code file written in ADA programming language
         */
        ADA(fileIndex++),
        /**
         * IIdentifier for source code file written in ASP programming language
         */
        ASP(fileIndex++),
        /**
         * IIdentifier for source code file written in Assembly programming language
         */
        ASSEMBLY(fileIndex++),
        /**
         * IIdentifier for source code file written in Bash programming language
         */
        BASH(fileIndex++),
        /**
         * IIdentifier for source code file written in C or C++ programming languages
         */
        C_CPP(fileIndex++),
        /**
         * IIdentifier for source code file written in C# programming language
         */
        CSHARP(fileIndex++),
        /**
         * IIdentifier for source code file written in C Shell programming language
         */
        CSHELL(fileIndex++),
        /**
         * IIdentifier for source code file written in Coldfusion programming language
         */
        COLDFUSION(fileIndex++),
        /**
         * IIdentifier for source code file written in Coldfusion script programming language
         */
        COLDFUSION_SCRIPT(fileIndex++),
        /**
         * IIdentifier for source code file written in CSS programming language
         */
        CSS(fileIndex++),
        /**
         * IIdentifier for source code file written in DOS Batch programming language
         */
        DOS_BATCH(fileIndex++),
        /**
         * IIdentifier for source code file written in Fortran programming language
         */
        FORTRAN(fileIndex++),
        /**
         * IIdentifier for source code file written in HTML programming language
         */
        HTML(fileIndex++),
        /**
         * IIdentifier for source code file written in IDL programming language
         */
        IDL(fileIndex++),
        /**
         * IIdentifier for source code file written in Java programming language
         */
        JAVA(fileIndex++),
        /**
         * IIdentifier for source code file written in JavaScript programming language
         */
        JAVASCRIPT(fileIndex++),
        /**
         * IIdentifier for source code file written in JSP programming language
         */
        JSP(fileIndex++),
        /**
         * IIdentifier for source code file written in Makefile programming language
         */
        MAKEFILE(fileIndex++),
        /**
         * IIdentifier for source code file written in Matlab programming language
         */
        MATLAB(fileIndex++),
        /**
         * IIdentifier for source code file written in NeXtMidas macro language
         */
        NEXTMIDAS(fileIndex++),
        /**
         * IIdentifier for source code file written in Pascal programming language
         */
        PASCAL(fileIndex++),
        /**
         * IIdentifier for source code file written in Perl programming language
         */
        PERL(fileIndex++),
        /**
         * IIdentifier for source code file written in PHP programming language
         */
        PHP(fileIndex++),
        /**
         * IIdentifier for source code file written in Python programming language
         */
        PYTHON(fileIndex++),
        /**
         * IIdentifier for source code file written in Ruby programming language
         */
        RUBY(fileIndex++),
        /**
         * IIdentifier for source code file written in Scala programming language
         */
        SCALA(fileIndex++),
        /**
         * IIdentifier for source code file written in SQL programming language
         */
        SQL(fileIndex++),
        /**
         * IIdentifier for source code file written in VB programming language
         */
        VB(fileIndex++),
        /**
         * IIdentifier for source code file written in VB Script programming language
         */
        VB_SCRIPT(fileIndex++),
        /**
         * IIdentifier for source code file written in Verilog programming language
         */
        VERILOG(fileIndex++),
        /**
         * IIdentifier for source code file written in VHDL programming language
         */
        VHDL(fileIndex++),
        /**
         * IIdentifier for source code file written in Xmidas programming language
         */
        XMIDAS(fileIndex++),
        /**
         * IIdentifier for source code file written in XML programming language
         */
        XML(fileIndex++),
        /** IIdentifier for source code file written in XSSL programming language */
        // XSL(fileIndex++),
        /**
         * IIdentifier for source code file written in a custom programming language provided by the user
         */
        // NOTE: Keep the custom language as the last language in the list
        CUSTOM(fileIndex++);

        /**
         * Index associated with enumerated value
         */
        private int LangIdx;

        /**
         * Constructor
         *
         * @param idx Index for the ELanguage Properties element
         */
        private LanguagePropertiesType(int idx) {
            this.LangIdx = idx;
        }

        /**
         * Get index associated with the enum value
         *
         * @return Index of language type
         */
        public int GetIndex() {
            return this.LangIdx;
        }
    }

    /**
     * Enumerated type to identify input file types
     */
    public enum SourceFileType {
        /**
         * IIdentifier for source code file written in one of the programming languages
         */
        CODE,
        /**
         * IIdentifier for file containing data values
         */
        DATA,
        /**
         * IIdentifier for text file
         */
        TEXT
    }
}

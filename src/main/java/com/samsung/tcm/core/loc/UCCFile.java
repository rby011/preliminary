package com.samsung.tcm.core.loc;

import java.util.ArrayList;

/**
 * UCCFile class contains data structures to store results of code counter
 * operations. This result set is per input file that was run through the code
 * counter.
 *
 * @author Integrity Applications Incorporated
 */
public class UCCFile {
    /**
     * ADDED BY chsun.song
     **/
    public String orgLine;

    /**
     * ADDED BY chsun.song
     **/
    public String feededLine;

    /**
     * Input source file name
     */
    public String FileName;

    /**
     * Input source file type
     */
    public DataTypes.SourceFileType FileType;

    /**
     * Programming language of input source file
     */
    public DataTypes.LanguagePropertiesType LangProperty;

    /**
     * Version number for the programming language
     */
    public String LangVersion;

    /**
     * A flag to indicate whether the file is a duplicate file
     */
    public boolean IsDup;

    /**
     * Indicates percentage of duplicate code found in this file
     */
    public double DupCodePercent;

    /**
     * Checksum of the file, used in duplicate file check
     */
    public long FileChecksum;

    /**
     * Index of the file for which this file is a duplicate file
     */
    public int DupOfIdx;

    /**
     * A flag to indicate whether the file has been counted
     */
    public boolean IsCounted;

    /**
     * Number of total lines in a file
     */
    public int NumTotalLines;

    /**
     * Number of blank lines in a file
     */
    public int NumBlankLines;

    /**
     * Number of full comment lines in a file
     */
    public int NumWholeComments;

    /**
     * Number of embedded comment lines in a file
     */
    public int NumEmbeddedComments;

    /**
     * Number of compiler directives in a file
     */
    public int NumCompilerDirectives;

    /**
     * Number of physical data declaration lines in a file
     */
    public int NumDataDeclPhys;

    /**
     * Number of physical executable instruction lines in a file
     */
    public int NumExecInstrPhys;

    /**
     * Number of logical data declaration lines in a file
     */
    public int NumDataDeclLog;

    /**
     * Number of logical executable instruction lines in a file
     */
    public int NumExecInstrLog;

    /**
     * Number of physical source lines of code in a file
     */
    public int NumPSLOC;

    /**
     * Number of logical source lines of code in a file
     */
    public int NumLSLOC;

    /**
     * Index of the file in which this file is embedded
     */
    public int EmbOfIdx;

    /**
     * A flag to indicate whether the file has embedded code
     */
    public boolean HasEmbCode;

    /**
     * A flag to indicate whether the file has a unique file name
     */
    public boolean UniqueFileName;

    // Complexity keywords and counts pairs
    /**
     * Math keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CmplxMathCnts;

    /**
     * Trigonometric keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CmplxTrigCnts;

    /**
     * Logarithmic keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CmplxLogCnts;

    /**
     * Calculation keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CmplxCalcCnts;

    /**
     * Conditional keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CmplxCondCnts;

    /**
     * Loop keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CmplxLoopCnts;

    /**
     * Logical keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CmplxLogicCnts;

    /**
     * Pre-processor (compiler directives) keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CmplxPreprocCnts;

    /**
     * Assignment keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CmplxAssignCnts;

    /**
     * Pointer keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CmplxPntrCnts;

    /**
     * Data keywords and their respective counts
     */
    public ArrayList<CmplxDataType> DataKeywordCnts;

    /**
     * Executional keywords and their respective counts
     */
    public ArrayList<CmplxDataType> ExecKeywordCnts;

    /**
     * Keyword of array list element indicates loop level, count indicates count
     * for that level
     */
    public ArrayList<CmplxDataType> CmplxLoopLvlCnts;

    /**
     * Cyclomatic complexity keywords and their respective counts
     */
    public ArrayList<CmplxDataType> CyclCmplxCnts;

    /**
     * Total CC1 cyclomatic complexity of a file
     */
    public int CyclCmplxTotal;

    /**
     * Average CC1 cyclomatic complexity of a file
     */
    public double CyclCmplxAvg;

    /**
     * An array of checksum of file chunks
     */
    public ArrayList<Integer> FileLineChecksum;

    /**
     * Constructs a UCCFile object with default values
     */
    public UCCFile() {
        // Initialize class variables with default values
        FileName = "";
        FileType = DataTypes.SourceFileType.CODE;
        LangVersion = "";
        FileChecksum = 0;
        IsDup = false;
        DupCodePercent = 0.0;
        IsCounted = false;
        NumTotalLines = 0;
        NumBlankLines = 0;
        NumWholeComments = 0;
        NumEmbeddedComments = 0;
        NumDataDeclPhys = 0;
        NumExecInstrPhys = 0;
        NumDataDeclLog = 0;
        NumExecInstrLog = 0;
        NumPSLOC = 0;
        NumLSLOC = 0;

        EmbOfIdx = -1;
        HasEmbCode = false;
        UniqueFileName = true;

        CmplxMathCnts = new ArrayList<CmplxDataType>();
        CmplxTrigCnts = new ArrayList<CmplxDataType>();
        CmplxLogCnts = new ArrayList<CmplxDataType>();
        CmplxCalcCnts = new ArrayList<CmplxDataType>();
        CmplxCondCnts = new ArrayList<CmplxDataType>();
        CmplxLoopCnts = new ArrayList<CmplxDataType>();
        CmplxLogicCnts = new ArrayList<CmplxDataType>();
        CmplxPreprocCnts = new ArrayList<CmplxDataType>();
        CmplxAssignCnts = new ArrayList<CmplxDataType>();
        CmplxPntrCnts = new ArrayList<CmplxDataType>();
        CmplxLoopLvlCnts = new ArrayList<CmplxDataType>();
        CyclCmplxCnts = new ArrayList<CmplxDataType>();

        CyclCmplxTotal = 0;
        CyclCmplxAvg = 0;

        DataKeywordCnts = new ArrayList<CmplxDataType>();
        ExecKeywordCnts = new ArrayList<CmplxDataType>();

        FileLineChecksum = new ArrayList<Integer>();
    }
}

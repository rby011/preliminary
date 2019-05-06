package com.samsung.tcm.analysis.common;

public interface CommonToken {
    String NAMESPACE_TOKEN = "namespace";
    String UNKNOWN_TOKEN = "unkonw";

    String BRACKET_OPEN = "{", BRACKET_CLOSE = "}";
    String PARENTHIS_OPEN = "(", PARENTHIS_CLOSE = ")";

    String NAMESPACE_BEFORE_DELIMITER = ":;";
    String CLASS_BEFORE_DELIMITER = ":";
    String FUNCTION_BEFORE_DELIMITER = ".";
    String PARAMETER_COUNT_BEFORE_DELIMITER = "|";
}

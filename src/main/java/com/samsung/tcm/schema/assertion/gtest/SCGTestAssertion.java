package com.samsung.tcm.schema.assertion.gtest;

import com.samsung.tcm.exceptions.ResourceNotFoundException;
import com.samsung.tcm.schema.assertion.SCAssertion;

import java.io.*;
import java.util.HashSet;

public class SCGTestAssertion extends SCAssertion {
    private static HashSet<String> assertExprTable = null;

    public SCGTestAssertion() throws IOException, ResourceNotFoundException{
        super("1.8.1", false);
        if(assertExprTable == null){
            assertExprTable = new HashSet<>();
            this.loadExpressions();
        }
    }

    @Override
    public boolean contains(String member, boolean isStaticImport) {
        return false;
    }

    @Override
    public boolean contains(String base) {
        return assertExprTable.contains(base);
    }

    @Override
    public boolean contains(String base, String member) {
        return false;
    }

    @Override
    protected void loadExpressions() throws IOException, ResourceNotFoundException {
        Class thisClass = this.getClass();

        String rsrc = "assert" + File.separator + "assertion" + File.separator + "gtest";//TODO : THIS MUST BE IN APPLICATION.PROPERTIES FILE
        String bFileName = "base";
        String comment1 = "//", comment2 = "#";

        InputStream rbStream = thisClass.getClassLoader().getResourceAsStream(rsrc + File.separator + bFileName);

        if (rbStream == null)
            throw new ResourceNotFoundException("NUnit assertion identifier resource files are not found");

        BufferedReader bBr = new BufferedReader(new InputStreamReader(rbStream));
        String base = null;
        while ((base = bBr.readLine()) != null) {
            if ((base = base.trim()).isEmpty()) continue;
            if (base.startsWith("//") || base.startsWith("#")) continue;
            assertExprTable.add(base);
        }
        bBr.close();
    }
}

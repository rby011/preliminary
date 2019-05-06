package com.samsung.tcm.schema.assertion.nunit;

import com.samsung.tcm.schema.assertion.SCAssertion;
import com.samsung.tcm.exceptions.ResourceNotFoundException;

import java.io.*;
import java.util.*;

public class SCNUnitAssertion extends SCAssertion {
    private static Hashtable<String, HashSet<String>> assertExprTable;

    public SCNUnitAssertion() throws IOException, ResourceNotFoundException {
        super("3.0", true);
        if (assertExprTable == null) {
            assertExprTable = new Hashtable<>();
            this.loadExpressions();
        }
    }

    @Override
    public boolean contains(String member, boolean isStaticImport) {
        Collection<HashSet<String>> memberSets = assertExprTable.values();
        for (HashSet<String> memberSet : memberSets) {
            if (memberSet.contains(member))
                return true;
        }
        return false;
    }

    @Override
    public boolean contains(String base) {
        return assertExprTable.get(base) != null;
    }

    @Override
    public boolean contains(String base, String member) {
        HashSet<String> mSet = assertExprTable.get(base);
        if (mSet == null) return false;
        return mSet.contains(member);
    }

    @Override
    protected void loadExpressions() throws IOException, ResourceNotFoundException {
        Class thisClass = this.getClass();

        String rsrc = "assert" + File.separator + "assertion" + File.separator + "nunit";//TODO : THIS MUST BE IN APPLICATION.PROPERTIES FILE
        String bFileName = "base", mFileExt = "member";
        String comment1 = "//", comment2 = "#";

        InputStream rbStream = thisClass.getClassLoader().getResourceAsStream(rsrc + File.separator + bFileName);

        if (rbStream == null)
            throw new ResourceNotFoundException("NUnit assertion identifier resource files are not found");

        BufferedReader bBr = new BufferedReader(new InputStreamReader(rbStream));
        String base = null;
        while ((base = bBr.readLine()) != null) {
            if ((base = base.trim()).isEmpty()) continue;
            if (base.startsWith("//") || base.startsWith("#")) continue;

            String member = null;
            HashSet<String> memSet = new HashSet<>();

            String mFileName = base.toLowerCase() + "." + mFileExt;
            InputStream rmStream = thisClass.getClassLoader().getResourceAsStream(rsrc + File.separator + mFileName);

            if (rmStream == null)
                throw new ResourceNotFoundException("NUnit assertion identifier resource files are not found");

            BufferedReader mBr = new BufferedReader(new InputStreamReader(rmStream));

            while ((member = mBr.readLine()) != null) {
                if ((member = member.trim()).isEmpty()) continue;
                if (member.startsWith(comment1) || member.startsWith(comment2)) continue;
                memSet.add(member);
            }
            mBr.close();
            assertExprTable.put(base, memSet);
        }
        bBr.close();
    }
}

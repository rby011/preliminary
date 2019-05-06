package com.samsung.tcm.analysis.csharp;

import com.samsung.tcm.analysis.common.TestCaseUnitAnalysis;
import com.samsung.tcm.schema.ETestCaseIdentifyMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

class CSharpTestCaseUnitAnalysis_Test {

    @Test
    public void hashtableKeyTest() {
        TestCaseUnitAnalysis element0 = new TestCaseUnitAnalysis("1", "idString0", ETestCaseIdentifyMethod.EXACT, null);
        TestCaseUnitAnalysis element1 = new TestCaseUnitAnalysis("2", "idString1", ETestCaseIdentifyMethod.EXACT, null);
        TestCaseUnitAnalysis element2 = new TestCaseUnitAnalysis("3", "idString2", ETestCaseIdentifyMethod.EXACT, null);
        TestCaseUnitAnalysis element3 = new TestCaseUnitAnalysis("4", "idString3", ETestCaseIdentifyMethod.EXACT, null);
        TestCaseUnitAnalysis element4 = new TestCaseUnitAnalysis("5", "idString4", ETestCaseIdentifyMethod.EXACT, null);

        HashMap<TestCaseUnitAnalysis, String> hashMap = new HashMap<>();

        hashMap.put(element0, "GOOD");
        hashMap.put(element1, "GOOD");
        hashMap.put(element2, "GOOD");
        hashMap.put(element3, "GOOD");

        Assertions.assertTrue(hashMap.containsKey(element0));
        Assertions.assertTrue(hashMap.containsKey(element1));
        Assertions.assertTrue(hashMap.containsKey(element2));
        Assertions.assertTrue(hashMap.containsKey(element3));
        Assertions.assertFalse(hashMap.containsKey(element4));

        Set<TestCaseUnitAnalysis> keys = hashMap.keySet();
        TestCaseUnitAnalysis mkey;
        for (TestCaseUnitAnalysis key : keys) {
            mkey = new TestCaseUnitAnalysis(key.getID(), key.getIdString(), key.getIdMethod(),null);
            Assertions.assertNotNull(hashMap.get(mkey));
        }
    }
}
package com.samsung.tcm.schema.assertion.nunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NUnitAssertion_Test {

    @Test
    void loadProperty_BaseLoadTest() {
        Assertions.assertDoesNotThrow(()-> {
            SCNUnitAssertion assertion = new SCNUnitAssertion();
            Assertions.assertTrue(assertion.contains("Assert"));
        });
    }

    @Test
    void loadProperty_MemberLoadTest() {
        Assertions.assertDoesNotThrow(()-> {
            SCNUnitAssertion assertion = new SCNUnitAssertion();
            Assertions.assertTrue(assertion.contains("Assert","That"));
        });
    }
}
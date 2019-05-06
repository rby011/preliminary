package com.samsung.tcm.context;

import com.samsung.tcm.core.loc.CodeCounter;
import com.samsung.tcm.exceptions.ResourceNotFoundException;
import com.samsung.tcm.schema.ELanguage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TlmContextTest {

    @Test
    void locCounterTest(){
        TcmContext instance = null;
        try {
            instance = TcmContext.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
            Assertions.fail("Error during making tcm context");
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            Assertions.fail("Error during making tcm context");
        }

        CodeCounter locCounter = instance.getLocContext(ELanguage.CSHARP);
        Assertions.assertNotNull(locCounter);
    }
}
package com.samsung.tcm.context;

import com.samsung.tcm.core.loc.*;
import com.samsung.tcm.exceptions.ResourceNotFoundException;
import com.samsung.tcm.schema.*;
import com.samsung.tcm.schema.assertion.SCAssertion;
import com.samsung.tcm.schema.assertion.chai.SCChaiAssertion;
import com.samsung.tcm.schema.assertion.gtest.SCGTestAssertion;
import com.samsung.tcm.schema.assertion.nunit.SCNUnitAssertion;
import com.samsung.tcm.schema.assertion.tizen_tct.SCTizenTCTNativeAssertion;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;

public class TcmContext {
    private Hashtable<String, SCProject> projectContext = new Hashtable<>();

    private Hashtable<ITestFramework, SCAssertion> assertionContext = new Hashtable<>();
    private Hashtable<ILanguage, CodeCounter> locCounterContext = new Hashtable<>();

    private static TcmContext context = null;

    private TcmContext() {
    }

    public static TcmContext getInstance() throws IOException, ResourceNotFoundException {
        if (context == null) {
            context = new TcmContext();

            //PRE-DEFINED ASSERTION EXPRESSIONS
            context.addAssertionContext(ETestFramework.NUNIT);
            context.addAssertionContext(ECustomTestFramework.TIZEN_TCT_NATIVE);
            context.addAssertionContext(ETestFramework.GTEST);
            context.addAssertionContext(ETestFramework.CHAI);

            //PRE-DEFINED LOC COUNTERS
            context.addLocContext(ELanguage.CSHARP);
            context.addLocContext(ELanguage.C);
            context.addLocContext(ELanguage.CPLUS);
            context.addLocContext(ELanguage.JAVASCRIPT);
        }
        return context;
    }

    public void addAssertionContext(ITestFramework testFramework) throws IOException, ResourceNotFoundException {
        SCAssertion assertion = null;
        if (testFramework == ETestFramework.NUNIT) {
            assertion = new SCNUnitAssertion();
        } else if (testFramework == ETestFramework.JUNIT) {
            // TODO Assertion 스키마 있으면 집어 넣고
        } else if (testFramework == ETestFramework.GTEST) {
            assertion = new SCGTestAssertion();
        } else if (testFramework == ECustomTestFramework.TIZEN_TCT_NATIVE) {
            assertion = new SCTizenTCTNativeAssertion();
        } else if (testFramework == ETestFramework.CHAI) {
            assertion = new SCChaiAssertion();
        }

        if (assertion == null)
            throw new ResourceNotFoundException("Wrong at generating an assertion schema");

        this.assertionContext.put(testFramework, assertion);
    }

    public SCAssertion getAssertionContext(ITestFramework testFramework) {
        return assertionContext.get(testFramework);
    }

    public void addLocContext(ILanguage language) {
        CodeCounter counter = null;
        if (language == ELanguage.CSHARP) {
            counter = new CSharpCounter(new CSharpLanguageProperties());
        } else if (language == ELanguage.C | language == ELanguage.CPLUS) {
            counter = new CCPPCounter(new CCPPLanguageProperties());
        } else if (language == ELanguage.JAVASCRIPT) {
            counter = new JavaScriptCounter(new JavaScriptLanguageProperties());
        } else if (language == ELanguage.JAVA) {
            counter = new JavaCounter(new JavaLanguageProperties());
        } else if (language == ELanguage.PYTHON) {
            counter = new PythonCounter(new PythonLanguageProperties());
        } else if (language == ELanguage.XML) {
            counter = new XMLCounter(new XMLLanguageProperties());
        }
        this.locCounterContext.put(language, counter);
    }

    public CodeCounter getLocContext(ILanguage language) {
        return locCounterContext.get(language);
    }

    public void addProjectContext(String name, SCProject project) {
        projectContext.put(name, project);
    }

    public SCProject getProjectContext(String name) {
        return projectContext.get(name);
    }

    public Set<String> getProjectNames() {
        return projectContext.keySet();
    }
}

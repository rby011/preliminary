function describe(suiteName, suiteFunction){}
function it(testCaseName, testFunction){}

log();

describe("A",
    function(){
        call("asdf");
        it("a", function(){console.log("test case function 1");});
        describe("B", function(){
            it("b", function(){
                assert();
                Expect();
                console.log("test case function c");
            });
            describe("C", function(){
                it("c", function(){
                    Should.to();
                    Expect.to();
                    assert.fail();
                    console.log("test case function d");
                });
                it("d", function(){
                    console.log("test case function d");
                });
            });
            it("e", function(){
                console.log('test case function #2');
            });
        });
        it("f", function(){
            console.log("test case function a");
        });
        it("g", function(){
            console.log("test case function a");
        });
});
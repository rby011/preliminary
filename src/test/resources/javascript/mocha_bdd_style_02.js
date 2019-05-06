describe("A", function() {
  var car = null;
  // assert.equal(test1(), test2()()); // count only for A
  assert.equal();

  desc("QQQ",function(){
    it("Q_n",function(){});
  }());

  //This test will succeed
  it("a_n", function() {
     console.log(car);
  });
  assert.equal(function(){}(), test1()); // count only for A
  //This test will fail- the go function is called twice
  it("b_p", function() {
     expect(car.go).toHaveBeenCalledTimes(1); // count only for b
  });
  assert.equal(1, test1()); // count only for A
  describe("B", function(){
      it("d_n", function(){
           it("e_p", function(){});
           call(a, function(){});
           assert.equal("T", test2().test3()); // count only for d
      });
      assert.equal(); // count only for B
  });
  it("e_n", function(){
    assert.equal(); // count only for e
  });
});
it("f", function(){
  console.log();
  assert.equal(test1(), test2());
});
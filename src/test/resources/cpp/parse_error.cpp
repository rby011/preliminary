//std::vector<Matcher<int>> matchers{Ge(1), Lt(2)};

/*FIXED*/ EXPECT_NONFATAL_FAILURE({ AtLeast(-1); }, "The invocation lower bound must be >= 0");

TEST(AllOfArrayTest, Matchers) {
  // vector
  // std::vector<Matcher<int>> matchers{Ge(1), Lt(2)};
  EXPECT_THAT(0, Not(AllOfArray(matchers)));
  EXPECT_THAT(1, AllOfArray(matchers));
  EXPECT_THAT(2, Not(AllOfArray(matchers)));
  // initializer_list
  EXPECT_THAT(0, Not(AllOfArray({Ge(0), Ge(1)})));
  EXPECT_THAT(1, AllOfArray({Ge(0), Ge(1)}));
}
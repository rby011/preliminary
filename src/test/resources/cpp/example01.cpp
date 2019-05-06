#include "gmock/gmock-generated-matchers.h"

// Returns the description of the given matcher.
template <typename T>
std::string Describe(const Matcher<T>& m) {
  stringstream ss;
  m.DescribeTo(&ss);
  return ss.str();
}

// Returns the description of the negation of the given matcher.
template <typename T>
std::string DescribeNegation(const Matcher<T>& m) {
  stringstream ss;
  m.DescribeNegationTo(&ss);
  return ss.str();
}

// Returns the reason why x matches, or doesn't match, m.
template <typename MatcherType, typename Value>
std::string Explain(const MatcherType& m, const Value& x) {
  stringstream ss;
  m.ExplainMatchResultTo(x, &ss);
  return ss.str();
}

// For testing ExplainMatchResultTo().
class GreaterThanMatcher : public MatcherInterface<int> {
 public:
  explicit GreaterThanMatcher(int rhs) : rhs_(rhs) {}

  void DescribeTo(::std::ostream* os) const override {
    *os << "is greater than " << rhs_;
  }

  bool MatchAndExplain(int lhs, MatchResultListener* listener) const override {
    const int diff = lhs - rhs_;
    if (diff > 0) {
      *listener << "which is " << diff << " more than " << rhs_;
    } else if (diff == 0) {
      *listener << "which is the same as " << rhs_;
    } else {
      *listener << "which is " << -diff << " less than " << rhs_;
    }

    return lhs > rhs_;
  }

 private:
  int rhs_;
};

Matcher<int> GreaterThan(int n) {
  return MakeMatcher(new GreaterThanMatcher(n));
}

// Tests for ElementsAre().
TEST(ElementsAreTest, CanDescribeExpectingNoElement_P) {
  Matcher<const vector<int>&> m = ElementsAre();
  EXPECT_EQ("is empty", Describe(m));
}

TEST(ElementsAreTest, CanDescribeExpectingOneElement_N) {
  Matcher<vector<int> > m = ElementsAre(Gt(5));
  EXPECT_EQ("has 1 element that is > 5", Describe(m));
}

TEST(ElementsAreTest, CanDescribeExpectingManyElements_P) {
  Matcher<list<std::string> > m = ElementsAre(StrEq("one"), "two");
  EXPECT_EQ("has 2 elements where\n"
            "element #0 is equal to \"one\",\n"
            "element #1 is equal to \"two\"", Describe(m));
}

TEST(ElementsAreTest, CanDescribeNegationOfExpectingNoElement_P) {
  Matcher<vector<int> > m = ElementsAre();
  EXPECT_EQ("isn't empty", DescribeNegation(m));
}

TEST(ElementsAreTest, CanDescribeNegationOfExpectingOneElment_N) {
  Matcher<const list<int>& > m = ElementsAre(Gt(5));
  EXPECT_EQ("doesn't have 1 element, or\n"
            "element #0 isn't > 5", DescribeNegation(m));
}

TEST(ElementsAreTest, CanDescribeNegationOfExpectingManyElements_N) {
  Matcher<const list<std::string>&> m = ElementsAre("one", "two");
  EXPECT_EQ("doesn't have 2 elements, or\n"
            "element #0 isn't equal to \"one\", or\n"
            "element #1 isn't equal to \"two\"", DescribeNegation(m));
}

TEST(ElementsAreTest, DoesNotExplainTrivialMatch_P) {
  Matcher<const list<int>& > m = ElementsAre(1, Ne(2));

  list<int> test_list;
  test_list.push_back(1);
  test_list.push_back(3);
  EXPECT_EQ("", Explain(m, test_list));  // No need to explain anything.
}
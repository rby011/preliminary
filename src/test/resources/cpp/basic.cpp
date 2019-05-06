// + TESTSUITE NAME : ElementAreTest,
// + TYPE : NEGATIVE
// + ASSERTION : 1
// + FUNCTION CALL : 5
//   - ""|0
//   - test|2
//   - b|2
//   - d|2
//   - EXPECT_TRUE|0
TEST(ElementsAreTest, CanDescribeExpectingOneElement_N) {
    Point *retPoint = (Point*)(test(a->b(c, (Point)d()), e)());
    EXPECT_TRUE(retPoint != 0);
}

// + TESTSUITE NAME : ElementAreTest
// + TYPE : POSITIVE
// + ASSERTION : 1
// + FUNCTION CALL : 6
//   - EXPECT_FALSE|1
//   - getX|0
//   - getY|0
//   - ASSERT_TRUE|1
//   - ElementAre|2
//   - Gt|2
TEST_P(ElementsAreTest, CanDescribeExpectingOneElement_P) {
    Point *point = new Point(1,2);
    EXPECT_FALSE(point == 0);
    int x = getX(), y = getY();
    ASSERT_TRUE(point->ElementAre(Gt(1,x), y));
}
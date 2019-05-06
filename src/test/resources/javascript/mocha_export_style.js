// Mocha support Espresso Style test pattern

module.exports = {
  before: function() {
    // excuted before test suite
  },
  after: function() {
    // excuted after test suite
  },
  beforeEach: function() {
    // excuted before every test
  },
  afterEach: function() {
    // excuted after every test
  },

  'exports style': {
    '#example': {
      'this is a test': function() {
        // write test logic
      }
    }
  }
};

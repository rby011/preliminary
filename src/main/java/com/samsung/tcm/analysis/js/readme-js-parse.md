# Basic JavaScript Semantics

## Function Call : One type of 'Argument Expression'

~~~
            object.describe('Example', function() {
              describe('calculation', function() {
                it('1+1 should be 2', function(done) {
                  fs.readFile('example.txt', function(err, data) {
                    done();
                  });
                });
              });
            });
~~~
![function_call_with_member_access](function_call_with_member_access.png)

![function_call](function_call.png)

## Function Expression

## Function Declaration
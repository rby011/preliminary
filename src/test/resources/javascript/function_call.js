/*
# 함수 호출과 객체 생성의 구분
1) 함수 호출은 ArgumentExpression 으로 정의됨
   | singleExpression arguments         # ArgumentsExpression
2) 객체 생성은 NewExpression 으로 정의됨
   | New singleExpression arguments?    # NewExpression
3) 두 표현식 모두 arguments 가 포함되어 정의되고, arguments 를 갖는 javascript 표현식은 이 두 개만이 존재함
4) 따라서 함수 호출 표현식만을 추출하기 위해서는 이 두개 표현식에 대한 구분 방법이 필요함
*/

function call(make, model){
    console.log(make);
    console.log(model);
}

function Instance(make, model, year) {
  this.make = make;
  this.model = model;
  this.year = year;
}

//
var instance = new Instance('New', 'Expression', 1993);

// function call
call('Function', 'Call');


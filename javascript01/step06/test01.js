/* 주제:Object() - 기본 사용법
- 객체를 초기화시킬 때 사용하는 기본 함수
*/

//1) 함수로 사용해보자!
//  - 객체를 사용하는 데 필요한 최소한의 프로퍼티를 등록하기
var obj1 = {} //명령의 단축코드 new Object()
// - 다음은 위의 명령문과 같다
var obj2 = new Object() //함수 객체

console.log(obj1)  //API 문서를 보라!
console.log(obj2)

var obj2 = {
  name: '홍길동',
  age: 20,
}

//프로토타입함수를
//인스턴스 메소드라고 한다.
//인스턴스 메소드는 객체를 생성자로 초기화 해서 생성했을 경우에만 사용가능하다


/* Object() 함수 객체에는
일반 함수에 인스턴스 함수들이 보관되어 있다.

인스턴스 함수를 사용해보자 */


//인스턴스 함수를 사용해보자
console.log(obj2.hasOwnProperty('age'))
console.log(obj2.hasOwnProperty('name'))
console.log(obj2.hasOwnProperty('tel'))

// 2) 인스턴스 함수(객체에 직접 저장되거나 생성자의 property에 저장된 함수) 사용
//객체에 프로퍼티에 age,name,tel 있냐 물어보는 함수, 있다면 true 없다면 false

// 3) 함수 객체에 보관된 일반 함수 사용해보자

console.log('------------------------------')
var obj3 = Object.create(null) //완전 빈 객체 생성하는 함수
console.log(obj3)

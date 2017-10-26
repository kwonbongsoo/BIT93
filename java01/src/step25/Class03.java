/* 애노테이션 사용하기 : 속성 값 설정하기
 */
package step25;

@Annotation05(
    v1 = { "aaa", "bbb", "ccc" }, 
    v2 = { "xxx" },
    v3 = 1 ,
    v4 = { 100, 200, 300 },
    v5 = { 1000 },
    v6 = 111 /* 배열의 값을 한 개만 지정할 때는 중괄호를 생략해도 된다. */
    )
public class Class03 {

}

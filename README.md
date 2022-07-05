# Error 해결

<h4> 1. build.gradle 오류 </h4>  

- Gradle 7 버전에서는 compile, testComplie 대신 implementataion, testImplementation을 사용한다.

<h4> 2. JavaScripts 인식 오류 </h4>

- Spingboot는 기본적으로 src/main/resources/static에 위치한 JavaScripts, CSS, Img 등 정적 파일일들은 URL에서 절대경로(/)로 설정된다고 한다. 그래서 다음과 같이 파일이 위치하면 위치에 맞게 호출이 가능하다고 한다. <br>

<div align=center>
src/main/resources/static/js/...(http://도메인/js/...) <br>
src/main/resources/static/css/...(http://도메인/css/...) <br>
src/main/resources/static/image/...(http://도메인/image/...)
</div>
 <br>
- spring.io를 이용하지 않고, 책처럼 직접 의존성을 추가했어서 resource에 static폴더를 직접 추가했었어야 했다. 계속해서 "failed to load resource: the server responded with a status of 404"라는 오류가 떠서 직접 static 폴더를 추가한 게 문제인가 했었는데 static에 css라는 폴더를 만들었더니, js의 폴더를 드디어 인식을 해서 해결했다.

<h4> 3. IndexController에서 postsService.findById 오류 </h4>

- PostRepository에 findById가 라이브러리로 이미 존재한다. spring web 계층을 보면 controller에서 바로 repository에 접근하면 안된다. 따라서 service에 findById/findAllDesc와 같은 메소드를 만들어 controller와 연결시키고, 해당 메소드에서 예외처리와 함께 repository에 접근해 dto에 값을 담아 controller에 다시 값을 보내주는 형식으로 로직이 이루어져야 한다. 

# RestApi

:웹의 장점을 최대한 활용할 수 있는 네트워크 기반의 아키텍처로 자원을 URI로 표현하고, 자원에 대한 행위를 HTTP Method(GET, POST, PUT, DELETE)로 표현한다.

- Post : Create 
- Get : Read
- Put : Update 
- Delete

# JPA

<h4> JPA 사용법 </h4>  

1. Entity Class 생성 : Posts class 생성 
2. JpaRepositoty : Posts 클래스로 Database를 접근하게 해줌 (DB Layer 접근자) 

# API 만들기

<h4> 1. API를 만들기 위해 필요한 3가지 클래스 </h4>

- Dto(Data Transfer Object) : Request 데이터를 받는 역할 
- Controller : API 요청을 받는 역할
- Service :트랜잭션, 도메인 기능 간의 순서를 보장해주는 역할

<h4> 2. Spring web 계층 </h4>

1) Web Layer 
- 흔히 사용하는 컨트롤러(@Controller)와 JSP/Freemarker 등의 뷰 템플릿 영역임
- 이외에도 필터(@Filter), 인터셉터, 컨트롤러 어드바이스(@ControllerAdvice) 등 외부 요청과 응답에 대한 전반적인 영역을 이야기함

2) Service Layer
- @Servic에 사용되는 서비스 영역
- Controller와 Dao(Data Access Object)의 중간 영역
- @Transaction이 사용되어야 하는 영역

3) Repository Layer
- Database와 같이 데이터 저장소에 접근하는 영역
- 기존의 Dao(Data Access Object)영역

4) Dtos
- Dto(Data Transfer Object) : 계층 간에 데이터 교환을 위한 객체
- Dtos : Dto 영역
- 예를 들어 뷰 템플릿 엔진에서 사용될 객체나 Repository Layer에서 결과로 넘겨준 객체 등을 말한다.

5) Domain Model 
- 도메인이라고 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있고, 공유할 수 있도록 단순화 시킨 것을 말함
- 택시 앱을 예로 들면, 배차/탑승/요금 등이 모두 도메인이 될 수 있음
- @Entity가 사용된 영역 (다만, 무조건 데이터베이스의 테이블과 관계가 있어야 하는 것은 아님)
- 여기서 비지니스 처리를 담당

# 소셜 로그인

https://minee.tistory.com/12


# Servlet & JSP Project

SLiPP - Servlet/JSP 사용자 관리 시스템 구현 프로젝트를 통해 학습한 내용 상세 정리

## 01. 개발 환경 세팅 및 Servlet 기본

* Embedded Tomcat 버전 설치 및 설정
* Servlet으로 Hello World 출력
* eclipse relaunch 플러그인 설치
* Client to Server, Sercer to Client로 데이터 전달
* Servlet Container와 Servlet의 관계

## 02. 회원가입 페이지 분석 및 JSP

* 회원가입 페이지 요구사항 분석
* JSP include구문 활용 중복 제거, HTTP GET/POST
* 데이터 저장을 위한 DB 객체 생성, VO생성
* sendRedirect를 활용한 페이지 이동

## 03. 회원가입 기능 구현 및 JSP2

* 단위 테스트 기반 개발
  * test source folder추가
  * DB와 VO 객체에 대한 단위 테스트
  * 로그인 기능 단위 테스트
* session을 활용한 로그인 기능 구현
* 예외 처리 및 forward
  * jsp에 예외 처리하는 흐름 이해
  * RequestDispatcher.forward()를 활용한 jsp 이동
* JSP 문제점 및 MVC 기본
  * JSP만으로 구현했을 경우 이슈(java import 구문 증가, java 코드와 html 코드가 섞이면서 가독성 떨어짐 등)
  * 이 문제를 해결해기 위한 역할 분리로 MVC 등장
  * JSP와 Servlet을 병행해서 구현
* redirect와 forward의 차이
* JSTL과 EL(Expression Language)
  * jstl을 활용해서 if/else 구현
  * EL태그를 활용해 스크립틀릿 코드 제거

## 04. 데이터베이스 연동

* JDBC 설치 및 학습
  * DB와 테이블 생성
  * JDBC 드라이버 설치
  * 사용자 데이터 추가(insert)
  * JUnit 단위 테스트를 통한 JDBC 학습
* DB에서 데이터 조회
  * 데이터 조회 기능 추가
  * DB를 사용 하던 코드가 UserDao를 사용하도록 구현
* DB 테스트
  * JUnit 단위 테스트 코드 작성

## 05. 회원가입 기능 구현 지속 및 코드 리팩토링

* 개인 정보 수정 폼 개발
  * JSP에서 자바 빈 데이터를 가져올 때의 규칙 이해
  * 소스 코드를 통해 MVC 각각의 역할 이해 -> MVC 패턴 이해
  * JSP에서 자바 코드(스크립틀릿)를 사용하지 않도록 구현하는 방법
  * hidden input type 사용
  * 자바빈 규약에 따라 자바 객체에서 데이터 추출
* 개인정보 수정을 위한 DAO 개발
* JDBC 리소스 반환
  * Connection, PreparedStatement, ResultSet 자원을 사용한 후 반환(close() 메소드)
* 회원가입 화면과 개인정보 수정 화면의 중복 제거
  * JSP 코드의 중복 제거
  * 회원 가입을 위한 Servlet 추가
  * form.jsp와 update_form.jsp 중복 제거를 통해 하나의 파일로 변경
  * c:set 태그 사용
* 개인정보 수정에 대한 보안 처리
  * 서버측 프로그래밍은 보안적으로 문제가 발생할 경우 관리하고 있는 모든 데이터에 접근할 수 있다. 개발하면서 보안적인 문제가 없는지 고려해야 한다.
  * UpdateUserServlet에서 로그인 사용자만 접근하도록 코드 수정
  * 자신의 계정 정보만 수정할 수 있도록 보안 처리
  * 중복 코드에 대한 리팩토링
* Gson 라이브러리를 활용한 api개발
  * api를 개발하기 위해 자바 객체를 json으로, json을 자바 객체로 변환하는 작업이 많이 필요하다. 자바 진영 라이브러리 중에 gson 또는 jackson이 많이 사용된다.
  * gson 라이브러리 추가
  * gson 라이브러리를 활용해 json 데이터로 변환
  * json에 대한 content type 설정
* 리팩토링 이슈 찾기, 등록, 관리
  * 리팩토링할 요소 찾기
  * github에 issue 등록
  * 마일스톤 관리 및 이슈 관리

## 06. Validator 적용 및 Maven 빌드 도구

* Validator 라이브러리 설치, 적용, 테스트
  * hibernate validator 라이브러리 적용
  * 단위 테스트를 활용해 java validator 학습
* 회원가입 Servlet(CreateUserServlet)에 Validator 적용
* Maven 프로젝트 디렉토리 구조 학습
* eclipse effective pom 탭을 통해 Maven 부모 pom 학습
* Maven 기본 명령어 complies/test/package 학습
* Maven phase, goal 관계 학습
* Compiler 플러그인과 eclipse 플러그인 재정의 및 빌드
* eclipse에서 효율적으로 Maven goal 실행하기
* 프로젝트에 Maven 적용
  * 기존의 많은 소스코드를 git에 공유하지 않아도 된다. 특히 이클립스 관련 설정과 jar 라이브러리의 제외는 큰 장점이다.

## 07. 자바 웹 애플리케이션 배포 및 Logging Framework

* 서블릿 컨테이너 및 Tomcat 디렉토리 구조 학습
  * CLI 환경에서 Tomcat 구동, 종료
  * tail 명령어를 활용한 로그 확인
* Maven package 명령을 통해 war파일 생성
  * war 파일 생성을 위한 설정(태그)
  * war 파일을 Tomcat 서버에 배포
* Tomcat context 설정
  * Tomcat의 webapps 디렉토리에 웹 애플리케이션을 바로 배포할 수 있다.
  * 다른 방법은 conf/server.xml 설정을 추가해서 임이의 디렉토리에 있는 웹 애플리케이션을 배포할 수 있다.
  * Maven finalName 설정 태그
  * server.xml에서 tomcat context 설정
  * 개발 서버에서 웹 애플리케이션 배포시 디렉토리 구조
* [개발 서버에 소스 코드 배포 과정에 대한 자동화](http://ict-nroo.tistory.com/67)
  * 소스 코드를 빌드/배포하는 과정에서 수 많은 반복 작업이 발생한다. 반복 작업은 자동화하는 것이 가장 안전하다.
  * 배포 과정에서 발생하는 반복 과정에 대한 인지
  * 쉘 스크립트를 이용해 배포 과정을 자동화
* [Logging Framework 개념 및 설정](http://ict-nroo.tistory.com/68)
  * System.out.println()을 사용하는 것의 문제점 인식
  * Logging Framework이 필요한 이유
  * Logging Framework 설정
  * Logging Level 학습
  * 패키지별 Logging Framework 설정
  * Debug 메세지 구현시 주의할 점

## 08. DAO 리팩토링

* DAO의 insert, update, delete 중복 제거
  * 라이브러리 코드와 개발자가 구현해야 하는 코드를 분리
  * abstract 키워드를 활용해 추상 클래스 구현
  * 익명 클래스 사용
* select 중복 제거
  * 쿼리에 대한 중복 코드 제거
  * getConnection 메소드 중복 제거 및 테스트 코드 수정
* TemplateMethod 패턴을 활용해서 JdbcTemplate 통합
  * TemplateMethod 패턴을 활용할 때의 문제점 인지
  * 각 Method를 interface로 분리해서 통합
* 자바 Generic을 활용해 캐스팅을 하지 않도록 라이브러리 구현
* 여러 건의 데이터를 조회할 수 있는 list() 기능 추가
* SQLException(Checked Exception)을 DataAccessException(Unchecked Exception)으로 래핑
  * Checked Exception과 Unchecked Exception의 개념
  * SQLException을 Unchecked Exception으로 변환
* 람다 표현식을 사용하도록 리팩토링
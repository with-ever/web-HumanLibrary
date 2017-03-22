# 휴먼라이브러리 웹 프로젝트 #

휴먼라이브러리 API, 관리자 프로젝트

### 설명 ###
* 각 프로젝트 메이븐 모듈 분리. (core, api, web)
* humanlibrary-api 모듈은 클라이언트에 api를 제공한다.
* humanlibrary-admin 모듈은 관리자 페이지를 제공한다.
* 위 두 모듈은 humanlibrary-core 모듈의 의존성을 가지고 있다.
* settings.xml 파일을 로컬 메이븐 저장소에 생성한다. (.m2/settings.xml)

### 시작하기 ###

1. humanlibrary-project maven install -s settings.xml(settings.xml 경로) -P local(빌드 될 타입)
2. humanlibrary-api / humanlibrary-admin tomcat start.
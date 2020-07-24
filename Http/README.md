## HTTP(Hyper Text Transfer Protocol)

인터넷은 전송할 데이터를 HTTP라는 프로토콜로 만들어진 패킷에 담은 후에 전송프로토콜인 TCP/IP(Transmission Control Protocal/Internet Protocol)를 사용하여 전달하는 구조를 가진다.

HTTP는 웹상의 서버와 웹브라우저의 통신이 가능하도록 설계된 표준규약
TCP는 패킷의 순서를 보장해주기위한 전송 규약
IP는 인터넷의 주소 규칙

TCP를 기반으로 하는 많은 프로토콜(HTTP, FTP, SMTP등등)이 존재하며 TCP는 IP를 기반으로 동작하므로 편의상 묶어서 TCP/IP라고 칭한다.


![image](https://user-images.githubusercontent.com/36143374/88409109-76221d80-ce0f-11ea-8615-153697f59984.png)

- 출처 - https://medium.com/@chrisjune_13837/web-http-tcp-ip-%EB%A9%94%EC%8B%9C%EC%A7%80%EB%9E%80-4b2721fe296f

## HTTP 구조

https://developer.mozilla.org/ko/docs/Web/HTTP/Overview

1. Header

   1. General

      1. Date - HTTP 메세지 생성시간
      2. Connection - 클라이언트와 서버간의 연결 옵션
      3. Cache-Control - 캐싱 정책
      4. ...등등

   2. Request / Response

      1. Host - 요청하는 호스트의 이름 및 포트번호
      2. User-Agent - 요자의 정보(브라우저, OS등)
      3. Origin - 요청이 발생한 주소. 보낸 주소와 받는 주소가 다르면 CORS 에러 발생
      4. Cookie - 쿠키정보
      5. Referer - 직전에 머물렀던 웹 주소
      6. Authorization - 인증토큰을 전송
      7. Server - 웹서버 정보
      8. Set-Cookie - 서버에게 설정(전송)한 쿠키
      9. Access-Control-Allow-Origin - 요청이 허용되는 주소
      10. ...등등

   3. Entity - 본문(Body)에 대한 정보
      1. Content-Type - 본문에 포함되는 미디어 타입 정보
      2. Content-Language
      3. Content-Encoding - 본문에 데이터 압축 방식
      4. Content-Length - 본문의 바이트 크기
      5. ... 등등

2. Body - 요청/응답 본문의 내용

## HTTP 요청 방식

수행할 요청에 대한 정의 방식

1. GET - 서버의 정보 조회
2. POST - 서버에 데이터를 저장 및 수정용도
3. PUT - 서버에 데이터를 저장 및 수정용도
4. DELETE - 서버에 데이터를 삭제용도
5. ...등등 https://developer.mozilla.org/ko/docs/Web/HTTP/Methods

## HTTP 응답상태 코드

응답에 대한 상태를 정의한 코드번호
https://developer.mozilla.org/ko/docs/Web/HTTP/Status

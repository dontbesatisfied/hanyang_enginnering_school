HTTP(Hyper Text Transfer Protocol)
---

인터넷은 전송할 데이터를 HTTP라는 프로토콜로 만들어진 패킷에 담은 후에 전송프로토콜인 TCP/IP(Transmission Control Protocal/Internet Protocol)를 사용하여 전달하는 구조를 가진다.

HTTP는 웹상의 서버와 웹브라우저의 통신이 가능하도록 설계된 표준규약이다.


HTTP 구조
---

1. Header
    1. General
        1. Date - HTTP 메세지 생성시간
        2. Connection - 클라이언트와 서버간의 연결 옵션
        3. Cache-Control - 캐싱 정책
        ...등등

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
        ...등등

    3. Entity - 본문(Body)에 대한 정보
        1. Content-Type - 본문에 포함되는 미디어 타입 정보
        2. Content-Language
        3. Content-Encoding - 본문에 데이터 압축 방식
        4. Content-Length - 본문의 바이트 크기
        ... 등등

2. Body
    요청/응답 본문의 내용


HTTP 요청 방식
---




---
패킷 - 데이터가 전송되는 단위
TCP - 데이터 전달 규칙
IP - 인터넷 주소 규칙



# study-cs

## 참고문헌
* 면접을 위한 CS 전공지식 노트, 길벗출판사 

## Environments
* Framework : None
* SDK : Azul zulu version 13.0.12
* Gradle : 6.2

## Contents 
1. Design Pattern
2. Network
3. Operating System
4. Database
5. Data Structure

===========================================================
## Design Pattern
* 프로그램 설계 시 발생했던 문제점들을 객체간 상호 관계 등을 이용하여 해결할 수 있도록 하나의 '규약'형태로 만든 것.

### Singleton Pattern
* 하나의 클래스에 오직 하나의 인스턴스만 발생시키는 패턴. (예) Database Connection 
* TDD 단위 테스트 시, 각 테스트마다 독립적인 인스턴스를 만들기 어려움. 
* 모듈 간의 결합이 강해지는 문제가 있어 의존성 주입(Dependency Injection)으로 보완. 

### Factory Pattern
* 객체의 생성 부분을 분리하여 추상화.
* 유지보수성 증가. 
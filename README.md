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
```java
Singleton a = Singleton.getInstance();
Singleton b = Singleton.getInstance();
```

### Factory Pattern
* 객체의 생성 부분을 분리하여 추상화.
* 상속 관계의 상위 클래스가 뼈대를 결정하고, 하위 클래스가 구체적인 생성 로직을 결정. 
* 유지보수성 증가. 
```java
Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
Coffee americano = CoffeeFactory.getCoffee("Americano", 3000); 
```

### Strategy Pattern
* 객체의 행위를 바꾸고 싶은 경우 '직접'수정하지 않고 캡슐화한 알고리즘인 전략을 컨텍스트 내에서 상호 교체 가능하게 만드는 패턴.
```java
cart.pay(new CardOneStrategy("name", "card-number", "123", "12/01"));
cart.pay(new CardTwoStrategy("email@email.com", "1234"));
```

### Observer Pattern
* 주체가 어떤 객체의 상태변화를 관찰, 상태변화가 있을 때 옵저버들에게 변화를 알려주는 패턴.
* 주체 : 관찰 대상 객체의 상태 변화를 보고 있는 관찰자.
* 옵저버 : 관찰 대상 객체의 상태 변화에 따라 추가 행동이 발생하는 객체. 

### Proxy Pattern
* 대상 객체에 대한 접근 흐름을 사전에 가로채 앞단의 인터페이스 역할을 수행하는 패턴. 
* 보안, 데이터 검증, 캐싱, 로깅 등에 활용
* 외부에서 직업 WAS 접근을 차단하고 정적 자원 제공하는 WEB Proxy Server 활용
* CDN CloudFlare 로 크롤링, DDOS 공격 등을 방어 
* HTTPS 구축, CORS(Cross-Origin Resource Sharing) 에러 프록시 서버로 해결. 

### Iterator Pattern 
* 이터레이터를 사용하여 컬렉션 요소에 접근하는 패턴. 
* 자료형의 구조와 무관하게 이터레이터라는 하나의 인터페이스로 순회. 

### Revealing Module Pattern 
* 즉시 실행 함수를 통해 접근 제어자를 만드는 패턴. 
* javascript 등과 같이 접근 제어자가 없는 언어에서 노출모듈 패턴을 이용해 접근 제어자를 구현. 
* 아래 예시에서, public에 정의된 필드만이 외부에서 접근 가능함. 
```javascript
const data = (() => {
    const a = 1
    const b = () => 2
    const public = {
        c : 2,
        d : () => 3
    }
    return public
})()

console.log(data)
console.log(data.a)
// { c: 2, d: [Function: d]}
// undefined
```
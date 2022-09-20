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
* 주체 : 관찰 대상 객체의 상태 변화를 보고 있는 관찰자
* 옵저버 : 관찰 대상 객체의 상태 변화에 따라 추가 행동이 발생하는 객체. 


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


-------------------------------------------------------------------
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
* 아래 예시에서, public에 정의된 필드/함수만 외부에서 접근 가능함. 
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

### MVC Pattern
* 애플리케이션 구성 요소를 세 가지 역할로 분리, 재사용성과 확장성이 용이. 
* Model 애플리케이션의 데이터 계층. 
* View 사용자 인터페이스 요소. 모델의 정보를 저장하지 않고 단순 시각화의 역할. 변경발생 시 컨트롤러에 전달
* Controller 하나 이상의 모델, 뷰를 잇는 다리 역할. 모델과 뷰의 생명주기 관리. 
* 예) React.js

### MVP Pattern 
* 컨트롤러 대신 프레젠터(Presenter) 를 사용하는 패턴. 
* View 와 Presenter 가 1:1 관계로 MVC보다 강한 결합을 가지는 패턴. 

### MVVM Pattern
* 컨트롤러 대신 뷰모델(View Model)을 사용하는 패턴. 
* View Model 은 뷰를 추상화한 계층. 
* 커맨드와 데이터 바이딩을 가지는 것이 특징. 뷰와 뷰모델 사이의 양방향 데이터 바인딩을 지원. 
* 예) View.js

-------------------------------------------------------------------
## Network
* Node 와 Link 로 구성된 집합체. 
* Node : 서버, 라우터, 스위치 등의 네트워크 장치. 
* Link : Node 의 경로. 유선 또는 무선. 


### Network Topology
* 노드와 링크의 연결 형태. 
* 병목 현상을 찾을 때 중요한 기준이 됨. 

#### Tree Topology
* 트리 형태로 구성된 계층형 토폴로지. 
* 노드의 추가/삭제가 쉬우나 특정 노드에 트래픽이 집중될 때 하위 노드에 영향을 끼칠 수 있음. 

#### Bus Topology
* 중앙 통신 회선 하나에 여러 노드가 연결되어 공유하는 구성. 
* 근거리 통신망(LAN)에서 사용. 
* 설치 비용이 낮고 신뢰성이 높음. 노드 추가/삭제 용이. 
* 스푸핑(패킷 탈취)가 가능한 문제점 존재. 

#### Star Topology 
* 중앙에 있는 노드에 모두 연결된 네트워크 구성. 
* 패킷의 충돌 가능성이 낮음. 에러 탐지가 쉬움. 
* 중앙 노드에 장애 발생 시 전체 네트워크에 장애 발생. 

#### Ring Topology 
* 2개의 노드가 서로 연결되어 고리 형태를 구축. 
* 네트워크 구성이 어렵고, 회선 장애 발생 시 전체 네트워크 장애. 

#### Mesh Topology
* 망형. 그물망처럼 연결된 구조. 
* 다수의 경로가 존재하여 장애 영향이 적고 트래픽 분산됨. 
* 노드 추가가 어렵고 운용 비용이 높음. 


### TCP/IP

| TCP/IP 4계층 | OSI 7계층  |
|------------|----------|
| 애플리케이션 계층  | 애플리케이션 계층 |
| 애플리케이션 계층  | 프레젠테이션 계층 |
| 애플리케이션 계층  | 세션 계층    |
| 전송 계층      | 전송 계층    |
| 인터넷 계층     | 네트워크 계층  |
| 링크 계층      | 데이터링크 계층 |
| 링크 계층      | 물리 계층    |

#### 애플리케이션(Application) 계층
* FTP, HTTP, SSH, SMTP, DNS 등 응용 프로그램이 사용되는 프로토콜 계층. 
* 웹 서비스, 이메일 등 서비스를 실질적으로 사용자에 제공하는 계층.

#### 전송(Transport) 계층
* TCP : 패킷 순서를 보장하고 연결 지향으로 수신여부를 확인. 가상회선 패킷 교환방식.
* UDP : 순서를 보장하지 않고 수신여부 확인하지 않음. 데이터그램 패킷 교환방식.
* 송신자와 수신자를 연결하는 통신 서비스를 제공. 
* 데이터 스트림, 신뢰성, 흐름 제어를 제공.
##### Handshake 
* TCP의 신뢰성 확보를 위한 과정. 
* 3-way Handshake : 연결 성립을 위한 Handshake. 송신(SYN) -> 수신(SYN+ACK) -> 송신(ACK) 과정을 거쳐 승인번호를 교환한다. 
* 4-way Handshake : 연결 해제를 위한 Handshake. 송신(FIN) -> 수신(ACK) -> 수신(FIN) -> 송신(ACK) 
  * 지연 패킷과 연결 종료 확인을 위해, TIME_WAIT 상태에서 FIN을 수신받아야 연결을 닫는다.

#### 인터넷(Internet) 계층
* IP, ARP, ICMP. 
* 네트워크 패킷을 IP 주소로 지정된 목적지로 전송하기 위해 사용되는 계층. 
* 수신을 보장하지는 않는 비연결적 특징. 

#### 링크(Link) 계층 
* 물리적으로 데이터를 전달하기 위한 규칙을 정하는 계층. 
##### 통신 방식 (유선)
* LAN : Local Area Network
* 전이중화 통신 (Full Duplex) : 양측의 장치가 동시에 송수신할 수 있는 현대적 방식. 
* 반이중화 통신 (Half Duplex) : 한 번에 한쪽에서만 송신하는 방식 (무전기)
  * CSMA/CD (Carrier Sense Multiple Access with Collision Detection) : 송신 후 충돌 발생시 랜덤 시간(IFS) 이후 재전송
##### 통신 방식 (무선)
* WLAN : Wireless Local Area Network
* BSS (Basic Service Set): 동일 BSS 내에 있는 AP와 장치들이 서로 통신이 가능한 구조. 
* ESS (Extended Service Set) : 하나 이상의 BSS 그룹. 장거리 무선 통신 지원. 장소를 이용하며 중단 없이 네트워크 이용 가능. 

#### Encapsulation & Decapsulation
* Encapsulation : 상위 계층의 헤더와 데이터를 하위 계층의 데이터에 포함시켜 해당 계층의 헤더를 삽입. 
* Decapsulation : 하위 계층에서 상위 계층으로 가며 각 계층의 헤더를 제거하는 과정. 최종적으로 애플리케이션 PDU인 메시지를 전달. 
  * PDU : Protocol Data Unit. 계층간 전달 데이터의 단위


### IP
* ARP(Address Resolution Protocol) : IP 주소로부터 MAC 주소를 구하는 프로토콜. 
* RARP : MAC 주소로부터 IP 주소를 구하는 프로토콜. 
* 홉바이홉 통신 : IP주소를 통해 통신하는 과정. 통신망에서 각 패킷은 여러 개의 라우터를 건너가는데, 라우터의 라우팅 테이블에 기록된 IP를 기반으로 패킷을 전달.
* 라우팅 테이블 : 송신지에서 수신지까지 도달하기 위한 목적지와 경로를 확인할 수 있는 리스트. 
* 게이트웨이 : 서로 다른 통신망, 프로토콜을 사용하는 네트워크 간의 통신 관문. 
* DHCP (Dynamic Host Configuration Protocol) : IP주소와 통신매개변수를 자동 할당. 
* NAT (Network Address Translation) : 전송 시 패킷의 IP주소를 공인 IP로 매핑. 공인IP/사설IP로 나누어 주소할당 부족을 해결.

### HTTP
##### HTTP/1.0
* 한 연결 당 하나의 요청을 처리. RTT의 증가를 야기함. 
* RTT : 패킷이 왕복하는 데 걸리는 시간
* RTT 증가를 해결하기 위한 방법 
  * 이미지 스플리팅 : 다수의 이미지 다운로드 대신, 합쳐진 하나의 이미지를 다운받아 position 을 이용해 이미지를 표기
  * 코드 압축 : 개행문자, 빈칸을 없애 크기를 최소화. 
  * 이미지 Base64인코딩 : 이미지를 인코딩해 바이트로 반환하여, 서버 요청횟수를 줄임. 단, 크기가 37%가량 증가함. 

##### HTTP/1.1
* 한 번 TCP 초기화 이후 keep-alive 옵션으로 여러 개 파일을 송수신할 수 있도록 표준화.
* 특정 파일의 다운로드가 지연될 경우 다음 순서의 리소스 다운로드가 전부 지연될 수 있음. 
* 헤더에 쿠키 등 많은 메타데이터가 압축되지 않아 무거워진 특징. 

##### HTTP/2
* HTTP/1.x 보다 응답시간을 빠르게 하기 위한 표준 정립. 
  * 멀티플렉싱 : 여러 개의 스트림을 사용하여 송수신. 분할된 데이터를 송수신하여 조합. 
  * 헤더 압축 : HPACK 압축 형식으로 헤더를 압축해 패킷 크기를 감축. 
  * 서버 푸시 : 클라이언트 요청 없이 서버가 바로 리소스를 푸시할 수 있음. css, js 등을 클라이언트에 먼저 전달할 수 있다. 

##### HTTPS
* 애플리케이션 계층과 전송 계층 사이에 신뢰 계층인 SSL/TLS 계층을 삽입한 신뢰할 수 있는 HTTP 요청. 
* SSL/TLS (Secure Socket Layer / Transfort Layer Security Protocol) : 통신 시 제 3자가 메시지를 도청/변조하지 못하게 방어. 

##### HTTP/3
* QUIC 라는 계층 위에서 동작. UDP 기반으로 동작한다. (HTTP/2는 TCP 기반)
* TCP Handshake를 하지 않아 초기 연결 시 지연시간이 적다. 

-------------------------------------------------------------------
## Operating System 
### 운영체제의 역할과 구성
#### 운영체제의 역할
* CPU Scheduling & Process Management
* Memory Management
* Disk Management
* I/O Device Management

#### 운영체제의 구조
| 항목          | 분류  | 설명                                            |
|-------------|-----|-----------------------------------------------|
| Application |     |                                               |
| GUI         | OS  | 사용자와 상호작용을 위한 인터페이스                           |
| System Call | OS  | 운영체제가 커널에 접근하기 위한 인터페이스                       |
| Kernal      | OS  | 시스템콜 인터페이스 제공. 보안, 메모리, 프로세스, 파일, IO 관리 등 수행. |
| Driver      | OS  | 하드웨어 장치 동작을 위한 S/W                            |
| Hardware    |     |                                               |

* modebit : 시스템콜 작동 시 유저 모드와 커널 모드를 구분하기 위한 flag. 

### CPU
* Central Processing Unit.
* 인터럽트에 의해 메모리상의 명령어를 해석하는 장치. 
* 구성
  * 산술논리연산장치 ALU, Arithmetic Logic Unit. 산술/논리 연산을 수행하는 디지털 회로
  * 제어장치 CU, Control Unit. 프로세스 조작을 지시하는 장치. I/O장치 간 통신 제어, 명령어 해석, 처리순서 결정
  * 레지스터 Register. CPU의 매우 빠른 임시기억장치.

### Memory
* 구성
  * 레지스터 : CPU 내의 매우 빠른 임시 기억장치. 휘발성. 
  * 캐시 : L1, L2, L3 캐시. 휘발성. 
  * 주기억장치 : RAM, 휘발성.
  * 보조기억장치 : HDD, SSD, 비휘발성.

##### Cache
* 접근시간 차이에 따른 병목현상을 줄이기 위한 메모리. 
* 캐시히트, 미스 : 캐시에서 원하는 데이터를 찾은 경우 히트, 메모리에서 찾아와야 하는 경우 미스. 
* 캐시매핑 : 캐시가 히트되기 위해 매핑하는 방법. 
  * 직접 매핑 Direct Mapping : 순서를 맞춰 캐시 주소를 직접 지정하는 경우. 처리가 빠르지만 충돌이 잦음. 
  * 연관 매핑 Associative Mapping : 순서를 맞추지 않고 관련있는 캐시와 메모리 매핑. 출돌이 적지만 탐색이 많아 느림. 
  * 집합 연관 매핑 Set Associative Mapping : 순서는 맞추지만 집합 블록을 두어 저장. 

#### Memory Management
##### Virtual Memory
* 실제 이용 가능한 메모리 자원을 추상화하여 더 큰 메모리로 보이게 하는 것. 
* 메모리관리장치(MMU)에 의해 가상 주소와 실제 주소가 매핑되어 기록된 페이지 테이블로 관리됨. 

##### Swapping
* 가상 메모리에 존재하지만 물리 메모리에 없는 데이터에 접근할 경우 페이지 폴트가 발생함.
* 당장 사용하지 않는 영역을 하드 디스크로 이동, 필요할 때 메모리에 올려 관리하는 것을 의미함.

##### Thrashing
* 메모리의 페이지 폴트율이 높은 상황을 의미. 
* 메모리에 너무 많은 프로세스가 올라와 과도한 스와핑으로 CPU 이용률이 낮아짐. 
* 낮아진 CPU 이용률은 더 많은 프로세스를 메모리에 올리게 되며 스레싱이 발생함. 

##### Memory Allocating
* 시작 메모리 위치, 메모리의 할당 크기를 기반으로 메모리에 프로그램 할당. 
* 연속 할당
  * 메모리에 연속적으로 공간을 할당하는 방법. 
  * 고정 분할 방식 Fixed partition allocation : 메모리를 미리 나누어 관리하는 방식. 내부 단편화 발생. 
  * 가변 분할 방식 Variable partition allocation : 매 시점 프로그램 크기에 맞게 동적으로 메모리를 나누어 사용. 외부 단편화 발생. 
    * 최초 적합 First fit : 홀을 찾으면 바로 할당.
    * 최적 적합 Best fit : 프로세스 크기 이상인 공간 중 가장 작은 홀부터 할당. 
    * 최악 적합 Worst fit : 프로세스 크기와 가장 많이 차이가 나는 홀에 할당. 
* 불연속 할당
  * 메모리를 연속적으로 할당하지 않는 방법. 
  * 페이징 Paging
    * 동일한 크기의 페이지 단위로 나누어 메모리 서로 다른 위치에 프로세스를 할당. 
    * 홀의 크기에 자유롭지만 주소 변환이 복잡해짐. 
  * 세그멘테이션 Segmentation
    * 의미 단위의 세그먼트로 나누는 방식. 
    * 코드와 데이터, 또는 함수 단위 등으로 나눌 수 있다. 
    * 공유와 보안 측면에서 좋으며 홀 크기가 균일하지는 않음. 
  * 페이지드 세그멘테이션 Paged Segmentation
    * 공유나 보안을 의미 단위의 세그먼트로 나누고, 물리적 메모리는 페이지로 나누는 기법. 

##### Page swap Algorithm
* 스와핑은 가급적 자주 발생하지 않도록 설계되어야 함.
  * 오프라인 알고리즘 Offline Algorithm : 먼 미래에 참조되는 페이지와 현재 할당하는 페이지를 바꾸는 알고리즘. 성능 비교를 위한 알고리즘. 
  * FIFO First In First Out : 가장 먼저 온 페이지를 교체. 
  * LRU Least Recently Used : 참조된 지 가장 오래된 페이지를 교체. 각 페이지마다 계수기, 스택 등을 두어야 하는 문제 있음. 
  * NUR Not Used Recently : 참조/비참조 비트를 이용해 순회하며 참조되지 않은 페이지를 찾아 교체. 
  * NFU Least Frequently Used : 가장 참조 횟수가 적은 페이지를 교체. 

### Process, Thread 
* Process = Task : 실행중인 프로그램. 
* Thread : 프로세스 내 작업의 흐름. 

##### Compile
* 전처리 : 소스코드 주석 제거. 의존성 파일을 병합하여 매크로를 치환
* 컴파일러 : 오류 처리, 코드 최적화하여 어셈블리어로 변환
* 어셈블러 : 어셈블리어의 목적 코드(Object Code)로 변한. 
* 링커 : 라이브러리, 목적 코드를 결합하여 실행 파일로 변환. 

##### Process Status 
* 생성 Create : 프로세스가 생성된 상태. fork() 또는 exec()에 의해 생성, PCB 할당
* 대기 Ready : 메모리 공간이 충분할 때 메모리를 할당받고 CPU 소유권을 받을 때까지 대기. 
* 실행 Running : CPU Burst. CPU 및 메모리를 할당받고 인스트럭션을 수행 중인 상태. 
* 중단 Blocked : 특정 이벤트에 의해 프로세스가 차단된 상태. I/O 디바이스에 의한 인터럽트 등. 
* 종료 Terminated : 메모리와 CPU 소유권을 모두 놓고 가는 상태. 

##### Memory Structure of Process 
* 스택 Stack
  * 지역변수, 매개변수, 함수를 저장. 동적 영역. 
  * 컴파일 시 크기 결정.
* 힙 Heap
  * 동적 할당 시 사용되어 런타임에 크기 결정. 동적 영역.
* 데이터 Data 
  * 전역변수, 정적변수 저장. 정적 영역. 
  * BSS 영역과 Data 영역으로 구분. 
    * BSS 영역 : 초기화되지 않은 변수가 저장.
    * Data 영역 : 다른 값으로 할당된 변수들이 저장. 
* 코드 Code
  * 프로그램의 소스 코드가 들어가는 영역. 수정 불가능한 기계어. 정적 영역. 

##### PCB
* Process Control Block. 프로세스 제어 블록. 운영 체제에서 프로세스에 대한 메타데이터를 저장한 데이터. 
  * 프로세스 스케줄링 상태
  * 프로세스 ID
  * 프로세스 권한
  * 프로그램 카운터
  * CPU 레지스터
  * CPU 스케줄링 정보
  * 계정 정보
  * I/O 상태 정보

##### Context Switching
* PCB를 교환하는 과정. 
* 프로세스 실행 중 멈추고, PCB를 저장 및 다른 PCB를 로드하여 다른 프로세스를 실행하는 방식. 
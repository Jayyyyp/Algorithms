# Java concepts

---
### 1. try-catch (예외 처리)

- 프로그램이 비정상적으로 종료되는 것을 방지하고, 적절한 조치를 취하는 것.
- throws 키워드를 사용하여 해당 메소드에서 발생할 수 있는 예외를 명시적 선언한다.
- 이 메소드를 호출하는 상위 코드에 예외 처리를 위임할 수 있다.
  - ``` BufferedReader```나, ```BufferedWriter```를 사용할 때, 파일이나 네트워크를 통한 데이터 읽기 및 
     쓰기 작업을 수행하는데, 여러 가지 이유로 실패할 수 있다.
  - 이때, ``` throws IOException```으로 컴파일러가 해당 예외를 처리하도록 강제한다.
>**이는 프로그램의 안전성을 높이고, 예외가 발생하면 예외를 적절히 처리하여 프로그램이 계속 실행되게 한다.**

---
### 2. BufferedReader

- 자바의 I/O 라이브러리에 속한 클래스
- 문자 입력 스트림에서 텍스트를 효율적으로 읽는 데 사용
- 내부적으로 버퍼를 사용하여 데이터를 읽어들이므로, 빠르게 작동
>```readLine()``` 메소드를 제공해 **한 번에 한 줄씩** 텍스트를 읽는 것을 쉽게 만들어준다.

---
### 3. StringTokenizer 

- 문자열을 여러 토큰으로 분리하는 데 사용되는 클래스
- 단어나 문장의 일부를 나타내며, 주어진 구분자를 기준으로 토큰을 분리한다.
>```hasMoreTokens()```, ```nextToken()```, `countTokens()` 등의 메소드를 사용하여 
> 
>토큰을 순차적으로 접근할 수 있게 한다.

---

### 4. BufferedWriter

- 텍스트 쓰기 작업의 성능이 향상
- 큰 블록의 텍스트를 한 번에 출력 스트림에 쓰기 때문이다.
>```bw.flush();``` // 명시적으로 버퍼를 비워 출력 스트림에 쓰기

---

### 5. StringBuilder

- 문자열을 조작할 때 사용하는 클래스
- String 클래스와 달리, 변경이 가능하므로, 문자열을 변경하는 연산이 많을 때 성능이 좋다.
> 문자열을 반복적으로 연결하는 경우, 
> 
>String을 사용하면 매번 새로운 문자열 객체를 생성해야 하지만,
> 
>StringBuilder를 사용하면 기존 문자열에 변경을 가할 수 있어 효율적이다.

---

### 6. Integer 클래스 메소드

- Integer.toString(int i)

: 주어진 정수를 문자열로 변환하는 메소드

- Integer.parseInt(String S)

: 문자열을 int로 변환하는 메소드로, 반환한 int 값은 산술 연산에 바로 사용될 수 있음

- Integer.valueOf(String s)

: 문자열을 Integer 객체로 변환하는 메소드로, 문자열을 객체로서의 기능이 필요한 경우 사용

- MAX_VALUE와 MIN_VALUE

: 최댓값과 최솟값

---

### 7. String 클래스

- charAt()

: 문자열에서 특정 인덱스에 위치한 문자를 반환
: 인덱스가 문자열 길이보다 크거나 음수인 경우, IndexOutBoundsException 발생

- toCharArray()

: 문자열을 char 배열로 변환

- equals()

: 두 문자열이 같은지 비교하고, 같으면 true, 다르면 false 반환

---

### 8. LinkedList 클래스

- 연결 리스트 자료구조를 표현한 것
- 요소가 데이터와 포인터를 가지며, 포인터를 통해 순차적으로 연결되어있는 리스트를 의미한다.
- 주요 메소드
  - add(E e)

    : 리스트 끝에 지정된 요소 추가
  
  - addFirst(E e) & addLast(E e)
  
    : 리스트의 처음과 끝에 지정된 요소 삽입
  
   - clear()
    
    : 리스트에서 모든 요소 제거
    
    - contains(Object o)
    
    : 리스트가 지정된 요소를 포함하는 경우, true 반환
    
    - get(int index)
    
    : 리스트의 지정된 위치에 있는 요소 반환
    
    - remove(int index)
    
    : 리스트의 지정된 위치에 있는 요소를 제거하고 반환
    
    - size()
    
    : 리스트의 요소 개수를 반환
  
---

### 9. Stack 클래스(LIFO)

- push(E item) 
    : 스택의 맨 위에 요소를 추가

- pop()
    : 스택의 맨 위에 있는 요소를 제거하고 반환

- peek()
    : 스택의 맨 위에 있는 요소를 반환하지만, 제거하지는 않는다.

- isEmpty()
    : 스택이 비어있는 경우, true, 비어있지 않으면 false

- search(Object o)
    : 스택에서 객체의 위치를 반환

---

### 10. Queue 클래스(FIFO)

- offer(E e)
  : 큐의 끝에 요소를 추가한다
  : 성공하면 true, 공간 부족으로 실패하면 false

- poll()
  : 큐의 가장 앞쪽에 있는 요소를 제거하고 반환
  : 비어있는 경우, NULL

- peek()
  : 큐의 가장 앞쪽에 있는 요소를 반환
  : 요소를 제거하지는 않는다. 비어있는 경우, NULL

- size()
    : 원소의 개수를 반환

---

### 11. Deque 클래스 (양쪽에서 입력과 출력)

- offerFirst(E e) & offerLast(E e)
    : 데크의 맨 앞과 맨 뒤에 요소 추가

- pollFirst(E e) & pollLast(E e)
    : 덱의 맨 앞과 맨 뒤에 있는 요소를 제거하고, 반환

- peekFirst() & peekLast()
    : 덱의 맨 앞과 맨 뒤에 있는 요소 반환(조회만)

---

### 12. for-each(enhanced for)

- array의 각 원소를 순차적으로 접근하고, 현재 원소를 type var에 할당하는 enhanced for문

```for(type var : array)```
    : type은 배열의 요소의 데이터 타입
    : var는 루프 변수
    : array는 순회할 배열이나 컬렉션

```int[] numbers = {1, 2, 3, 4, 5};
for (int number : numbers) {
System.out.println(number);
} // 1,2,3,4,5 출력 ```
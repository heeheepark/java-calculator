# Java Calculator

인프런 부트캠프(Spring 과정) 개인 과제로 구현한 계산기 프로젝트입니다.

## 프로젝트 소개

Java 기본 개념을 학습하기 위해 구현한 콘솔 기반 계산기입니다.<br/>
사칙연산과 원의 넓이 계산 기능을 제공합니다.

## 주요 기능

- 사칙연산 (+, -, *, /, %)
- 원의 넓이 계산
- 계산 결과 저장 및 조회
- 저장된 결과 삭제
- 특정 값보다 큰 결과 조회
- 잘못된 입력에 대한 예외 처리

## 적용한 기술 및 개념

- Java
- 클래스 분리
- 상속(Inheritance)
- 제네릭(Generic)
- 캡슐화(Encapsulation)
- 생성자(Constructor)
- 컬렉션(List)
- 예외 처리(Exception)
- SRP(Single Responsibility Principle)
- 포함 관계(Composition)
- Enum
- 익명 함수(Lambda)
- 스트림(Stream)


## 프로젝트 진행 과정

과제의 단계별 요구사항에 맞춰 기능을 추가하고 구조를 개선했습니다.

### Lv1

- 사칙연산 계산기 구현
- 계산 결과 저장 및 조회(Collection 사용)
- 계산 결과 삭제

### Lv2

- Calculator 클래스를 통한 공통 기능 분리
- 원의 넓이 계산 기능 구현
- 상속을 활용한 구조 개선
- 사칙연산을 각각의 클래스로 분리
  - `AddOperator`
  - `SubtractOperator`
  - `MultiplyOperator`
  - `DivideOperator`
- ModOperator(나머지 연산) 기능 추가

### Lv3

- Enum 활용
- Generic을 적용하여 여러 숫자 타입 지원
- Stream API와 Lambda를 활용한 특정 값 이상의 결과 조회

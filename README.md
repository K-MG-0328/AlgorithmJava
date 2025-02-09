## 많이 사용하는 메서드 정리

### 문자열

#### charAt(int index)	
📌 특정 위치의 문자 가져오기	

#### substring(int beginIndex, int endIndex)	
📌 부분 문자열 추출

#### split(String regex)
📌 특정 문자로 문자열 분할		

#### replace(String old, String new)	
📌 문자열 치환

#### replaceAll(String regex, String replacement)	
📌 정규식 기반 치환

#### indexOf(String s)	
📌 특정 문자/문자열의 첫 등장 위치

#### contains(CharSequence s)	
📌 문자열 포함 여부 확인

#### toCharArray()	
📌 문자열을 문자 배열로 변환	

#### trim()	
📌 문자열 앞뒤 공백 제거

### 배열

#### Arrays.get(int index)
📌 배열의 특정 인덱스의 요소 가져오기

#### Arrays.sort(int[] arr)
📌 배열을 오름차순으로 정렬합니다.

#### Arrays.sort(Integer[] arr, Collections.reverseOrder())
📌 배열을 내림차순으로 정렬합니다. (int[]가 아닌 Integer[] 사용)

#### Arrays.copyOf(int[] arr, int newLength)
📌 배열을 지정된 길이만큼 복사합니다.

#### Arrays.copyOfRange(int[] arr, int start, int end)
📌 배열의 특정 부분을 복사합니다. (end는 포함되지 않음)

#### Arrays.asList(T... a)
📌 배열을 리스트로 변환합니다. (int[]는 Integer[]로 변환 필요)

#### Arrays.stream(arr).anyMatch(x -> x == value)
📌 배열에 특정 값이 포함되어 있는지 확인합니다.

#### Arrays.toString(int[] arr)
📌 배열을 문자열로 변환합니다.

#### Arrays.fill(int[] arr, int value)
📌 배열을 특정 값으로 채웁니다.

#### (int) Arrays.stream(arr).filter(x -> x > value).count()
📌 특정 조건을 만족하는 요소의 개수를 셉니다.

#### Arrays.stream(arr).sum()
📌 배열의 모든 요소를 더합니다.

#### Arrays.stream(arr).min().getAsInt() / Arrays.stream(arr).max().getAsInt()
📌 배열에서 최소값과 최대값을 찾습니다.

#### Arrays.stream(arr).sorted().boxed().collect(Collectors.toList())
📌 배열을 정렬된 리스트로 변환합니다.

## 배열 <-> 리스트 변환 ⭐⭐⭐

### 객체 배열 -> 리스트 변환
#### Integer[] array = {1, 2, 3};
📌 객체 배열
#### List<Integer> list = Arrays.asList(array) 
📌 배열을 고정된 리스트를 반환합니다. Arrays.asList(array)를 사용하면 배열의 각 요소가 리스트의 개별 요소로 변환됩니다. //고정된이 뭔말이지?
#### List<Integer> list = new ArrayList<>(Arrays.asList(array))
📌 배열을 수정 가능한 List로 생성해서 반환합니다.

### 기본형 배열 -> 리스트 변환 ⭐⭐⭐
Java의 제네릭은 기본형(int, double, 등)을 직접 다룰 수 없으므로, List<int>와 같이 기본형 배열을 제네릭 타입으로 사용하면 타입 불일치 문제가 발생합니다.  
기본형 배열을 리스트로 개별 요소로 변환하려면 각 int를 Integer로 박싱한 후 이를 리스트로 모아야합니다.  
#### int[] array = {1, 2, 3};
📌 기본형 배열
#### List<int[]> list = Arrays.asList(array); 
📌 Arrays.asList(array)를 사용하면, 배열 전체가 하나의 요소로 취급되어 [int[]] 형태의 리스트가 만들어집니다.
#### List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList()); ⭐
📌 배열을 int - > Integer로 변환 후 리스트로 생성합니다.
.
### 객체 배열 <- 리스트 변환
#### list.toArray(new Integer[list.size()]) 
#### list.toArray(new Integer[0])
📌 리스트를 객체 배열로 생성해서 반환합니다.

### 기본형 배열 <- 리스트 변환
#### int[] intArray = list.stream().mapToInt(i -> i).toArray(); ⭐
📌 스트림을 이용해 기본형 배열로 변환합니다.

### 리스트
#### int idx = list.indexOf(10);
📌 x가 몇 번째 인덱스에 있는지 반환합니다. (없으면 -1) 내부적으로 순차 검색 → O(n)

#### boolean b = list.contains(10);
📌 리스트에 요소가 있는지 확인합니다. (true/false)

#### Collections.sort(list);           
📌 리스트를 오름차순 정렬합니다.

#### Collections.sort(list, Comparator.reverseOrder()); 
📌 리스트를 내림차순 정렬합니다.

#### Collections.binarySearch(list, key)
📌 정렬된 리스트에 대해, key가 있을 경우 인덱스 반환, 없으면 음수 반환  O(log n)

#### Collections.max(list), Collections.min(list)
📌 최댓값, 최솟값 O(n)

#### Collections.reverse(list)
📌 리스트의 순서를 뒤집음

#### Collections.swap(list, i, j)
📌 두 인덱스의 요소 교환

### Math

#### Math.abs(int a)
📌 주어진 숫자의 절댓값을 반환합니다.
ex) Math.abs(-5); // → 5

#### Math.max(int a, int b)
📌 두 수 중 큰 값을 반환합니다.

#### Math.min(int a, int b)
📌 두 수 중 작은 값을 반환합니다.

#### Math.pow(double a, double b)
📌 a^b (a의 b제곱)을 계산합니다.

#### Math.sqrt(double a)
📌 주어진 숫자의 제곱근을 반환합니다.

#### Math.floor(double a)
📌 주어진 숫자를 내림 처리합니다.

#### Math.ceil(double a)
📌 주어진 숫자를 올림 처리합니다.

#### Math.round(double a)
📌 주어진 숫자를 반올림 처리합니다.

### 팩토리얼 계산

#### TopDown 방식
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
    factorial(5);
#### BottomUp 방식
    public static long factorial(int n) {
        for(int i = 1; i <= n; i++) {
            answer = answer * i;
        }
        return answer;
    }
    factorial(5);

### 최대공약수(GCD)를 구하는 메서드
    public static int gcd(int a, int b) {
        // 12 18
        // 18 12
        // 12 6
        // 6 0
        return b == 0 ? a : gcd(b, a % b);
    }
    gcd(12, 18); // 6


### 최소공배수(LCM)를 구하는 메서드
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));  // 비교 수 중 작은수 * 최대공약수 = 최소공배수 
    }
    lcm(12, 18); // 36

### 순열
순열의 개수 = P(n,r) = n! / (n-r)!


### int와 long의 범위

#### int (32비트 정수)  
•	최소값: -2,147,483,648 (약 -2.1×10^9)  
•	최대값: 2,147,483,647 (약 2.1×10^9)  
#### long (64비트 정수)  
•	최소값: -9,223,372,036,854,775,808 (약 -9.22×10^18)  
•	최대값: 9,223,372,036,854,775,807 (약 9.22×10^18)  

#### 거듭제곱
•	2^30 = 1,073,741,824 → int 범위 내
•	2^31 = 2,147,483,648 → int 범위 초과  
•	10^9 = 1,000,000,000 int 범위 내
•	10^10 = 10,000,000,000 → int 범위 초과

•	2^63 ≈ 9.22×10^18 (경계선)
•	10^18 = 1,000,000,000,000,000,000 → long 범위 내  
•	10^19 = 10,000,000,000,000,000,000 → long 범위 초과

#### Factorial
•	12! = 479,001,600 (약 4.79×10^8) → int 범위 내  
•	13! = 6,227,020,800 (약 6.23×10^9) → int 범위 초과  
•	20! = 2,432,902,008,176,640,000 (약 2.43×10^18) → long 범위 내  
•	21! = 51,090,942,171,709,440,000 (약 5.10×10^19) → long 범위 초과  
## 많이 사용하는 메서드 정리

### 문자열

charAt(int index)	
📌 특정 위치의 문자 가져오기	

substring(int beginIndex, int endIndex)	
📌 부분 문자열 추출

split(String regex)
📌 특정 문자로 문자열 분할		

replace(String old, String new)	
📌 문자열 치환

replaceAll(String regex, String replacement)	
📌 정규식 기반 치환

indexOf(String s)	
📌 특정 문자/문자열의 첫 등장 위치

contains(CharSequence s)	
📌 문자열 포함 여부 확인

toCharArray()	
📌 문자열을 문자 배열로 변환	

trim()	
📌 문자열 앞뒤 공백 제거

### 배열
Arrays.sort(int[] arr)
📌 배열을 오름차순으로 정렬합니다.

Arrays.sort(Integer[] arr, Collections.reverseOrder())
📌 배열을 내림차순으로 정렬합니다. (int[]가 아닌 Integer[] 사용)

Arrays.copyOf(int[] arr, int newLength)
📌 배열을 지정된 길이만큼 복사합니다.

Arrays.copyOfRange(int[] arr, int start, int end)
📌 배열의 특정 부분을 복사합니다. (end는 포함되지 않음)

Arrays.asList(T... a)
📌 배열을 리스트로 변환합니다. (int[]는 Integer[]로 변환 필요)

Arrays.stream(arr).anyMatch(x -> x == value)
📌 배열에 특정 값이 포함되어 있는지 확인합니다.

Arrays.toString(int[] arr)
📌 배열을 문자열로 변환합니다.

Arrays.fill(int[] arr, int value)
📌 배열을 특정 값으로 채웁니다.

(int) Arrays.stream(arr).filter(x -> x > value).count()
📌 특정 조건을 만족하는 요소의 개수를 셉니다.

Arrays.stream(arr).sum()
📌 배열의 모든 요소를 더합니다.

Arrays.stream(arr).min().getAsInt() / Arrays.stream(arr).max().getAsInt()
📌 배열에서 최소값과 최대값을 찾습니다.

Arrays.stream(arr).sorted().boxed().collect(Collectors.toList())
📌 배열을 정렬된 리스트로 변환합니다.

### Math

Math.abs(int a)
📌 주어진 숫자의 절댓값을 반환합니다.
ex) Math.abs(-5); // → 5

Math.max(int a, int b)
📌 두 수 중 큰 값을 반환합니다.

Math.min(int a, int b)
📌 두 수 중 작은 값을 반환합니다.

Math.pow(double a, double b)
📌 a^b (a의 b제곱)을 계산합니다.

Math.sqrt(double a)
📌 주어진 숫자의 제곱근을 반환합니다.

Math.floor(double a)
📌 주어진 숫자를 내림 처리합니다.

Math.ceil(double a)
📌 주어진 숫자를 올림 처리합니다.

Math.round(double a)
📌 주어진 숫자를 반올림 처리합니다.

팩토리얼 계산 // 이거 바텀업 방식을 사용하라고 했던 것 같은데?
public static long factorial(int n) {
    if (n == 0 || n == 1) return 1;
    return n * factorial(n - 1);
}
factorial(5);

최대공약수(GCD)를 구하는 메서드
public static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}
gcd(12, 18);


최소공배수(LCM)를 구하는 메서드
public static int lcm(int a, int b) {
    return a * (b / gcd(a, b));
}
lcm(12, 18);

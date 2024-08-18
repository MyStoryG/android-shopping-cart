# android-shopping-cart

## Step1 구현 목록

- [x] dummy data 생성
- [x] Glide 설정
- [x] 타이틀 뷰 구현
- [x] 상품 아이템 뷰 구현
- [x] 상품 리스트 뷰 구현
- [x] dummy data 변경
- [x] GlideImage 사이즈 조정
- [x] 테스트 코드 작성

## Step1 진행 중 의식의 흐름

- TDD로 해야 하는데... 하지만 아직 컴포즈 숙달에 좀 더 집중하고자 일단 뷰부터 구현했습니다.
- Title을 만들다가 갑자기 AppBar 관련 컴포넌트가 있을 것 같아서 찾아보니 TopAppBar라는 것이 있는 것을 알게 되었습니다. 그래서 이걸 사용해 보려고 합니다.
- LazyColumn이 있는데 왜 Column이 있을까요? 간단한 레이아웃을 그릴 때는 굳이 LazyColumn을 사용할 필요가 없을 것 같습니다. 예를 들어 스크롤이 발생하면서
  여러 데이터를 갱신할 필요가 없다면 한 번에 렌더링 되면 그만이기 때문입니다.
- ProductItem에서 컴포넌트를 더 나눠야 할까요? 아이템 내부에 각 컴포넌트도 나누면 너무 잘게 나눠진다고 느껴집니다. 그래서 일단은 하나로 묶었습니다.
- modifier를 주입하되 무조건 그렇게 해야 하는 것은 아니라고 수업시간에 언근된 것으로 기억합니다. 현재 LazyVerticalGrid에서 ProductItem의
  파라미터로 modifier를 주입하고 있습니다. 하지만 GlideImage에서 해당 modifier를 사용하면 패딩이 적용된 상태에서 사이즈를 조정하여 렌더링하기 때문에
  의도하지 않은 패딩으로 원하는 UI가 그려지지 않습니다. 그래서 별도의 Modifier를 내부에서 적용하도록 수정했습니다.
- 각_상품의_이미지와_텍스트가_표시된다() 테스트 코드에서 val formattedPrice = NumberFormat.getNumberInstance(Locale.KOREAN)
  .format(product.price)라는 로직을 사용하고 싶지 않습니다. 이런 경우엔 어떻게 테스트하면 좋을까요? ProductItemTest에서 검증된 사항이기도 하지만
  리스트로 보여주는 부분에서 또 확인해야 안정감이 들 것 같아서 시도해 보았습니다.
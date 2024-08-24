_# android-shopping-cart

## Step3 구현 목록

- [x] Step2 피드백 반영
- [x] 장바구니 아이템 화면 추가
- [x] 장바구니 목록 화면 추가
- [x] 주문하기 버튼 추가
  - [x] 주문하기 버튼에 가격 총합 표시
- [] 장바구니 상품 수량 조절 구현
- [] 장바구니 상품 삭제 구현
    - [] 삭제 버튼
    - [] 수량 0인 경우
- [] 상품 가격 합계 구현

## Step3 진행 중 의식의 흐름

- 현업처럼 디자인 가이드에 딱 맞추려고 시도하다 시간이 많이 소비되었습니다. 학습 측면에서도 가이드를 지켜야 하는 것은 맞으나 현재 학습 목적과는 상이한 것 같아서 일단 디테일한
  간격 등은 임의로 두었습니다.
- LazyColumn 아래에 버튼을 고정시키는 것이 의외의 복병이었습니다. LazyColumn은 스크롤이 가능한 컴포넌트이기 때문에 버튼을 고정시키기 위해서는
  LazyColumn을 Box로 감싸고 버튼을 하단에 두면 될 줄 알았습니다. 이 경우 LazyColumn과 버튼의 영역이 겹치는 문제가 있었습니다.
- 다른 시도는 Column으로 감싸고 버튼을 Column의 마지막에 배치하는 것이었습니다. 이것도 잘 안되었습니다. LazyColumn을 감싼 Column에 weight를 주면
  버튼을 제외한 나머지 공간을 차지하기 때문에 버튼이 고정이 되긴 합니다. 하지만 아이템이 1개 추가되면 상단이 아니라 가운데부터 배치되는 문제가 있었습니다.
- Scaffold에서 topBar, bottomBar를 사용해도 LazyColumn의 영역이 topBar, bottomBar를 침범하는 문제가 있었습니다.
  innerPadding의 존재를 발견해서 해결했습니다. 학습 목적에 중요한 부분이 아닐 수 있지만 상당히 많은 매몰비용이 발생했습니다.

## Step2 구현 목록

- [x] Step1 피드백 반영
- [x] 빈 장바구니 화면 추가
- [x] 상품 목록 화면에서 장바구니 화면으로 이동 구현
- [x] 장바구니 화면에서 상품 목록 화면으로 이동 구현
- [x] 상품 상세 화면 추가
- [x] 상품 목록 화면에서 상품 상세 화면으로 이동 구현
- [x] 상품 상세 화면에서 상품 목록 화면으로 이동 구현
- [x] 장바구니 담기 버튼 선택 시 장바구니 화면으로 이동 구현
- [x] 장바구니 화면에서 상품 상세 화면으로 이동 구현
- [x] 테스트 코드 작성

## Step2 진행 중 의식의 흐름

- Parcelable이 기본 세팅 되어 있지 않은 점으로 미루어 볼 때, 이번 미션에서는 사용하지 않는 것이 좋을 것 같다고 판단했습니다. 컴포즈 학습에 집중하기 위해서요.
- 지난 회원가입 미션에서는 컴포저블을 최대한 재활용 해보려고 애쓰다가 불필요한 로직이 추가되었습니다. 이번 미션의 이번 단계에서는 일단 최대한 각 화면을 분리하여 구현해 보려고
  합니다.
- shape = RoundedCornerShape(n.dp)와 Modifier.clip(RoundedCornerShape(n.dp))의 차이점에 대해서 좀 더 알아보고 싶습니다.
  둘 다 라운드 처리를 해주는 것으로 알고 있는데 어떤 차이가 있는지 궁금하기 때문입니다.
- 뒤로 가기 동작은 처음에 무지성으로 Intent를 사용해서 구현했습니다. 그때도 런치 모드를 어떻게 할까 고민하였는데 불필요한 시간이 되었습니다. 왜냐면 직전 화면으로
  돌아가야만 하는 장바구니 화면을 구현하다 보니 onBackPressedDispatcher?.onBackPressed()를 사용하게 되었습니다. 괜찮은 방법인지 궁금합니다.

## Step1 구현 목록

- [x] dummy data 생성
- [x] Glide 설정
- [x] 타이틀 뷰 구현
- [x] 상품 아이템 뷰 구현
- [x] 상품 리스트 뷰 구현
- [x] dummy data 변경
- [x] GlideImage 사이즈 조정
- [x] 테스트 코드 작성
- [x] 피드백 1차 반영

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
  리스트로 보여주는 부분에서 또 확인해야 안정감이 들 것 같아서 시도해 보았습니다._

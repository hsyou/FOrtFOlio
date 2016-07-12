
============================================================
Date	: 2016-3-24 13:25
Writer 	: Kyoung-ah Kwon
Classify	: Unsolved
Content	:

 * 한계: MySQL은 실제 서비스에서 호환성이 떨어짐 (다른 운영체제, 다른 브라우저에서 다르게 보임)

 * 예상 해결법: 런칭 전에 유료 서비스 결제하여 사용

============================================================
Date	: 2016-3-22 12:14
Writer 	: Kyoung-ah Kwon
Classify	: Unsolved
Content	:

 * 한계: Project.jsp 에서 사용자의 project list를 불러오는 과정에서,
	modal 창 내에서 getAttribute한 변수를 사용(foreach에 적용)할 수 없음

 * 밑돌 빼기: Editor 페이지를 불러올 때 getAttribute를 하여 저장, modal창에 적용해 둠

 * 발생할 문제점: 방금 추가한 project는 리스트에 반영되어 있지 않음

 * 예상 해결법
	1. modal에서도 동적으로 getAttribute 후 사용 할 수 있도록 함
	2. project를 새로 add할 때는, 기존에 열려있던 탭들을 session에 저장
	-> refresh(or redirect, recall GetProjectEditorController)

============================================================
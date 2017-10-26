-- 회원
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE` RESTRICT;

-- 판매자
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE2` RESTRICT;

-- 구매자
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE3` RESTRICT;

-- 책 정보
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE4` RESTRICT;

-- 장바구니
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE5` RESTRICT;

-- 책사진
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE6` RESTRICT;

-- 주소
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE7` RESTRICT;

-- 주문과정
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE8` RESTRICT;

-- 게시판
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE9` RESTRICT;

-- 1:1문의
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE10` RESTRICT;

-- 리뷰
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE11` RESTRICT;

-- 배송
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE12` RESTRICT;

-- 주문
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE13` RESTRICT;

-- 판매내역
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE14` RESTRICT;

-- 보관함
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE15` RESTRICT;

-- 임시 테이블
DROP TABLE IF EXISTS `MY_SCHEMA`.`Temporary` RESTRICT;

-- 임시 테이블2
DROP TABLE IF EXISTS `MY_SCHEMA`.`Temporary2` RESTRICT;

-- 책정보사진
DROP TABLE IF EXISTS `MY_SCHEMA`.`Temporary3` RESTRICT;

-- 리뷰사진
DROP TABLE IF EXISTS `MY_SCHEMA`.`Temporary4` RESTRICT;

-- 주소
DROP TABLE IF EXISTS `MY_SCHEMA`.`Temporary5` RESTRICT;

-- asdsads
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE16` RESTRICT;

-- 구매서적
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE17` RESTRICT;

-- 새 테이블2
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE18` RESTRICT;

-- 회원
DROP TABLE IF EXISTS `MY_SCHEMA`.`TABLE19` RESTRICT;

-- 회원
CREATE TABLE `MY_SCHEMA`.`TABLE` (
)
COMMENT '회원';

-- 판매자
CREATE TABLE `MY_SCHEMA`.`TABLE2` (
	`MNO`  INTEGER     NOT NULL COMMENT '판매자번호', -- 판매자번호
	`BCOM` VARCHAR(50) NOT NULL COMMENT '출판사명', -- 출판사명
	`BNUM` INTEGER     NOT NULL COMMENT '사업자번호' -- 사업자번호
)
COMMENT '판매자';

-- 판매자
ALTER TABLE `MY_SCHEMA`.`TABLE2`
	ADD CONSTRAINT `PK_TABLE2` -- 판매자 기본키
		PRIMARY KEY (
			`MNO` -- 판매자번호
		);

-- 판매자 유니크 인덱스
CREATE UNIQUE INDEX `UIX_TABLE2`
	ON `MY_SCHEMA`.`TABLE2` ( -- 판매자
		`BNUM` ASC -- 사업자번호
	);

ALTER TABLE `MY_SCHEMA`.`TABLE2`
	MODIFY COLUMN `MNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '판매자번호';

-- 구매자
CREATE TABLE `MY_SCHEMA`.`TABLE3` (
	`MNO` INTEGER     NOT NULL COMMENT '구매자번호', -- 구매자번호
	`BIR` DATE        NOT NULL COMMENT '생년월일', -- 생년월일
	`GEN` CHAR(1)     NOT NULL COMMENT '성별', -- 성별
	`NIC` VARCHAR(50) NULL     COMMENT '닉네임' -- 닉네임
)
COMMENT '구매자';

-- 구매자
ALTER TABLE `MY_SCHEMA`.`TABLE3`
	ADD CONSTRAINT `PK_TABLE3` -- 구매자 기본키
		PRIMARY KEY (
			`MNO` -- 구매자번호
		);

-- 구매자 인덱스
CREATE INDEX `IX_TABLE3`
	ON `MY_SCHEMA`.`TABLE3`( -- 구매자
		`NIC` ASC -- 닉네임
	);

ALTER TABLE `MY_SCHEMA`.`TABLE3`
	MODIFY COLUMN `MNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '구매자번호';

-- 책 정보
CREATE TABLE `MY_SCHEMA`.`TABLE4` (
	`BNO`   INTEGER      NOT NULL COMMENT '책번호', -- 책번호
	`BNAME` VARCHAR(50)  NOT NULL COMMENT '책이름', -- 책이름
	`PRICE` INTEGER      NOT NULL COMMENT '가격', -- 가격
	`CONT`  MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	`WRT`   VARCHAR(50)  NOT NULL COMMENT '지은이', -- 지은이
	`BCOM`  VARCHAR(50)  NOT NULL COMMENT '출판사명', -- 출판사명
	`PDT`   DATETIME     NOT NULL COMMENT '발간일', -- 발간일
	`INT`   MEDIUMTEXT   NULL     COMMENT '소개', -- 소개
	`GNR`   VARCHAR(255) NOT NULL COMMENT '장르', -- 장르
	`COUNT` INTEGER      NOT NULL COMMENT '수량', -- 수량
	`MNO`   INTEGER      NOT NULL COMMENT '판매자번호' -- 판매자번호
)
COMMENT '책 정보';

-- 책 정보
ALTER TABLE `MY_SCHEMA`.`TABLE4`
	ADD CONSTRAINT `PK_TABLE4` -- 책 정보 기본키
		PRIMARY KEY (
			`BNO` -- 책번호
		);

ALTER TABLE `MY_SCHEMA`.`TABLE4`
	MODIFY COLUMN `BNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '책번호';

-- 장바구니
CREATE TABLE `MY_SCHEMA`.`TABLE5` (
	`SBNO`  INTEGER     NOT NULL COMMENT '장바구니번호', -- 장바구니번호
	`BNAME` VARCHAR(50) NOT NULL COMMENT '상품명', -- 상품명
	`PRICE` INTEGER     NOT NULL COMMENT '가격', -- 가격
	`COUNT` INTEGER     NOT NULL COMMENT '수량', -- 수량
	`ONO`   INTEGER     NOT NULL COMMENT '주문번호', -- 주문번호
	`BNO`   INTEGER     NOT NULL COMMENT '책번호' -- 책번호
)
COMMENT '장바구니';

-- 장바구니
ALTER TABLE `MY_SCHEMA`.`TABLE5`
	ADD CONSTRAINT `PK_TABLE5` -- 장바구니 기본키
		PRIMARY KEY (
			`SBNO` -- 장바구니번호
		);

ALTER TABLE `MY_SCHEMA`.`TABLE5`
	MODIFY COLUMN `SBNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '장바구니번호';

-- 책사진
CREATE TABLE `MY_SCHEMA`.`TABLE6` (
)
COMMENT '책사진';

-- 주소
CREATE TABLE `MY_SCHEMA`.`TABLE7` (
)
COMMENT '주소';

-- 주문과정
CREATE TABLE `MY_SCHEMA`.`TABLE8` (
	`COL10` <데이터 타입 없음> NOT NULL COMMENT '주문과정번호', -- 주문과정번호
	`COL`   <데이터 타입 없음> NULL     COMMENT '상품명', -- 상품명
	`COL2`  <데이터 타입 없음> NULL     COMMENT '가격', -- 가격
	`COL3`  <데이터 타입 없음> NULL     COMMENT '수량', -- 수량
	`COL4`  <데이터 타입 없음> NULL     COMMENT '배송방법', -- 배송방법
	`COL5`  <데이터 타입 없음> NULL     COMMENT '결제방법', -- 결제방법
	`COL6`  <데이터 타입 없음> NULL     COMMENT '주문인', -- 주문인
	`COL7`  <데이터 타입 없음> NULL     COMMENT '주소', -- 주소
	`COL8`  <데이터 타입 없음> NULL     COMMENT '폰번호', -- 폰번호
	`COL9`  <데이터 타입 없음> NULL     COMMENT '메시지', -- 메시지
	`MNO`   INTEGER            NULL     COMMENT '구매자번호' -- 구매자번호
)
COMMENT '주문과정';

-- 주문과정
ALTER TABLE `MY_SCHEMA`.`TABLE8`
	ADD CONSTRAINT `PK_TABLE8` -- 주문과정 기본키
		PRIMARY KEY (
			`COL10` -- 주문과정번호
		);

-- 게시판
CREATE TABLE `MY_SCHEMA`.`TABLE9` (
)
COMMENT '게시판';

-- 1:1문의
CREATE TABLE `MY_SCHEMA`.`TABLE10` (
	`QNO`  INTEGER      NOT NULL COMMENT '1:1문의번호', -- 1:1문의번호
	`TITL` VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
	`CONT` MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	`ANS`  MEDIUMTEXT   NULL     COMMENT '답변', -- 답변
	`CDT`  DATETIME     NOT NULL COMMENT '등록일', -- 등록일
	`ADT`  DATETIME     NULL     COMMENT '답변일', -- 답변일
	`MNO`  INTEGER      NULL     COMMENT '회원번호' -- 회원번호
)
COMMENT '1:1문의';

-- 1:1문의
ALTER TABLE `MY_SCHEMA`.`TABLE10`
	ADD CONSTRAINT `PK_TABLE10` -- 1:1문의 기본키
		PRIMARY KEY (
			`QNO` -- 1:1문의번호
		);

ALTER TABLE `MY_SCHEMA`.`TABLE10`
	MODIFY COLUMN `QNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '1:1문의번호';

-- 리뷰
CREATE TABLE `MY_SCHEMA`.`TABLE11` (
	`RNO`  INTEGER      NOT NULL COMMENT '리뷰번호', -- 리뷰번호
	`CONT` MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
	`STA`  INTEGER      NULL     COMMENT '평점', -- 평점
	`NIC`  VARCHAR(50)  NULL     COMMENT '닉네임', -- 닉네임
	`DATE` DATETIME     NOT NULL COMMENT '날짜', -- 날짜
	`TITL` VARCHAR(255) NULL     COMMENT '제목', -- 제목
	`LIKE` CHAR(1)      NULL     COMMENT '공감', -- 공감
	`MNO`  INTEGER      NULL     COMMENT '구매자번호' -- 구매자번호
)
COMMENT '리뷰';

-- 리뷰
ALTER TABLE `MY_SCHEMA`.`TABLE11`
	ADD CONSTRAINT `PK_TABLE11` -- 리뷰 기본키
		PRIMARY KEY (
			`RNO` -- 리뷰번호
		);

ALTER TABLE `MY_SCHEMA`.`TABLE11`
	MODIFY COLUMN `RNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '리뷰번호';

-- 배송
CREATE TABLE `MY_SCHEMA`.`TABLE12` (
	`DNO`      INTEGER      NOT NULL COMMENT '배송번호', -- 배송번호
	`DCOM`     VARCHAR(50)  NOT NULL COMMENT '배송회사', -- 배송회사
	`IVNO`     INTEGER      NOT NULL COMMENT '송장번호', -- 송장번호
	`DDAY`     DATETIME     NOT NULL COMMENT '배송일자', -- 배송일자
	`DPAY`     INTEGER      NOT NULL COMMENT '배송비', -- 배송비
	`DET_ADDR` VARCHAR(255) NOT NULL COMMENT '상세주소', -- 상세주소
	`SNO`      INTEGER      NOT NULL COMMENT '판매내역번호', -- 판매내역번호
	`ARNO`     INTEGER      NULL     COMMENT '주소번호' -- 주소번호
)
COMMENT '배송';

-- 배송
ALTER TABLE `MY_SCHEMA`.`TABLE12`
	ADD CONSTRAINT `PK_TABLE12` -- 배송 기본키
		PRIMARY KEY (
			`DNO` -- 배송번호
		);

-- 배송 유니크 인덱스
CREATE UNIQUE INDEX `UIX_TABLE12`
	ON `MY_SCHEMA`.`TABLE12` ( -- 배송
		`IVNO` ASC -- 송장번호
	);

ALTER TABLE `MY_SCHEMA`.`TABLE12`
	MODIFY COLUMN `DNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '배송번호';

-- 주문
CREATE TABLE `MY_SCHEMA`.`TABLE13` (
	`ONO`      INTEGER      NOT NULL COMMENT '주문번호', -- 주문번호
	`PDT`      DATETIME     NOT NULL COMMENT '결제 날짜', -- 결제 날짜
	`RNAME`    VARCHAR(50)  NOT NULL COMMENT '수령인', -- 수령인
	`PRD`      VARCHAR(255) NOT NULL COMMENT '주문상품', -- 주문상품
	`DET_ADDR` VARCHAR(255) NOT NULL COMMENT '상세주소', -- 상세주소
	`PAYM`     VARCHAR(50)  NOT NULL COMMENT '결제방법', -- 결제방법
	`DELM`     VARCHAR(50)  NOT NULL COMMENT '배송방법', -- 배송방법
	`COUNT`    INTEGER      NOT NULL COMMENT '수량', -- 수량
	`PRICE`    INTEGER      NOT NULL COMMENT '가격', -- 가격
	`ETC`      MEDIUMTEXT   NULL     COMMENT '기타사항', -- 기타사항
	`ARNO`     INTEGER      NULL     COMMENT '주소번호', -- 주소번호
	`MNO`      INTEGER      NULL     COMMENT '구매자번호' -- 구매자번호
)
COMMENT '주문';

-- 주문
ALTER TABLE `MY_SCHEMA`.`TABLE13`
	ADD CONSTRAINT `PK_TABLE13` -- 주문 기본키
		PRIMARY KEY (
			`ONO` -- 주문번호
		);

ALTER TABLE `MY_SCHEMA`.`TABLE13`
	MODIFY COLUMN `ONO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '주문번호';

-- 판매내역
CREATE TABLE `MY_SCHEMA`.`TABLE14` (
	`SNO`   INTEGER      NOT NULL COMMENT '판매내역번호', -- 판매내역번호
	`PDT`   DATETIME     NOT NULL COMMENT '결제 날짜', -- 결제 날짜
	`CDT`   DATETIME     NOT NULL COMMENT '등록일', -- 등록일
	`EDT`   DATETIME     NOT NULL COMMENT '종료일', -- 종료일
	`SPRD`  VARCHAR(255) NOT NULL COMMENT '판매상품', -- 판매상품
	`COUNT` INTEGER      NOT NULL COMMENT '수량', -- 수량
	`PRICE` INTEGER      NOT NULL COMMENT '가격', -- 가격
	`ONO`   INTEGER      NOT NULL COMMENT '주문번호', -- 주문번호
	`MNO`   INTEGER      NOT NULL COMMENT '판매자번호' -- 판매자번호
)
COMMENT '판매내역';

-- 판매내역
ALTER TABLE `MY_SCHEMA`.`TABLE14`
	ADD CONSTRAINT `PK_TABLE14` -- 판매내역 기본키
		PRIMARY KEY (
			`SNO` -- 판매내역번호
		);

ALTER TABLE `MY_SCHEMA`.`TABLE14`
	MODIFY COLUMN `SNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '판매내역번호';

-- 보관함
CREATE TABLE `MY_SCHEMA`.`TABLE15` (
)
COMMENT '보관함';

-- 임시 테이블
CREATE TABLE `MY_SCHEMA`.`Temporary` (
	`COL` <데이터 타입 없음> NULL COMMENT '새 컬럼' -- 새 컬럼
)
COMMENT '임시 테이블';

-- 임시 테이블2
CREATE TABLE `MY_SCHEMA`.`Temporary2` (
	`COL` <데이터 타입 없음> NULL COMMENT '사진' -- 사진
)
COMMENT '임시 테이블2';

-- 책정보사진
CREATE TABLE `MY_SCHEMA`.`Temporary3` (
	`BPNO` INTEGER   NOT NULL COMMENT '책정보사진번호', -- 책정보사진번호
	`PIC`  VARBINARY NOT NULL COMMENT '사진', -- 사진
	`BNO`  INTEGER   NOT NULL COMMENT '책번호' -- 책번호
)
COMMENT '책정보사진';

-- 책정보사진
ALTER TABLE `MY_SCHEMA`.`Temporary3`
	ADD CONSTRAINT `PK_Temporary3` -- 책정보사진 기본키
		PRIMARY KEY (
			`BPNO` -- 책정보사진번호
		);

ALTER TABLE `MY_SCHEMA`.`Temporary3`
	MODIFY COLUMN `BPNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '책정보사진번호';

-- 리뷰사진
CREATE TABLE `MY_SCHEMA`.`Temporary4` (
	`RPNO` INTEGER   NOT NULL COMMENT '리뷰사진번호', -- 리뷰사진번호
	`PIC`  VARBINARY NULL     COMMENT '사진', -- 사진
	`RNO`  INTEGER   NULL     COMMENT '리뷰번호' -- 리뷰번호
)
COMMENT '리뷰사진';

-- 리뷰사진
ALTER TABLE `MY_SCHEMA`.`Temporary4`
	ADD CONSTRAINT `PK_Temporary4` -- 리뷰사진 기본키
		PRIMARY KEY (
			`RPNO` -- 리뷰사진번호
		);

ALTER TABLE `MY_SCHEMA`.`Temporary4`
	MODIFY COLUMN `RPNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '리뷰사진번호';

-- 주소
CREATE TABLE `MY_SCHEMA`.`Temporary5` (
	`ARNO`     INTEGER      NOT NULL COMMENT '주소번호', -- 주소번호
	`PST_NO`   VARCHAR(255) NOT NULL COMMENT '기본주소', -- 기본주소
	`BAS_ADDR` VARCHAR(10)  NOT NULL COMMENT '우편번호' -- 우편번호
)
COMMENT '주소';

-- 주소
ALTER TABLE `MY_SCHEMA`.`Temporary5`
	ADD CONSTRAINT `PK_Temporary5` -- 주소 기본키
		PRIMARY KEY (
			`ARNO` -- 주소번호
		);

ALTER TABLE `MY_SCHEMA`.`Temporary5`
	MODIFY COLUMN `ARNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '주소번호';

-- asdsads
CREATE TABLE `MY_SCHEMA`.`TABLE16` (
	`BNO` INTEGER NOT NULL COMMENT '책번호', -- 책번호
	`MNO` INTEGER NULL     COMMENT '구매자번호' -- 구매자번호
)
COMMENT 'asdsads';

-- asdsads
ALTER TABLE `MY_SCHEMA`.`TABLE16`
	ADD CONSTRAINT `PK_TABLE16` -- asdsads 기본키
		PRIMARY KEY (
			`BNO` -- 책번호
		);

-- 구매서적
CREATE TABLE `MY_SCHEMA`.`TABLE17` (
	`BNO` INTEGER NOT NULL COMMENT '책번호', -- 책번호
	`MNO` INTEGER NULL     COMMENT '구매자번호' -- 구매자번호
)
COMMENT '구매서적';

-- 구매서적
ALTER TABLE `MY_SCHEMA`.`TABLE17`
	ADD CONSTRAINT `PK_TABLE17` -- 구매서적 기본키
		PRIMARY KEY (
			`BNO` -- 책번호
		);

ALTER TABLE `MY_SCHEMA`.`TABLE17`
	MODIFY COLUMN `BNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '책번호';

-- 새 테이블2
CREATE TABLE `MY_SCHEMA`.`TABLE18` (
	`BNO`  INTEGER NOT NULL COMMENT '책번호', -- 책번호
	`SBNO` INTEGER NULL     COMMENT '장바구니번호' -- 장바구니번호
)
COMMENT '새 테이블2';

-- 새 테이블2
ALTER TABLE `MY_SCHEMA`.`TABLE18`
	ADD CONSTRAINT `PK_TABLE18` -- 새 테이블2 기본키
		PRIMARY KEY (
			`BNO` -- 책번호
		);

-- 회원
CREATE TABLE `MY_SCHEMA`.`TABLE19` (
	`MNO`      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	`NAME`     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	`TEL`      VARCHAR(30)  NOT NULL COMMENT '폰번호', -- 폰번호
	`EMAIL`    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	`DET_ADDR` VARCHAR(255) NOT NULL COMMENT '상세주소', -- 상세주소
	`ARNO`     INTEGER      NOT NULL COMMENT '주소번호' -- 주소번호
)
COMMENT '회원';

-- 회원
ALTER TABLE `MY_SCHEMA`.`TABLE19`
	ADD CONSTRAINT `PK_TABLE19` -- 회원 기본키
		PRIMARY KEY (
			`MNO` -- 회원번호
		);

-- 회원 인덱스
CREATE INDEX `IX_TABLE19`
	ON `MY_SCHEMA`.`TABLE19`( -- 회원
		`NAME` ASC -- 이름
	);

ALTER TABLE `MY_SCHEMA`.`TABLE19`
	MODIFY COLUMN `MNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 판매자
ALTER TABLE `MY_SCHEMA`.`TABLE2`
	ADD CONSTRAINT `FK_TABLE19_TO_TABLE2` -- 회원 -> 판매자
		FOREIGN KEY (
			`MNO` -- 판매자번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE19` ( -- 회원
			`MNO` -- 회원번호
		);

-- 구매자
ALTER TABLE `MY_SCHEMA`.`TABLE3`
	ADD CONSTRAINT `FK_TABLE19_TO_TABLE3` -- 회원 -> 구매자
		FOREIGN KEY (
			`MNO` -- 구매자번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE19` ( -- 회원
			`MNO` -- 회원번호
		);

-- 책 정보
ALTER TABLE `MY_SCHEMA`.`TABLE4`
	ADD CONSTRAINT `FK_TABLE2_TO_TABLE4` -- 판매자 -> 책 정보
		FOREIGN KEY (
			`MNO` -- 판매자번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE2` ( -- 판매자
			`MNO` -- 판매자번호
		);

-- 장바구니
ALTER TABLE `MY_SCHEMA`.`TABLE5`
	ADD CONSTRAINT `FK_TABLE13_TO_TABLE5` -- 주문 -> 장바구니
		FOREIGN KEY (
			`ONO` -- 주문번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE13` ( -- 주문
			`ONO` -- 주문번호
		);

-- 장바구니
ALTER TABLE `MY_SCHEMA`.`TABLE5`
	ADD CONSTRAINT `FK_TABLE4_TO_TABLE5` -- 책 정보 -> 장바구니
		FOREIGN KEY (
			`BNO` -- 책번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE4` ( -- 책 정보
			`BNO` -- 책번호
		);

-- 주문과정
ALTER TABLE `MY_SCHEMA`.`TABLE8`
	ADD CONSTRAINT `FK_TABLE3_TO_TABLE8` -- 구매자 -> 주문과정
		FOREIGN KEY (
			`MNO` -- 구매자번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE3` ( -- 구매자
			`MNO` -- 구매자번호
		);

-- 1:1문의
ALTER TABLE `MY_SCHEMA`.`TABLE10`
	ADD CONSTRAINT `FK_TABLE19_TO_TABLE10` -- 회원 -> 1:1문의
		FOREIGN KEY (
			`MNO` -- 회원번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE19` ( -- 회원
			`MNO` -- 회원번호
		);

-- 리뷰
ALTER TABLE `MY_SCHEMA`.`TABLE11`
	ADD CONSTRAINT `FK_TABLE3_TO_TABLE11` -- 구매자 -> 리뷰
		FOREIGN KEY (
			`MNO` -- 구매자번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE3` ( -- 구매자
			`MNO` -- 구매자번호
		);

-- 배송
ALTER TABLE `MY_SCHEMA`.`TABLE12`
	ADD CONSTRAINT `FK_TABLE14_TO_TABLE12` -- 판매내역 -> 배송
		FOREIGN KEY (
			`SNO` -- 판매내역번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE14` ( -- 판매내역
			`SNO` -- 판매내역번호
		);

-- 배송
ALTER TABLE `MY_SCHEMA`.`TABLE12`
	ADD CONSTRAINT `FK_Temporary5_TO_TABLE12` -- 주소 -> 배송
		FOREIGN KEY (
			`ARNO` -- 주소번호
		)
		REFERENCES `MY_SCHEMA`.`Temporary5` ( -- 주소
			`ARNO` -- 주소번호
		);

-- 주문
ALTER TABLE `MY_SCHEMA`.`TABLE13`
	ADD CONSTRAINT `FK_TABLE3_TO_TABLE13` -- 구매자 -> 주문
		FOREIGN KEY (
			`MNO` -- 구매자번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE3` ( -- 구매자
			`MNO` -- 구매자번호
		);

-- 주문
ALTER TABLE `MY_SCHEMA`.`TABLE13`
	ADD CONSTRAINT `FK_Temporary5_TO_TABLE13` -- 주소 -> 주문
		FOREIGN KEY (
			`ARNO` -- 주소번호
		)
		REFERENCES `MY_SCHEMA`.`Temporary5` ( -- 주소
			`ARNO` -- 주소번호
		);

-- 판매내역
ALTER TABLE `MY_SCHEMA`.`TABLE14`
	ADD CONSTRAINT `FK_TABLE13_TO_TABLE14` -- 주문 -> 판매내역
		FOREIGN KEY (
			`ONO` -- 주문번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE13` ( -- 주문
			`ONO` -- 주문번호
		);

-- 판매내역
ALTER TABLE `MY_SCHEMA`.`TABLE14`
	ADD CONSTRAINT `FK_TABLE2_TO_TABLE14` -- 판매자 -> 판매내역
		FOREIGN KEY (
			`MNO` -- 판매자번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE2` ( -- 판매자
			`MNO` -- 판매자번호
		);

-- 책정보사진
ALTER TABLE `MY_SCHEMA`.`Temporary3`
	ADD CONSTRAINT `FK_TABLE4_TO_Temporary3` -- 책 정보 -> 책정보사진
		FOREIGN KEY (
			`BNO` -- 책번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE4` ( -- 책 정보
			`BNO` -- 책번호
		);

-- 리뷰사진
ALTER TABLE `MY_SCHEMA`.`Temporary4`
	ADD CONSTRAINT `FK_TABLE11_TO_Temporary4` -- 리뷰 -> 리뷰사진
		FOREIGN KEY (
			`RNO` -- 리뷰번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE11` ( -- 리뷰
			`RNO` -- 리뷰번호
		);

-- asdsads
ALTER TABLE `MY_SCHEMA`.`TABLE16`
	ADD CONSTRAINT `FK_TABLE3_TO_TABLE16` -- 구매자 -> asdsads
		FOREIGN KEY (
			`MNO` -- 구매자번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE3` ( -- 구매자
			`MNO` -- 구매자번호
		);

-- asdsads
ALTER TABLE `MY_SCHEMA`.`TABLE16`
	ADD CONSTRAINT `FK_TABLE4_TO_TABLE16` -- 책 정보 -> asdsads
		FOREIGN KEY (
			`BNO` -- 책번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE4` ( -- 책 정보
			`BNO` -- 책번호
		);

-- 구매서적
ALTER TABLE `MY_SCHEMA`.`TABLE17`
	ADD CONSTRAINT `FK_TABLE3_TO_TABLE17` -- 구매자 -> 구매서적
		FOREIGN KEY (
			`MNO` -- 구매자번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE3` ( -- 구매자
			`MNO` -- 구매자번호
		);

-- 구매서적
ALTER TABLE `MY_SCHEMA`.`TABLE17`
	ADD CONSTRAINT `FK_TABLE4_TO_TABLE17` -- 책 정보 -> 구매서적
		FOREIGN KEY (
			`BNO` -- 책번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE4` ( -- 책 정보
			`BNO` -- 책번호
		);

-- 새 테이블2
ALTER TABLE `MY_SCHEMA`.`TABLE18`
	ADD CONSTRAINT `FK_TABLE4_TO_TABLE18` -- 책 정보 -> 새 테이블2
		FOREIGN KEY (
			`BNO` -- 책번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE4` ( -- 책 정보
			`BNO` -- 책번호
		);

-- 새 테이블2
ALTER TABLE `MY_SCHEMA`.`TABLE18`
	ADD CONSTRAINT `FK_TABLE5_TO_TABLE18` -- 장바구니 -> 새 테이블2
		FOREIGN KEY (
			`SBNO` -- 장바구니번호
		)
		REFERENCES `MY_SCHEMA`.`TABLE5` ( -- 장바구니
			`SBNO` -- 장바구니번호
		);

-- 회원
ALTER TABLE `MY_SCHEMA`.`TABLE19`
	ADD CONSTRAINT `FK_Temporary5_TO_TABLE19` -- 주소 -> 회원
		FOREIGN KEY (
			`ARNO` -- 주소번호
		)
		REFERENCES `MY_SCHEMA`.`Temporary5` ( -- 주소
			`ARNO` -- 주소번호
		);
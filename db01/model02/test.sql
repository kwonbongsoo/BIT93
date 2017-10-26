-- ����
DROP TABLE IF EXISTS LECT RESTRICT;

-- �л�
DROP TABLE IF EXISTS STUD RESTRICT;

-- ����
DROP TABLE IF EXISTS TCHR RESTRICT;

-- �Ŵ���
DROP TABLE IF EXISTS MGR RESTRICT;

-- ����
DROP TABLE IF EXISTS SUBJ RESTRICT;

-- ����
DROP TABLE IF EXISTS CROOM RESTRICT;

-- �Խ���
DROP TABLE IF EXISTS BOARD RESTRICT;

-- �ڷ��
DROP TABLE IF EXISTS FBOARD RESTRICT;

-- QNA
DROP TABLE IF EXISTS QNA RESTRICT;

-- ��������
DROP TABLE IF EXISTS CURR RESTRICT;

-- ���ǻ���
DROP TABLE IF EXISTS CR_PIC RESTRICT;

-- �ּ�
DROP TABLE IF EXISTS ADDR RESTRICT;

-- ������������
DROP TABLE IF EXISTS CURR_SUBJ RESTRICT;

-- ���Ǽ�����
DROP TABLE IF EXISTS LECT_STUD RESTRICT;

-- ���ǹ���
DROP TABLE IF EXISTS LECT_TCHR RESTRICT;

-- MEMB
DROP TABLE IF EXISTS TABLE16 RESTRICT;

-- ����
CREATE TABLE LECT (
	LNO      INTEGER NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	SDT      DATE    NOT NULL COMMENT '������', -- ������
	EDT      DATE    NOT NULL COMMENT '������', -- ������
	QNT      INTEGER NOT NULL COMMENT '�����ο�', -- �����ο�
	TOTL_HRS DATE    NOT NULL COMMENT '�Ѱ��ǽð�', -- �Ѱ��ǽð�
	DAY_HRS  DATE    NOT NULL COMMENT '�ϰ��ǽð�', -- �ϰ��ǽð�
	PAY      INTEGER NULL     COMMENT '���Ƿ�', -- ���Ƿ�
	GOV_SUPP CHAR(1) NOT NULL COMMENT '������������', -- ������������
	EDNO     INTEGER NOT NULL COMMENT '����������ȣ', -- ����������ȣ
	CRNO     INTEGER NULL     COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	MNO      INTEGER NULL     COMMENT '�Ŵ�����ȣ' -- �Ŵ�����ȣ
)
COMMENT '����';

-- ����
ALTER TABLE LECT
	ADD CONSTRAINT PK_LECT -- ���� �⺻Ű
		PRIMARY KEY (
			LNO -- ���ǹ�ȣ
		);

ALTER TABLE LECT
	MODIFY COLUMN LNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǹ�ȣ';

-- �л�
CREATE TABLE STUD (
	MNO     INTEGER NOT NULL COMMENT '�л���ȣ', -- �л���ȣ
	BRTH_DT DATE    NULL     COMMENT '�������', -- �������
	WRK     CHAR(1) NOT NULL COMMENT '��������' -- ��������
)
COMMENT '�л�';

-- �л�
ALTER TABLE STUD
	ADD CONSTRAINT PK_STUD -- �л� �⺻Ű
		PRIMARY KEY (
			MNO -- �л���ȣ
		);

-- ����
CREATE TABLE TCHR (
	MNO    INTEGER      NOT NULL COMMENT '�����ȣ', -- �����ȣ
	PAY_HR INTEGER      NULL     COMMENT '�ð���', -- �ð���
	REUM   VARCHAR(255) NULL     COMMENT '�̷¼�' -- �̷¼�
)
COMMENT '����';

-- ����
ALTER TABLE TCHR
	ADD CONSTRAINT PK_TCHR -- ���� �⺻Ű
		PRIMARY KEY (
			MNO -- �����ȣ
		);

-- �Ŵ���
CREATE TABLE MGR (
	MNO  INTEGER     NOT NULL COMMENT '�Ŵ�����ȣ', -- �Ŵ�����ȣ
	POSI VARCHAR(30) NULL     COMMENT '����' -- ����
)
COMMENT '�Ŵ���';

-- �Ŵ���
ALTER TABLE MGR
	ADD CONSTRAINT PK_MGR -- �Ŵ��� �⺻Ű
		PRIMARY KEY (
			MNO -- �Ŵ�����ȣ
		);

-- ����
CREATE TABLE SUBJ (
	SBNO     INTEGER      NOT NULL COMMENT '�����ȣ', -- �����ȣ
	TITL     VARCHAR(255) NOT NULL COMMENT '�����', -- �����
	PRO_LANG VARCHAR(30)  NULL     COMMENT '���', -- ���
	INTRO    TEXT         NULL     COMMENT '����' -- ����
)
COMMENT '����';

-- ����
ALTER TABLE SUBJ
	ADD CONSTRAINT PK_SUBJ -- ���� �⺻Ű
		PRIMARY KEY (
			SBNO -- �����ȣ
		);

-- ���� ����ũ �ε���
CREATE UNIQUE INDEX UIX_SUBJ
	ON SUBJ ( -- ����
		TITL ASC -- �����
	);

ALTER TABLE SUBJ
	MODIFY COLUMN SBNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�����ȣ';

-- ����
CREATE TABLE CROOM (
	CRNO INTEGER     NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	NAME VARCHAR(30) NOT NULL COMMENT '���Ǹ�', -- ���Ǹ�
	LOC  VARCHAR(30) NOT NULL COMMENT '����' -- ����
)
COMMENT '����';

-- ����
ALTER TABLE CROOM
	ADD CONSTRAINT PK_CROOM -- ���� �⺻Ű
		PRIMARY KEY (
			CRNO -- ���ǹ�ȣ
		);

ALTER TABLE CROOM
	MODIFY COLUMN CRNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǹ�ȣ';

-- �Խ���
CREATE TABLE BOARD (
	BNO  INTEGER      NOT NULL COMMENT '�Խù���ȣ', -- �Խù���ȣ
	TITL VARCHAR(255) NOT NULL COMMENT '����', -- ����
	CONT MEDIUMTEXT   NOT NULL COMMENT '����', -- ����
	VWS  INTEGER      NULL     COMMENT '��ȸ��', -- ��ȸ��
	CDT  DATETIME     NOT NULL COMMENT '�����', -- �����
	MNO  INTEGER      NOT NULL COMMENT 'ȸ����ȣ' -- ȸ����ȣ
)
COMMENT '�Խ���';

-- �Խ���
ALTER TABLE BOARD
	ADD CONSTRAINT PK_BOARD -- �Խ��� �⺻Ű
		PRIMARY KEY (
			BNO -- �Խù���ȣ
		);

ALTER TABLE BOARD
	MODIFY COLUMN BNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�Խù���ȣ';

-- �ڷ��
CREATE TABLE FBOARD (
	FNO     INTEGER      NOT NULL COMMENT '�ڷ��ȣ', -- �ڷ��ȣ
	TITL    VARCHAR(255) NOT NULL COMMENT '���ϸ�', -- ���ϸ�
	FL_PATH VARCHAR(255) NOT NULL COMMENT '���ϰ��', -- ���ϰ��
	CONT    TEXT         NULL     COMMENT '����', -- ����
	DLS     INTEGER      NULL     COMMENT '�ٿ�ε��', -- �ٿ�ε��
	CDT     DATETIME     NOT NULL COMMENT '�����', -- �����
	MNO     INTEGER      NOT NULL COMMENT 'ȸ����ȣ' -- ȸ����ȣ
)
COMMENT '�ڷ��';

-- �ڷ��
ALTER TABLE FBOARD
	ADD CONSTRAINT PK_FBOARD -- �ڷ�� �⺻Ű
		PRIMARY KEY (
			FNO -- �ڷ��ȣ
		);

ALTER TABLE FBOARD
	MODIFY COLUMN FNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�ڷ��ȣ';

-- QNA
CREATE TABLE QNA (
	QANO INTEGER  NOT NULL COMMENT '������ȣ', -- ������ȣ
	QST  TEXT     NOT NULL COMMENT '����', -- ����
	CDT  DATETIME NOT NULL COMMENT '�����', -- �����
	ANR  TEXT     NULL     COMMENT '�亯', -- �亯
	ADT  DATETIME NULL     COMMENT '�亯��', -- �亯��
	MNO  INTEGER  NOT NULL COMMENT 'ȸ����ȣ' -- ȸ����ȣ
)
COMMENT 'QNA';

-- QNA
ALTER TABLE QNA
	ADD CONSTRAINT PK_QNA -- QNA �⺻Ű
		PRIMARY KEY (
			QANO -- ������ȣ
		);

ALTER TABLE QNA
	MODIFY COLUMN QANO INTEGER NOT NULL AUTO_INCREMENT COMMENT '������ȣ';

-- ��������
CREATE TABLE CURR (
	EDNO INTEGER      NOT NULL COMMENT '����������ȣ', -- ����������ȣ
	TITL VARCHAR(255) NOT NULL COMMENT '������', -- ������
	CONT MEDIUMTEXT   NOT NULL COMMENT '����' -- ����
)
COMMENT '��������';

-- ��������
ALTER TABLE CURR
	ADD CONSTRAINT PK_CURR -- �������� �⺻Ű
		PRIMARY KEY (
			EDNO -- ����������ȣ
		);

-- �������� ����ũ �ε���
CREATE UNIQUE INDEX UIX_CURR
	ON CURR ( -- ��������
		TITL ASC -- ������
	);

ALTER TABLE CURR
	MODIFY COLUMN EDNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '����������ȣ';

-- ���ǻ���
CREATE TABLE CR_PIC (
	CRPNO    INTEGER      NOT NULL COMMENT '���ǻ�����ȣ', -- ���ǻ�����ȣ
	PIC_PATH VARCHAR(255) NOT NULL COMMENT '����', -- ����
	CRNO     INTEGER      NOT NULL COMMENT '���ǹ�ȣ' -- ���ǹ�ȣ
)
COMMENT '���ǻ���';

-- ���ǻ���
ALTER TABLE CR_PIC
	ADD CONSTRAINT PK_CR_PIC -- ���ǻ��� �⺻Ű
		PRIMARY KEY (
			CRPNO -- ���ǻ�����ȣ
		);

ALTER TABLE CR_PIC
	MODIFY COLUMN CRPNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '���ǻ�����ȣ';

-- �ּ�
CREATE TABLE ADDR (
	ARNO     INTEGER      NOT NULL COMMENT '�ּҹ�ȣ', -- �ּҹ�ȣ
	PST_NO   VARCHAR(10)  NOT NULL COMMENT '�����ȣ', -- �����ȣ
	BAS_ADDR VARCHAR(255) NOT NULL COMMENT '�⺻�ּ�' -- �⺻�ּ�
)
COMMENT '�ּ�';

-- �ּ�
ALTER TABLE ADDR
	ADD CONSTRAINT PK_ADDR -- �ּ� �⺻Ű
		PRIMARY KEY (
			ARNO -- �ּҹ�ȣ
		);

ALTER TABLE ADDR
	MODIFY COLUMN ARNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '�ּҹ�ȣ';

-- ������������
CREATE TABLE CURR_SUBJ (
	EDNO INTEGER NOT NULL COMMENT '����������ȣ', -- ����������ȣ
	SBNO INTEGER NOT NULL COMMENT '�����ȣ' -- �����ȣ
)
COMMENT '������������';

-- ������������
ALTER TABLE CURR_SUBJ
	ADD CONSTRAINT PK_CURR_SUBJ -- ������������ �⺻Ű
		PRIMARY KEY (
			EDNO, -- ����������ȣ
			SBNO  -- �����ȣ
		);

-- ���Ǽ�����
CREATE TABLE LECT_STUD (
	LNO INTEGER NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	MNO INTEGER NOT NULL COMMENT '�л���ȣ' -- �л���ȣ
)
COMMENT '���Ǽ�����';

-- ���Ǽ�����
ALTER TABLE LECT_STUD
	ADD CONSTRAINT PK_LECT_STUD -- ���Ǽ����� �⺻Ű
		PRIMARY KEY (
			LNO, -- ���ǹ�ȣ
			MNO  -- �л���ȣ
		);

-- ���ǹ���
CREATE TABLE LECT_TCHR (
	LNO INTEGER NOT NULL COMMENT '���ǹ�ȣ', -- ���ǹ�ȣ
	MNO INTEGER NOT NULL COMMENT '�����ȣ' -- �����ȣ
)
COMMENT '���ǹ���';

-- ���ǹ���
ALTER TABLE LECT_TCHR
	ADD CONSTRAINT PK_LECT_TCHR -- ���ǹ��� �⺻Ű
		PRIMARY KEY (
			LNO, -- ���ǹ�ȣ
			MNO  -- �����ȣ
		);

-- MEMB
CREATE TABLE TABLE16 (
	MNO      INTEGER      NOT NULL COMMENT 'ȸ����ȣ', -- ȸ����ȣ
	NAME     VARCHAR(30)  NOT NULL COMMENT '�̸�', -- �̸�
	TEL      VARCHAR(30)  NOT NULL COMMENT '��ȭ', -- ��ȭ
	EMAIL    VARCHAR(40)  NOT NULL COMMENT '�̸���', -- �̸���
	DET_ADDR VARCHAR(255) NULL     COMMENT '���ּ�', -- ���ּ�
	PIC_PATH VARCHAR(255) NULL     COMMENT '����', -- ����
	LST_SCHL VARCHAR(10)  NULL     COMMENT '�����з�', -- �����з�
	SCHL_NM  VARCHAR(30)  NULL     COMMENT '�б���', -- �б���
	ARNO     INTEGER      NULL     COMMENT '�ּҹ�ȣ' -- �ּҹ�ȣ
)
COMMENT 'MEMB';

-- MEMB
ALTER TABLE TABLE16
	ADD CONSTRAINT PK_TABLE16 -- MEMB �⺻Ű
		PRIMARY KEY (
			MNO -- ȸ����ȣ
		);

-- MEMB ����ũ �ε���
CREATE UNIQUE INDEX UIX_TABLE16
	ON TABLE16 ( -- MEMB
		EMAIL ASC -- �̸���
	);

-- MEMB �ε���
CREATE INDEX IX_TABLE16
	ON TABLE16( -- MEMB
		NAME ASC -- �̸�
	);

ALTER TABLE TABLE16
	MODIFY COLUMN MNO INTEGER NOT NULL AUTO_INCREMENT COMMENT 'ȸ����ȣ';

-- ����
ALTER TABLE LECT
	ADD CONSTRAINT FK_CURR_TO_LECT -- �������� -> ����
		FOREIGN KEY (
			EDNO -- ����������ȣ
		)
		REFERENCES CURR ( -- ��������
			EDNO -- ����������ȣ
		);

-- ����
ALTER TABLE LECT
	ADD CONSTRAINT FK_CROOM_TO_LECT -- ���� -> ����
		FOREIGN KEY (
			CRNO -- ���ǹ�ȣ
		)
		REFERENCES CROOM ( -- ����
			CRNO -- ���ǹ�ȣ
		);

-- ����
ALTER TABLE LECT
	ADD CONSTRAINT FK_MGR_TO_LECT -- �Ŵ��� -> ����
		FOREIGN KEY (
			MNO -- �Ŵ�����ȣ
		)
		REFERENCES MGR ( -- �Ŵ���
			MNO -- �Ŵ�����ȣ
		);

-- �л�
ALTER TABLE STUD
	ADD CONSTRAINT FK_TABLE16_TO_STUD -- MEMB -> �л�
		FOREIGN KEY (
			MNO -- �л���ȣ
		)
		REFERENCES TABLE16 ( -- MEMB
			MNO -- ȸ����ȣ
		);

-- ����
ALTER TABLE TCHR
	ADD CONSTRAINT FK_TABLE16_TO_TCHR -- MEMB -> ����
		FOREIGN KEY (
			MNO -- �����ȣ
		)
		REFERENCES TABLE16 ( -- MEMB
			MNO -- ȸ����ȣ
		);

-- �Ŵ���
ALTER TABLE MGR
	ADD CONSTRAINT FK_TABLE16_TO_MGR -- MEMB -> �Ŵ���
		FOREIGN KEY (
			MNO -- �Ŵ�����ȣ
		)
		REFERENCES TABLE16 ( -- MEMB
			MNO -- ȸ����ȣ
		);

-- �Խ���
ALTER TABLE BOARD
	ADD CONSTRAINT FK_TABLE16_TO_BOARD -- MEMB -> �Խ���
		FOREIGN KEY (
			MNO -- ȸ����ȣ
		)
		REFERENCES TABLE16 ( -- MEMB
			MNO -- ȸ����ȣ
		);

-- �ڷ��
ALTER TABLE FBOARD
	ADD CONSTRAINT FK_TABLE16_TO_FBOARD -- MEMB -> �ڷ��
		FOREIGN KEY (
			MNO -- ȸ����ȣ
		)
		REFERENCES TABLE16 ( -- MEMB
			MNO -- ȸ����ȣ
		);

-- QNA
ALTER TABLE QNA
	ADD CONSTRAINT FK_TABLE16_TO_QNA -- MEMB -> QNA
		FOREIGN KEY (
			MNO -- ȸ����ȣ
		)
		REFERENCES TABLE16 ( -- MEMB
			MNO -- ȸ����ȣ
		);

-- ���ǻ���
ALTER TABLE CR_PIC
	ADD CONSTRAINT FK_CROOM_TO_CR_PIC -- ���� -> ���ǻ���
		FOREIGN KEY (
			CRNO -- ���ǹ�ȣ
		)
		REFERENCES CROOM ( -- ����
			CRNO -- ���ǹ�ȣ
		);

-- ������������
ALTER TABLE CURR_SUBJ
	ADD CONSTRAINT FK_CURR_TO_CURR_SUBJ -- �������� -> ������������
		FOREIGN KEY (
			EDNO -- ����������ȣ
		)
		REFERENCES CURR ( -- ��������
			EDNO -- ����������ȣ
		);

-- ������������
ALTER TABLE CURR_SUBJ
	ADD CONSTRAINT FK_SUBJ_TO_CURR_SUBJ -- ���� -> ������������
		FOREIGN KEY (
			SBNO -- �����ȣ
		)
		REFERENCES SUBJ ( -- ����
			SBNO -- �����ȣ
		);

-- ���Ǽ�����
ALTER TABLE LECT_STUD
	ADD CONSTRAINT FK_LECT_TO_LECT_STUD -- ���� -> ���Ǽ�����
		FOREIGN KEY (
			LNO -- ���ǹ�ȣ
		)
		REFERENCES LECT ( -- ����
			LNO -- ���ǹ�ȣ
		);

-- ���Ǽ�����
ALTER TABLE LECT_STUD
	ADD CONSTRAINT FK_STUD_TO_LECT_STUD -- �л� -> ���Ǽ�����
		FOREIGN KEY (
			MNO -- �л���ȣ
		)
		REFERENCES STUD ( -- �л�
			MNO -- �л���ȣ
		);

-- ���ǹ���
ALTER TABLE LECT_TCHR
	ADD CONSTRAINT FK_LECT_TO_LECT_TCHR -- ���� -> ���ǹ���
		FOREIGN KEY (
			LNO -- ���ǹ�ȣ
		)
		REFERENCES LECT ( -- ����
			LNO -- ���ǹ�ȣ
		);

-- ���ǹ���
ALTER TABLE LECT_TCHR
	ADD CONSTRAINT FK_TCHR_TO_LECT_TCHR -- ���� -> ���ǹ���
		FOREIGN KEY (
			MNO -- �����ȣ
		)
		REFERENCES TCHR ( -- ����
			MNO -- �����ȣ
		);

-- MEMB
ALTER TABLE TABLE16
	ADD CONSTRAINT FK_ADDR_TO_TABLE16 -- �ּ� -> MEMB
		FOREIGN KEY (
			ARNO -- �ּҹ�ȣ
		)
		REFERENCES ADDR ( -- �ּ�
			ARNO -- �ּҹ�ȣ
		);
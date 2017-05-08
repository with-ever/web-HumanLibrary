INSERT INTO
  `ROLES` (`ROLE`, `DESC`) VALUES
  	('ADMIN', '관리자'),
	('HUMAN_BOOK', '휴먼북'),
	('SUBSCRIBER', '구독자');

INSERT INTO -- Parent Category 레코드
	`CATEGORY` (`ID`,`CATEGORY_NAME`,`DESC`) VALUES
	('1','NEIGHBOROOD/COMMUNITY','이웃/커뮤니티'),
	('2','ECONOMY/ADMINISTARATION','경제/경영'),
	('3','FINANCE/INVESTMENT','금융/재테크'),
	('4','VOLUNTARY SERVICE','봉사활동'),
	('5','BROADCASTING/PRESS','방송/언론'),
	('6','MEDICAL','의료인'),
	('7','CULTURE/ARTIST/PHYSICAL','문화/예술/체육'),
	('8','WELFARE','복지상담'),
	('9','SOCIAL MOVEMENT','사회운동'),
	('10','LIFE','인생동행'),
	('11','CIVIL SERVANT','공무원'),
	('12','POLITICIAN/POLITICAL PARTY','정치/정당'),
	('13','JURIST','법조인'),
	('14','RELIGIONIST','종교인'),
	('15','EDUCATOR','교육인'),
	('16','OVERSEAS ACTIVITY','해외활동'),
	('17','HOBBY/HEALING/LEISURE','취미/힐링/여가활동'),
	('18','ACADEMIC/PROFESSOR','학술인/교수'),
	('19','POP CULTURE/ENTERTAINER','환경/동,식물'),
	('20','IT/TECHNOLOGY','IT/기술'),
	('21','LIBRARY','도서관'),
	('22','HUMANLIBRARY STAFF','휴먼라이브러리 직원');
	
INSERT INTO --Sub Category 레코드
	`CATEGORY` (`CATEGORY_NAME`, `DESC`, `PARENT_CATEGORY_ID`) VALUES
	-- 이웃/커뮤니티
	('LIFE EXPERT/TECHNICAL TALENT','생달달인/기술재능','1'),
	('COMMUNITY ACTIVIST','지역공동체 활동가','1'),
	('RETIRED WORKER','전직 직장인','1'),
	('HOUSEWIFE','주부','1'),
	('LOCAL CENTER LECTURER','지역센터 강사','1'),
	('HEALTH CARE','건강관리','1'),
	
	-- 경제/경영
	('ECONOMIST','경제전문가','2'),
	('BUSINESSMAN','기업인','2'),
	('CEO','CEO','2'),
	('TAX ACCOUNTANT/ACCOUNTANT','세무/회계사','2'),
	('PATENT ATTORNEY/CUSTOMS AGENT','변리사/관세사','2'),
	('SELFEMPLOYED','일반 자영업자','2'),
	('SOCIAL ENTERPRISE','사회적 기업','2'),
	
	-- 금융/재테크
	('STOCK','증권','3'),
	('BANK','은행','3'),
	('PROPERTY','부동산','3'),
	('INSSURANCE','보험','3'),
	('ASSET MANAGEMENT','자산관리','3'),
	
	-- 봉사활동
	('OLD PEOPLE','노인 봉사','4'),
	('DISABILITY','장애인 봉사','4'),
	('CHILDREN','어린이 봉사','4'),
	('YOUTH','청소년 봉사','4'),
	('COMMUNITY','일반 사회 봉사','4'),
	('GLOBAL','해외/국제 봉사','4'),
	
	-- 방송/언론
	('NEWSPAPER STAFF','신문사 종사자','5'),
	('BROADCASTING STAFF','방송사 종사자','5'),
	('LOCAL NEWSPAPER','지역신문','5'),
	('LOCAL NEWSPAPER STAFF','지역신문 종사자','5'),
	('INTERNET BRAODCASTING STAFF','인터넷방송 종사자','5'),
	('BROADCASTING WRITER','방송작가','5'),
	('BROADCASTING ENGINEER','방송기술자','5'),
	('BROADCASTING STAFF','방송 스탭','5'),
	
	-- 의료인
	('DOCTOR','의사','6'),
	('HERB DOCTOR','한의사','6'),
	('PHARMACIST','약사','6'),
	('NURSE','간호사','6'),
	('PHYSICAL THERAPOST','물리치료사','6'),
	('FOLK REMEDY','치기공사','6'),
	('FOLK REMEDY','기타','6'),
	
	-- 문화/예술/체육
	('AUTHOR','작가','7'),
	('ART','미술','7'),
	('PHOTO','사진','7'),
	('MUSIC','음악','7'),
	('DANCE','무용','7'),
	('PLAY/MOVIE','연극/영화','7'),
	('CARTOON/ANIMATION','만화/애니메이션','7'),
	('ARCHITECTURE','건축','7'),
	('ENTERTAINER','엔터테이너','7'),
	('CHEF/PATISSIER','전문요리사/파티쉐','7'),
	('SPORTS ATHLETE','스포츠선수','7'),
	('MAGICIAN','마술사','7'),
	('BEAUTICIAN','미용사','7'),
	('TRADITIONAL CULTURE','전통문화','7'),
	
	-- 복지상담
	('SOCIAL WORKER','사회복지사','8'),
	('YOUTH FIELD SPECIALIST/COUNSELOR','청소년지도사/상담사','8'),
	('CARER','간병인','8'),
	('WELFARE WORKER','복지도우미','8'),
	('HANDICAPPED WELFARE','장애인 복지','8'),
	('COUNSEL SERVICE','상담봉사','8'),
	
	-- 사회운동
	('LABOR ACTIVIST','노동 운동가','9'),
	('FARMER ACTIVIST','농민 운동가','9'),
	('POOR ACTIVIST','빈민 운동가','9'),
	('CIVIL CAMPAIGNER','시민 운동가','9'),
	('ENVIRONMENTALIST','환경 운동가','9'),
	('FEMINIST','여성 운동가','9'),
	
	-- 인생동행
	('MULTI-CULTURAL FAMILY','다문화가족','10'),
	('ADOPTIVE FAMILY','입양가족','10'),
	('DISABLED PERSON','장애인','10'),
	('HOME-SCHOOLING FAMILY','홈스쿨링가족','10'),
	('SEXUAL MINORITY','성적소수자','10'),
	('NORTH KOREAN DEFECTOR','새터민','10'),
	('REFUGEE/CONSCIENTIOUS OBJECTOR','법적난민/망명객','10'),
	('FOREIGN WORKER','외국국적 노동자','10'),
	('SINGLE MOTHER','미혼모','10'),
	
	-- 공무원
	('FIREFIGHTER','소방관','11'),
	('POLICE OFFICER','경찰관','11'),
	('SOLDIER','군인','11'),
	('ADMINISTRATIVE PUBLIC OFFICIAL','행정공무원','11'),
	('PUBLIC OFFICIAL','행정분야 외 공무원','11'),
	('RETIRED PUBLIC OFFCIAL','퇴직공무원','11'),
	
	-- 정치/정당
	('CONGRESSMAN','국회의원','12'),
	('COUNCILMAN','시의원','12'),
	('DISTRICT DELEGATE','구의원','12'),
	('LOCAL GOVERNMENT HEAD','자치단체장','12'),
	('POLITICAL PARTY','정당인','12'),
	
	-- 법조인
	('LAWYER','변호사','13'),
	('JUDGE','판사','13'),
	('PROSECUTOR','검사','13'),
	('LEGAL STAFF','법무사','13'),
	('PURSER','사무장','13'),
	
	-- 종교인
	('PROTESTANTISM','개신교','14'),
	('CATHOLICISM','천주교','14'),
	('BUDDHISM','불교','14'),
	('MINORITY RELIGION','소수종교','14'),
	('SHAMANISM','무속인','14'),
	
	-- 교육인
	('PRIMARY AND INTERMEDIATE SCHOOL TEACHER','초중고교사','15'),
	('ALTERNATIVE SCHOOL TEACHER','대안학교교사','15'),
	('DISABLED SCHOOL TEACHER','장애인학교교사','15'),
	('VOCATIONAL SCHOOL TEACHER','실업학교교사','15'),
	('CHILDCARE CENTER TEACHER','놀이방','15'),
	('KINDERGARTEN TEACHER','유치원 교사','15'),
	('RETIREMENT TEACHER','퇴직교사','15'),
	('LIFE COURSE LECTURER','생활강좌강사','15'),
	
	-- 해외활동
	('OVERSEAS DIPLOMATIC OFFICE','해외 공관경험','16'),
	('OVERSEAS SUPERIOR','해외 상사경험','16'),
	('WORKING HOLIDAY/LANGUAGE STUDY','워킹홀리데이/어학연수','16'),
	('FOREIGN STAY','외국 체류 생활경험','16'),
	
	-- 취미/힐링/여가활동
	('FOOD','음식','17'),
	('HANDICRAFT','수공예','17'),
	('TRAVEL(BACKPACKING, WILD)','여행(배낭여행, 오지체험)','17'),
	('LEISURE(AMATEUR)/CAMPING','레저(아마추어)/캠핑','17'),
	('SPORT FOR ALL','생활체육','17'),
	('DISABLED SPORTS','장애인 스포츠','17'),
	('AGRICULTURE','농업','17'),

	-- 교수/학술인
	('NATURAL SCIENCE','자연과학','18'),
	('SOCIAL SCIENCE','사회과학','18'),
	('ENGINEERING','각종 공학','18'),
	('HUMANITIES/RELIGION','인문학/종교','18'),
	('ART/MUSIC/PHYSICAL','예체능계','18'),
	
	-- 환경/동,식물
	('ANIMAL','동물(사육사, 동물원, 애견)','19'),
	('PLANTS','식물(숲해설사, 조경사, 작목, 식물원)','19'),
	('ENVIRONMENT GROUP STAFF','환경단체 소속인','19'),
	
	-- IT/기술
	('PROGRAMMER','프로그래머','20'),
	('ENGINEER','엔지니어','20'),
	('WEB DESIGNER','웹 디자이너','20'),
	('MOBILE DEVELOPER','스마트폰 개발자','20'),
	('DB PRODUCER','DB 제작자','20'),
	('WEB DEVELOPER','웹 개발자','20'),
	('SERVER ADMINISTRATION','서버 관리자','20'),
	
	-- 도서관
	('PUBLIC LIBRARY LIBRARIAN','공공도서관 사서','21'),
	('UNIVERSITY LIBRARY LIBRARIAN','대학도서관 사서','21'),
	('SCHOOL LIBRARY LIBRARIAN','학교도서관 사서','21'),
	('CHILD/YOUTH LIBRARY LIBRARIAN','어린이/청소년 도서관 사서','21'),
	('SMALL LIBRARY LIBRARIAN','작은 도서관 사서','21'),
	('SPECIAL LIBRARY LIBRARIAN','특수/전문 도서관 사서','21');
	-- 휴먼라이브러리 직원

INSERT INTO `HUMANBOOK` (`id`, `user_id`, `title`, `main_career`, `service_time`, `parent_category`, `sub_category`, `state`, `create_time`, `update_time`)
VALUES
	(1,'seung01','hello','WithEver','ALL','20','123','ACCEPT',170324,170324),
	(2,'seung03','WORLD','NBP','AM','19','120','ACCEPT',170327,170327),
	(3,'yeon01','hi','NAVER','PM','1','1','WAITING',170327,170327),
	(4,'kim10','Hey there','Gabia','ALL','18','119','CANCEL',170330,170330),
	(5,'kim11','WORLD','HELLO WORLD','ALL','7','40','ACCEPT',170330,170330),
	(7,'kim01','what is jQuery','NHN ent.','AM','1','4','ACCEPT',170120,170120),
	(8,'park01','what is ajax','Oracle','PM','2','12','WAITING',170121,170120),
	(9,'song01','about Spring Framework','Coupang','ALL','3','15','ACCEPT',170122,170122),
	(10,'yoon01','what is Spring','Tmon','PM','4','19','ACCEPT',170123,170123),
	(11,'jung01','What your hobby','Samsunng','AM','5','25','ACCEPT',170124,170201),
	(12,'lee01','What is apple','Apple','ALL','6','33','WAITING',170125,170201),
	(13,'park02','Bowling','LG','ALL','7','38','ACCEPT',170126,170201),
	(14,'park03','When you\'re upset','Hyundai','AM','8','53','ACCEPT',170127,170215),
	(15,'kim02','when you\'re tired','ebay','PM','9','60','ACCEPT',170128,170215),
	(16,'jung02','Kakao\'s Future','Kakao','AM','10','66','ACCEPT',170129,170215),
	(17,'lee02','what is javascript','Daum','AM','11','75','ACCEPT',170130,170215),
	(18,'kim03','Life Tip','Raon Secure','AM','12','81','CANCEL',170131,170215),
	(19,'park04','What is your dream','Kakao Pay','PM','13','86','WAITING',170201,170215),
	(20,'kim04','How to take pics','Snow','AM','14','91','ACCEPT',170202,170215),
	(21,'jung03','when you\'re sad','Camp Mobile','AM','15','96','ACCEPT',170203,170215),
	(22,'kim05','Good Travler','Works Mobile','PM','16','104','WAITING',170204,170220),
	(23,'park05','Talk with stranger','Naver Labs','ALL','17','108','ACCEPT',170205,170220),
	(24,'kim06','how are they work in SDS','Samsung SDS','AM','18','115','ACCEPT',170206,170220),
	(25,'jung04','How to work in google','Google korea','PM','19','122','ACCEPT',170207,170220),
	(26,'kim07','About AWS','Amazon','PM','20','129','ACCEPT',170208,170220),
	(27,'lee03','Game','NC Soft','PM','21','123','ACCEPT',170209,170220),
	(28,'lee04','Travling to Jungle','Hancom Secure','AM','1','4','ACCEPT',170210,170220),
	(29,'kim08','what is naver i&s','Naver I&S','AM','2','7','ACCEPT',170211,170301),
	(30,'jung05','The Future','NHN Technology Service','AM','3','18','ACCEPT',170212,170301),
	(31,'park06','Hungry','NIT','PM','5','32','ACCEPT',170213,170301),
	(32,'kim09','Shopping with wmp','We Make Price','ALL','10','71','ACCEPT',170214,170301),
	(33,'park07','Fired Noodle','Auction','AM','13','90','ACCEPT',170215,170301);
	
	
INSERT INTO BOARD
	  (ID, `TYPE`, CREATE_TIME, UPDATE_TIME, SUBJECT, CONTENTS, VIEWS, USER_ID) VALUES
	  -- TYPE 'MP' 주요프로그램
	  (0,'MP', 1490258697, 1490258697,'주요프로그램 제목','주요프로그램 내용',1,1),
	  -- TYPE 'PT' 게시물 
	  (0,'PT', 1490258697, 1490258697,'게시물 제목','게시물 내용',1,1),
	  -- TYPE 'NT' 공지사항
	  (0,'NT', 1490258697, 1490258697,'공지사항 제목','공지사항 내용',1,1);

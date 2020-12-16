-- loaded by spring boot into H2 DB at test and application start time

INSERT INTO PUBLISHERS (  NAME, PHONE   )
values( 'Manning' ,'(425) 555-1212');

INSERT INTO PUBLISHERS (  NAME, PHONE   )
values( 'Apress' ,'(206) 555-1234');


INSERT INTO BOOKS (ISBN,  TITLE, AUTHOR_FIRST_NAME, AUTHOR_LAST_NAME,  GENRE,  PRICE, DESCRIPTION,  PUBLISHED_ON )
values('1430241071', 'Pro Spring 3'  ,        'Clarence',         'Ho', 'Java',  19.99,
       'Pro Spring 3  with the latest that the Spring Framework has to offer', '2020-7-04');

INSERT INTO BOOKS (ISBN, TITLE,AUTHOR_FIRST_NAME, AUTHOR_LAST_NAME,GENRE,  PRICE, DESCRIPTION,  PUBLISHED_ON )
values('161729120X', 'Spring In Action'  , 'Craig','Walls', 'Java',  29.99,
       'Spring in Action, Fourth Edition is a hands-on guide to the Spring Framework, ', '2020-8-05');

INSERT INTO BOOKS (ISBN, TITLE,  AUTHOR_FIRST_NAME, AUTHOR_LAST_NAME, GENRE,  PRICE, DESCRIPTION,  PUBLISHED_ON )
values('193239415X', 'Hibernate In Action'  , 'Christian','Bauer', 'Java',  9.99,
       'Hibernate in Action  explains all the concepts you need', '2020-10-04');

INSERT INTO BOOKS (ISBN,  TITLE,   AUTHOR_FIRST_NAME, AUTHOR_LAST_NAME,   GENRE,  PRICE, DESCRIPTION,  PUBLISHED_ON )
values('1931520720', 'Stories of Your Life and Others'  , 'Ted ',' Chiang', 'Science Fiction',  12.25,
       ' includes his first eight published stories plus the author''s story notes ', '2020-11-11');

INSERT INTO NEWS (TITLE,  AUTHOR, PUBLISH_DATE,   DESCRIPTION,  CONTENT, IMAGE )
values('逆势突围、攻坚克难，中国经济凭啥不掉链', '新华社', '2020-12-16','2020年即将过去。这一年，新冠肺炎疫情全球蔓延，外部不稳定不确定因素较多，经济下行压力持续加大，极不寻常。风险挑战下，中国发展如何攻坚克难、行稳致远，令世人瞩目。', '加强基础工艺、关键材料、核心技术创新，加快推进新基建，提速5G与工业互联网的融合……夯实工业和数字基础，力度更甚。我们将围绕筑牢产业基础和提升产业链现代化水平出台更多具体措施，促进更多创新要素聚集，服务高质量发展。工信部新闻发言人黄利斌说。',
       'https://p6-tt.byteimg.com/origin/pgc-image/1e147a49e78b4bd0bec66291398778a6');

INSERT INTO NEWS (TITLE,  AUTHOR, PUBLISH_DATE,   DESCRIPTION,  CONTENT, IMAGE )
values('我没给你们留下什么财富，但给你们留了个好名声', '党史博采'  , '2020-12-01',' 习仲勋是中国共产党的优秀党员，伟大的共产主义战士，杰出的无产阶级革命家，我党、我军卓越的政治工作领导人，他不仅为中国人民的解放事业和社会主义建设、改革事业做出了杰出贡献，而且以老一辈无产阶级革命家的优良家庭、家教、家风，给当代中国共产党人留下了一份宝贵的精神财富', '在《给爸爸八十八周岁生日的贺信》中，习近平感情至深地谈到，希望从父亲那里继承和吸取做人、做事、对信仰的执着追求、赤子情怀、俭朴生活等五个方面的高尚品质，并把这些可贵的品质概括为这是一个堪称楷模的老布尔什维克和共产党人的家风。今天，重温习仲勋同志的家风，一是能够彰显老一辈共产党人的人格风范，二是能够在全体党员干部中树立榜样，为全面从严治党提供强大的精神力量。',
       'https://p6-tt.byteimg.com/origin/pgc-image/029bdde2c85a49f3b737295f2eb9c8c7');

INSERT INTO NEWS (TITLE,  AUTHOR, PUBLISH_DATE,   DESCRIPTION,  CONTENT, IMAGE )
values('梦耀九天创奇迹', '科技日报', '2020-12-14','征高轨、闯世界、探深空、举北斗、顶风云……组建50年来，西昌卫星发射中心取得了一个又一个中国航天第一，创造了一个又一个世界航天首次。50年的实践充分证明，西昌航天善于创造奇迹，更敢于创造奇迹。', '举世瞩目的沧桑巨变，在几代人青春与汗水的浇灌下，革命先辈曾无限憧憬的“可爱的中国在世界东方巍然屹立，筑牢中国自信的坚实基石。坐标系上，另一条代表中国航天快速发展的曲线，随着一颗颗航天器、一枚枚新火箭的成功发射而不断向上延伸。两条曲线的交会处，清晰可见嫦娥,北斗,风云,天问……见证着伟大祖国的繁荣富强，也见证着西昌航天的能力跃升。',
       'https://p3-tt.byteimg.com/origin/pgc-image/95c325d8fc6146ac934326ca13b66ece');

INSERT INTO USERS (USER_NAME,   FIRST_NAME, LAST_NAME,  ACTIVE_SINCE )
            values('credmond', 'Conor'  , 'Redmond', '2014-12-31' );

INSERT INTO USERS (USER_NAME,   FIRST_NAME, LAST_NAME,  ACTIVE_SINCE )
            values('jhackett', 'Jack'  ,    'Hackett',   '2014-02-28' );

INSERT INTO USERS (USER_NAME,   FIRST_NAME, LAST_NAME,  ACTIVE_SINCE )
             values('dmcguire', 'Dougal'  ,    'McGuire',   '2014-07-04' );

INSERT INTO USERS (USER_NAME,   FIRST_NAME, LAST_NAME,  ACTIVE_SINCE )
            values('tcrilly', 'Ted'  , 'Crilly', '2011-12-31');


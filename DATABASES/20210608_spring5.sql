--SQL쿼리 페이징을 구현해서 변수로 삼을것을 정의
--PageVO의 멤버변수로 사용예정 -> 게시물 일때 ...
SELECT TableB.* FROM
(
    SELECT ROWNUM AS RNUM, TableA.* FROM
    (
        SELECT * FROM tbl_board
        WHERE board_type = 'notice' -- 게시물관리 다중게시판 검색때문에 추가한 코드
        and (title LIKE '%%'
        OR content LIKE '%%')
        ORDER BY reg_date DESC
    ) TableA WHERE ROWNUM <= (2*5)+5 -- 0부터 선택한 페이지까지 전부 출력 
) TableB WHERE TableB.RNUM > 2*5-- 한페이지당 보여줄 개수만 출력하는 역할
--쿼리에서 필요한 변수는 2개 
--현재 페이지 수의 변수  page*b == queryStartNo
--한 페이지당 보여줄 개수의 변수 b == queryPerPageNum
--PageVO에서 필요한 추가변수: page
--UI하단의 페이지 선택번호 출력할때 사용하는 변수(아래)
--perPagenum 변수를 받아서 StartPage,endPage 를 구해서 하단의 페이지 선택번호를 출력

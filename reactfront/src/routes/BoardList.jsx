import React, { useContext, useEffect } from "react";
import { Button, Col, Row, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import { BoardContext } from "../contexts/BoardContextProvider";
import Board from "../components/Board";
import PagingButtons from "../components/PagingButtons";

const BoardList = () => {
  const boardContext = useContext(BoardContext);
  console.log("컨텍스트", boardContext);
  const {
    states: { boards, page },
    actions: { getBoards },
  } = boardContext;

  useEffect(() => {
    getBoards();
  }, [page]); // page값이 변경될때마다 useEffect 콜백 호출

  return (
    <div>
      <Row>
        <Col>
          <h1>게시글 목록</h1>
          <div className="text-end mb-3">
            <Link to="/boards/createBoard">
              <Button>글쓰기</Button>
            </Link>
          </div>
          <Table striped bordered hover>
            <thead>
              <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일시</th>
              </tr>
            </thead>
            <tbody>
              {boards.map((board) => (
                <Board key={board.id} board={board} />
              ))}
            </tbody>
          </Table>
          <PagingButtons />
        </Col>
      </Row>
    </div>
  );
};

export default BoardList;

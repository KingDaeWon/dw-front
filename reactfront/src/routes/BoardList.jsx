import React, { useContext, useEffect } from "react";
import { Button, Col, Row, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import { BoardContext } from "../contexts/BoardContextProvider";
import Board from "../components/Board";

const BoardList = () => {
  const boardContext = useContext(BoardContext);
  console.log(boardContext);
  const {
    states: { boards },
    actions: { getBoards },
  } = boardContext;

  useEffect(() => {
    getBoards();
  }, []);

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
        </Col>
      </Row>
    </div>
  );
};

export default BoardList;

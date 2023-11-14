import React, { useContext, useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import { Button, Col, Form, FormControl, Row } from "react-bootstrap";
import { BoardContext } from "../contexts/BoardContextProvider";

const BoardUpdate = () => {
  const [board, setBoard] = useState({
    id: "",
    title: "",
    memberId: "",
    content: "",
  });
  const { id } = useParams();
  const {
    actions: { getBoard, updateBoard },
  } = useContext(BoardContext);
  useEffect(() => {
    getBoard(id).then((board) => setBoard(board));
  }, []);

  // getBoard

  const onFrmSubmit = (e) => {
    e.preventDefault();
    console.log("Updated Board Data:", board);
    updateBoard(board).then((board) => {
      console.log("수정완료", board);
    });
  };
  const onFrmChange = (e) => {
    setBoard({
      ...board,
      [e.target.name]: e.target.value,
    });
  };
  const { title, memberId, content } = board;

  return (
    <div>
      <Row>
        <Col>
          <h1>게시글 수정</h1>
          <Form onSubmit={onFrmSubmit}>
            <FormControl
              name="title"
              className="my-3"
              placeholder="제목"
              value={title}
              onChange={onFrmChange}
            ></FormControl>
            <FormControl
              name="memberId"
              className="my-3"
              placeholder="작성자"
              value={memberId}
              onChange={onFrmChange}
            ></FormControl>
            <FormControl
              name="content"
              className="my-3"
              as="textarea"
              rows="5"
              placeholder="내용"
              value={content}
              onChange={onFrmChange}
            ></FormControl>
            <div className="text-center">
              <Button type="submit" className="me-3">
                등록
              </Button>
              <Link to={`/boards/detailBoard/${id}`}>
                <Button variant="secondary" className="me-3">
                  취소
                </Button>
              </Link>
            </div>
          </Form>
        </Col>
      </Row>
    </div>
  );
};

export default BoardUpdate;

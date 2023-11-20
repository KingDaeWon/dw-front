import React, { useContext, useState } from "react";
import { Button, Col, Form, FormControl, Row } from "react-bootstrap";
import { BoardContext } from "../contexts/BoardContextProvider";
import { useNavigate, Link, useParams } from "react-router-dom";

const BoardCreate = () => {
  const navigate = useNavigate();
  const {
    actions: { createBoard },
  } = useContext(BoardContext);
  const [frm, setFrm] = useState({
    title: "",
    memberId: "",
    content: "",
  });
  const onFrmChange = (e) => {
    setFrm({
      ...frm,
      [e.target.name]: e.target.value,
    });
  };
  const onFrmSubmit = (e) => {
    e.preventDefault();

    if (!validateForm()) {
      return;
    }

    createBoard(frm).then(() => navigate("/boards"));
  };

  const validateForm = () => {
    // 유효성검사
    const { title, memberId, content } = frm;

    if (!title.trim() || !memberId.trim() || !content.trim()) {
      alert("제목, 작성자, 내용은 필수 입력 항목입니다.");
      return false;
    }

    return true;
  };

  const { title, memberId, content } = frm;
  return (
    <div>
      <Row>
        <Col>
          <h1>게시글 등록</h1>
          <Form onSubmit={onFrmSubmit}>
            <FormControl
              name="title"
              className="my-3"
              placeholder="제목 입력해주세요"
              value={title}
              onChange={onFrmChange}
            ></FormControl>
            <FormControl
              name="memberId"
              className="my-3"
              placeholder="작성자 입력해주세요"
              value={memberId}
              onChange={onFrmChange}
            ></FormControl>
            <FormControl
              name="content"
              className="my-3"
              as="textarea"
              rows="5"
              placeholder="내용 입력해주세요"
              value={content}
              onChange={onFrmChange}
            ></FormControl>
            <div className="text-center">
              <Button type="submit" className="me-3">
                등록
              </Button>
              <Link to={"/boards"}>
                <Button variant="secondary">취소</Button>
              </Link>
            </div>
          </Form>
        </Col>
      </Row>
    </div>
  );
};

export default BoardCreate;

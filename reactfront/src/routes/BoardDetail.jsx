import React, { useContext, useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import { BoardContext } from "../contexts/BoardContextProvider";
import { Badge, Button, Card } from "react-bootstrap";

const BoardDetail = () => {
  // 경로변수
  const params = useParams();
  console.log(params);
  const { id } = params;

  const {
    actions: { getBoard },
  } = useContext(BoardContext);

  const [board, setBoard] = useState({
    id: "",
    title: "",
    memberId: "",
    content: "",
    createdAt: "",
  });

  useEffect(() => {
    getBoard(id).then((board) => {
      console.log(board);
      setBoard(board);
    });
  }, []);

  const { title, memberId, content, createdAt } = board;

  return (
    <div>
      <h1>게시글 상세보기</h1>
      <div className="my-2">
        <Link to={`/boards/updateBoard/${id}`}>
          <Button variant="outline-info">수정</Button>
        </Link>{" "}
        <Link>
          <Button variant="outline-danger">삭제</Button>
        </Link>
      </div>
      <Card className="text-center">
        <Card.Header>
          <Badge bg="primary">{id}</Badge>
        </Card.Header>
        <Card.Body>
          <Card.Title>{title}</Card.Title>
          <Card.Text>{content}</Card.Text>
        </Card.Body>
        <Card.Footer className="text-muted">
          Created on {createdAt} by {memberId}
        </Card.Footer>
      </Card>
    </div>
  );
};

export default BoardDetail;

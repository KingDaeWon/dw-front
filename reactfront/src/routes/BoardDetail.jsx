import React, { useContext, useEffect, useState } from "react";
import { useParams, Link, useNavigate } from "react-router-dom";
import { BoardContext } from "../contexts/BoardContextProvider";
import { Badge, Button, Card } from "react-bootstrap";

const BoardDetail = () => {
  const navigate = useNavigate();
  // 경로변수
  const params = useParams();
  console.log(params);
  const { id } = params;

  const {
    actions: { getBoard, deleteBoard },
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

  const onDelBtnClick = () => {
    if (window.confirm("정말 삭제하시겠습니까?")) {
      deleteBoard(id).then((response) => {
        console.log(response);
        navigate("/boards");
      });
    }
  };

  const { title, memberId, content, createdAt } = board;

  return (
    <div>
      <h1>게시글 상세보기</h1>
      <div className="my-2">
        <Link to={`/boards/updateBoard/${id}`}>
          <Button variant="outline-info">수정</Button>
        </Link>{" "}
        <Link>
          <Button variant="outline-danger" onClick={onDelBtnClick}>
            삭제
          </Button>
        </Link>{" "}
        <Link to={`/boards`}>
          <Button variant="secondary">목록으로</Button>
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
          작성일 {createdAt} by {memberId}
        </Card.Footer>
      </Card>
    </div>
  );
};

export default BoardDetail;

import React, { useContext, useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import { PostContext } from "../contexts/PostContextProvider";
import { Badge, Button, Card } from "react-bootstrap";

const PostDetail = () => {
  // 경로변수
  const params = useParams();
  console.log(params);
  const { id } = params;

  const {
    actions: { getPost },
  } = useContext(PostContext);

  const [post, setPost] = useState({
    id: "",
    title: "",
    writer: "",
    content: "",
    createdAt: "",
  });

  useEffect(() => {
    getPost(id).then((post) => {
      console.log(post);
      setPost(post);
    });
  }, []);

  const { title, writer, content, createdAt } = post;

  return (
    <div>
      <h1>게시글 상세보기</h1>
      <div className="my-2">
        <Link to={`/posts/update/${id}`}>
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
          Created on {createdAt} by {writer}
        </Card.Footer>
      </Card>
    </div>
  );
};

export default PostDetail;

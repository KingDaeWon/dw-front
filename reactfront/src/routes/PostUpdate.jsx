import React, { useContext, useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { Button, Col, Form, FormControl, Row } from "react-bootstrap";
import { PostContext } from "../contexts/PostContextProvider";

const PostUpdate = () => {
  const [post, setPost] = useState({
    id: "",
    title: "",
    writer: "",
    content: "",
  });
  const { id } = useParams();
  const {
    actions: { getPost, updatePost },
  } = useContext(PostContext);
  useEffect(() => {
    getPost(id).then((post) => setPost(post));
  }, []);

  // getPost

  const onFrmSubmit = (e) => {
    e.preventDefault();
    updatePost(post);
  };
  const onFrmChange = (e) => {
    setPost({
      ...post,
      [e.target.name]: e.target.value,
    });
  };
  const { title, writer, content } = post;

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
              name="writer"
              className="my-3"
              placeholder="작성자"
              value={writer}
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
              <Button variant="secondary">취소</Button>
            </div>
          </Form>
        </Col>
      </Row>
    </div>
  );
};

export default PostUpdate;

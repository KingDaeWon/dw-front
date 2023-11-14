import React from "react";
import { Link } from "react-router-dom";

const Board = ({ board }) => {
  // board가 존재하는지 확인 후 구조 분해
  const { id, title, memberId, createdAt } = board || {};

  return (
    <tr>
      <td>{id}</td>
      <td>
        {title}
        <Link to={`/boards/detailBoard/${id}`}>{title}</Link>
      </td>
      <td>{memberId}</td>
      <td>{createdAt}</td>
    </tr>
  );
};

export default Board;

import React, { useContext } from "react";
import { Button } from "react-bootstrap";
import { BoardContext } from "../contexts/BoardContextProvider";

const PagingButtons = () => {
  const {
    states: { page, totalPages },
    actions: { setPage },
  } = useContext(BoardContext);
  return (
    <div>
      <Button disabled={page === 0} onClick={() => setPage(page - 1)}>
        이전
      </Button>
      <span className="mx-3">
        {page + 1} / {totalPages}
      </span>
      <Button
        disabled={page + 1 === totalPages}
        onClick={() => setPage(page + 1)}
      >
        다음
      </Button>
    </div>
  );
};

export default PagingButtons;

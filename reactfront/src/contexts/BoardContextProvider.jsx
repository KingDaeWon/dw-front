import React, { createContext, useState } from "react";
import axios from "axios";

export const BoardContext = createContext(); //새로운 Context 객체를 생성하고, 이를 내보내어 외부에서 사용할 수 있게한다.

const BoardContextProvider = (props) => {
  const [boards, setBoards] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  const getBoards = () => {
    axios(`/boards?page=${page}`).then((response) => {
      console.log(response);
      const {
        // Back코드에서 Content:데이터목록, number: page -> number 속성 값을 page 변수에 할당(현재페이지번호)
        // totalElements: 총 게시물 수, totalPages: 전체 페이지 수
        content,
        number: page,
        totalElements,
        totalPages,
      } = response.data;
      setBoards(content);
      // setPage(page); // 이전/다음 연속 클릭시 버그방지
      setTotalPages(totalPages);
    });
  };
  const getBoard = async (id) => {
    return await axios(`/boards/${id}`).then((response) => response.data);
  };
  const createBoard = async (board) => {
    const response = await axios.post("/boards", board);
    console.log(response); // 201 Created - header.location
  };
  const updateBoard = async (board) => {
    return await axios.patch(`/boards/${board.id}`, board);
  };
  const deleteBoard = async (id) => {
    return await axios.delete(`/boards/${id}`);
  };

  // 실제 context에 의해 관리될 속성들 (상태값, 함수)
  const value = {
    states: {
      boards,
      page,
      totalPages,
    },
    actions: {
      getBoards,
      getBoard,
      createBoard,
      updateBoard,
      deleteBoard,
      setPage,
    },
  };
  return (
    <BoardContext.Provider value={value}>
      {props.children}
    </BoardContext.Provider>
  );
};

export default BoardContextProvider;

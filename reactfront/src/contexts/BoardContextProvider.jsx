import React, { createContext, useState } from "react";
import axios from "axios";

export const BoardContext = createContext(); //새로운 Context 객체를 생성하고, 이를 내보내어 외부에서 사용할 수 있게한다.

const BoardContextProvider = (props) => {
  const [boards, setboards] = useState([]);
  const getBoards = () => {
    axios("/boards").then((response) => {
      console.log(response);
      setboards(response.data);
    });
  };
  const getBoard = async (id) => {
    return await axios(`/boards/detailBoard/${id}`).then(
      (response) => response.data
    );
  };
  const createBoard = async (board) => {
    const response = await axios.post("/boards/createBoard", board);
    console.log(response); // 201 Created - header.location
  };
  const updateBoard = async (board) => {
    return await axios.patch(`/boards/updateBoard/${board.id}`, board);
  };
  const deleteBoard = async (id) => {
    await axios.delete(`/boards/deleteBoard/${id}`);
  };

  // 실제 context에 의해 관리될 속성들 (상태값, 함수)
  const value = {
    states: {
      boards,
    },
    actions: {
      getBoards,
      getBoard,
      createBoard,
      updateBoard,
      deleteBoard,
    },
  };
  return (
    <BoardContext.Provider value={value}>
      {props.children}
    </BoardContext.Provider>
  );
};

export default BoardContextProvider;

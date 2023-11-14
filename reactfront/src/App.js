import "./App.css";
import { Route, Routes } from "react-router-dom";
import Layout from "./layout/Layout";
import Home from "./routes/Home";
import BoardList from "./routes/BoardList";
import PageNotFound from "./routes/PageNotFound";
import BoardDetail from "./routes/BoardDetail";
import BoardCreate from "./routes/BoardCreate";
import BoardUpdate from "./routes/BoardUpdate";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="" element={<Home />} />
          <Route path="boards" element={<BoardList />} />
          <Route path="boards/detailBoard/:id" element={<BoardDetail />} />
          <Route path="boards/createBoard" element={<BoardCreate />} />
          <Route path="boards/updateBoard/:id" element={<BoardUpdate />} />
          <Route path="*" element={<PageNotFound />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;

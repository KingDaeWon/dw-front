import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import { BrowserRouter } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import BoardContextProvider from "./contexts/BoardContextProvider";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <BoardContextProvider>
        <App />
      </BoardContextProvider>
    </BrowserRouter>
  </React.StrictMode>
);

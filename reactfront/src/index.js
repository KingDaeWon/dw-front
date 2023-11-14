import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import { BrowserRouter } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import PostContextProvider from "./contexts/PostContextProvider";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <PostContextProvider>
        <App />
      </PostContextProvider>
    </BrowserRouter>
  </React.StrictMode>
);

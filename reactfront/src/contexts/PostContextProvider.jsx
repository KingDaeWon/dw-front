import React, { createContext, useState } from 'react'
import axios from 'axios';

export const PostContext = createContext();

const PostContextProvider = (props) => {
  const [posts, setPosts] = useState([]);
  const getPosts = () => {
    axios('/posts')
      .then((response) => {
        console.log(response);
        setPosts(response.data);
      });
  };
  const getPost = async (id) => {
    return await axios(`/posts/${id}`).then((response) => response.data);
  };
  const createPost = async (post) => {
    const response = await axios.post(`/posts`, post);
    console.log(response); // 201 Created - header.location
  };
  const updatePost = async (post) => {
    return await axios.patch(`/posts/${post.id}`, post);
  };
  const deletePost = () => {};

  // 실제 context에 의해 관리될 속성들 (상태값, 함수)
  const value = {
    states : {
      posts
    },
    actions: {
      getPosts,
      getPost,
      createPost,
      updatePost,
      deletePost
    }
  };
  return (
    <PostContext.Provider value={value}>
      {props.children}
    </PostContext.Provider>
  )
}

export default PostContextProvider
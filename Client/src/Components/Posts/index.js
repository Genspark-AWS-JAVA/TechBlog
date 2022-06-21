import React, { useState, useEffect } from "react";
import { Container } from "react-bootstrap";
import { Link } from 'react-router-dom'
import axios from "axios";

const Posts = () => {
  const [posts, setPosts] = useState([]);
  useEffect(() => {
    axios.get("http://localhost:8080").then((res) => {
      setPosts(res.data);
    });
  }, []);



  return (
    <Container>
      <div>
        {
          posts.map(data =>
            <div className="comments">
              <h1><Link className="titles" to={`/articles/${data.id}`}>{data.title}</Link></h1>
              {data.content.length < 1000 &&
                <p>{data.content}</p>
              }
              {data.content.length >= 1000 &&
                <p>Wow this user had a lot to say, <Link to={`/articles/${data.id}`}>open</Link> the post to find out!!</p>
              }

              <p>Comments(<span>{data.comments.length}</span>)</p>
            </div>

          )
        }
      </div>
    </Container>
  );
};

export default Posts;

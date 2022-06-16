import React, { useState, useEffect } from "react";
import { Form, Row, Col, Button } from "react-bootstrap";
import {Link} from 'react-router-dom'
import axios from "axios";

const Posts = () => {
  const [posts, setPosts] = useState([]);
  useEffect(() => {
    axios.get("http://localhost:8080").then((res) => {
      setPosts(res.data);
    });
  },[]);

  const commentCount = () => {
    if(posts.comments.length < 0){
      return <span>0</span>;
    } else{
      return <span>posts.comments.length</span>
    }
  }

  return (
    <div>
      <Form>
        <Row>
          <Col>
            <Form.Control placeholder="Tags, Author, etc" />
          </Col>
          <Col>
            <Button>Search</Button>
          </Col>
          <Col>
            <Button href="/new">Create New Post</Button>
          </Col>
        </Row>
      </Form>
      <div>
        {
            posts.map(data =>
                <div>
                     <h1><Link to={`/articles/${data.id}`}>{data.title}</Link></h1>
                     <p>{data.content}</p>
                     <p>Comments({commentCount})</p>
                </div>
                 
            )
            }
      </div>
    </div>
  );
};

export default Posts;

import React, { useState, useEffect, Component } from "react";
import { Form, Row, Col, Button } from "react-bootstrap";
import axios from "axios";

const Posts = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080").then((res) => {
      setPosts(res.data);
      console.log(posts);
    });
  },[]);

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
                     <h1>{data.title}</h1>
                     <p>{data.content}</p>
                     <Button>Comment</Button>
                </div>
                 
            )
            }
      </div>
    </div>
  );
};

export default Posts;

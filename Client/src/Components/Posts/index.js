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
    </div>
  );
};

export default Posts;

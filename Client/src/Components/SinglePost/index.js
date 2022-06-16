import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import { Row, Col, Button } from "react-bootstrap";

const SinglePost = () => {
  const article = useParams();
  const [post, setPost] = useState([]);
  const [comments, setComments] = useState([]);
  const [commentText, setCommentText] = useState("");

  useEffect(() => {
    const fetchData = async () => {
      try {
        const result = await axios.get(
          `http://localhost:8080/articles/${article._id}`
        );

        setPost(result.data[0]);
        setComments(result.data[0].comments);
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, []);

  const handleComment = (e) => {
    setCommentText(e.target.value);
  };

  const submitComment = (e) => {
    e.preventDefault();
    console.log(commentText);
    debugger
    if (commentText !== "") {
      axios
        .post(`http://localhost:8080/articles/${article._id}/comments`, {
          content: commentText,
        })
        .then(window.location.reload());
    } else {
      alert("please type something");
    }
  };

  return (
    <div>
      <Row>
        <Col>
          <h1>{post.title}</h1>
          <p>{post.content}</p>
        </Col>
      </Row>

      <Row>
        <Col>
          <h4>Add a comment!</h4>
        </Col>
        <Col>
          <textarea onChange={handleComment}></textarea>
        </Col>
        <Col>
          <Button onClick={submitComment}>Comment</Button>
        </Col>
      </Row>
      <div>
        {comments.map((data) => (
          <div>
            <h1>{data.content}</h1>
          </div>
        ))}
      </div>
    </div>
  );
};

export default SinglePost;

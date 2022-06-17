import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import { Row, Col, Button, Form } from "react-bootstrap";

const SinglePost = () => {
  const article = useParams();
  const [post, setPost] = useState([]);
  const [comments, setComments] = useState([]);
  const [commentText, setCommentText] = useState("");
  const [comId, setComId] = useState("");
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
    e.preventDefault();
    setCommentText(e.target.value);
  };

  const submitComment = (e) => {
    e.preventDefault();
    console.log(commentText);
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

  const handleDelete = (e) => {
    e.preventDefault();
    axios.delete(`http://localhost:8080/articles/${article._id}`);
  };
  // const handleComId = (e) => {
  //   setComId(e)
  // }
  // const handleCommentDel = (e) => {
  //   // e.preventDefault();
  //   axios.delete(`http://localhost:8080/comments/${comId}`);
  // };

  return (
    <div>
      <Row>
        <Col>
          <h1 className="titles">{post.title}</h1>
          <p className="comments">{post.content}</p>
        </Col>
      </Row>

      <Row>
        <Col>
          <h4 className="titles">Add a comment!</h4>
        </Col>
        <Col>
          <Form.Control
            onSubmit={submitComment}
            onChange={handleComment}
          ></Form.Control>
        </Col>
        <Col>
          <Button onClick={submitComment}>Comment</Button>
        </Col>
      </Row>
      <div>
        {comments.map((data) => (
          <div>
            {/* {setComId(data.id)} */}
            <h1 className="comments">{data.content}</h1>
            {/* <Button onClick={handleCommentDel} variant="danger">
              Delete Comment
            </Button> */}
          </div>
        ))}
      </div>
      <div>
        <Button onClick={handleDelete} variant="danger">
          Delete post
        </Button>
      </div>
    </div>
  );
};

export default SinglePost;

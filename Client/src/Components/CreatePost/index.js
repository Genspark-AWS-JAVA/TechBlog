import React, {useEffect, useState} from "react";
import { Form, Button } from "react-bootstrap";
import axios from "axios";

const CreatePost = () => {

    const[title, setTitle] = useState("")
    const[content, setContent] = useState("")

    const onTitleChange = (e) => {
        setTitle(e.target.value)
    }

    const onContentChange = (e) => {
        setContent(e.target.value)
    }

    const handleFormSubmit= () => {
        axios.post('http://localhost:8080/articles',{
            "title" : title,
            "content": content
        })
    }

  return (
    <div>
      <Form>
        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
          <Form.Label>Title</Form.Label>
          <Form.Control onChange={onTitleChange} type="text" placeholder="Your Title Here" />
        </Form.Group>
        <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
          <Form.Label>Content</Form.Label>
          <Form.Control onChange={onContentChange} as="textarea" rows={3} />
        </Form.Group>
        <Button type="submit" onClick={handleFormSubmit()}>Submit</Button>
      </Form>
    </div>
  );
};

export default CreatePost;

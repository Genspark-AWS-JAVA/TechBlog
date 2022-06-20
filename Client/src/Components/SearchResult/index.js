import React, { useState } from 'react';
import { Row, Col, Button, Form } from "react-bootstrap";
import axios from 'axios';

function SearchResult() {
  const [searchResult, setSearchResult] = useState([]);
  function handleSearchSubmit(e) {
    e.preventDefault();
    const search = document.getElementById('searchInput').value;
    axios.get(`http://localhost:8080/articles/search/${search}`).then((res) => {
      setSearchResult(res.data);
    });
  }

  return (
    <div>
      <Form onSubmit={handleSearchSubmit}>
        <Row>
          <Form.Group as={Col} controlId="search" >
            {/* <Form.Control placeholder="Tags, Keywords, etc" /> */}
            <input type="search" placeholder='Search' id='searchInput' />
            <Button type="submit">Search</Button>
          </Form.Group>
          <Col>
            <Button href="/new">Create New Post</Button>
          </Col>
        </Row>
      </Form>

      <div>
        {searchResult.map(data =>
          <div className="comments" key={data.id}>
            <h1>{data.title}</h1>
            <p>{data.content}</p>
          </div>
        )}
      </div>
    </div>
  );
}
export default SearchResult;
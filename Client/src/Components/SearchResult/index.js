import React, { useState } from 'react';
import { Row, Col, Button, Form, Container, Card } from "react-bootstrap";
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
    <Container>
      <Form onSubmit={handleSearchSubmit}>
        <Row>
          <Form.Group as={Col} controlId="search" >
            {/* <Form.Control placeholder="Tags, Keywords, etc" /> */}
            <input type="search" placeholder='Search' id='searchInput' />
            <Button type="submit">Search</Button>
          </Form.Group>
        </Row>
      </Form>

      <div>
        {searchResult.map(data =>
          <Card className="results" key={data.id}>
            <Card.Body>
              <a href={`articles/${data.id}`} className="stretched-link">
                <Card.Title>{data.title}</Card.Title>
              </a>
              <Card.Text>{data.content}</Card.Text>
            </Card.Body>
          </Card>
        )}
      </div>
    </Container>
  );
}
export default SearchResult;
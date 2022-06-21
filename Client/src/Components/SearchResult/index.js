import React, { useState } from 'react';
import { Row, Col, Button, Form, Container, Card, InputGroup, Toast } from "react-bootstrap";
import axios from 'axios';

function SearchResult() {
  const [EmptySearchInfo, setEmptySearchInfo] = useState(false);

  const toggleEmptySearchInfo = () => setEmptySearchInfo(!EmptySearchInfo);

  const [searchResult, setSearchResult] = useState([]);
  function handleSearchSubmit(e) {
    e.preventDefault();
    const search = document.getElementById('searchInput').value;
    if (search !== '') {
      axios.get(`http://localhost:8080/articles/search/${search}`).then((res) => {
        setSearchResult(res.data);
      });
    } else {
      setEmptySearchInfo(true);
    }
  }

  return (
    <Container>
      <Form onSubmit={handleSearchSubmit}>
        <Row>
          <Toast show={EmptySearchInfo} onClose={toggleEmptySearchInfo} bg="warning">
            <Toast.Header>

              <strong className="mr-auto">Search error</strong>
            </Toast.Header>
            <Toast.Body>Please enter search term!</Toast.Body>
          </Toast>
        </Row>
        <Row>
          <InputGroup as={Col} >
            <Form.Control type="search" placeholder='Search' id='searchInput' aria-label='search' />
            <Button type="submit">Search</Button>
          </InputGroup>
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
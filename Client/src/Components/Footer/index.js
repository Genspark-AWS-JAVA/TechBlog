import React from "react";
import { Container, Row } from "react-bootstrap";

const Footer = () => {
  return (
    <div className='footer'>
      <Container>
        <Row>
          <div className="col-md-6 text-muted">
            <p>
              <strong>Copyright &copy; 2022 </strong>
              <a href='https://github.com/Genspark-AWS-JAVA'>
                GenSpark-AWS-JAVA
              </a>
            </p>
          </div>
        </Row>
      </Container>
    </div>
  );

}

export default Footer
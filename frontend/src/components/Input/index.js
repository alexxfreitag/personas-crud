import React from 'react';
import { Container } from './styles';

const Input = ({ name, ...rest }) => {
  return (
    <Container>
      <input name={name} {...rest} autoComplete="off" />
    </Container>
  );
};

export default Input;

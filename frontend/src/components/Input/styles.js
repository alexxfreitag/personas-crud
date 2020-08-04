import styled from 'styled-components';

export const Container = styled.div`
  margin-bottom: 15px;
  border: 1px solid #00d3fb;
  border-radius: 3px;
  height: 45px;
  padding: 0 15px;
  font-size: 16px;
  display: flex;
  align-items: center;

  input {
    flex: 1;
    background: transparent;
    border: 0;
    color: #000;

    &::placeholder {
      font-style: italic;
      color: #666360;
    }
  }
`;

export const Error = styled.div``;
